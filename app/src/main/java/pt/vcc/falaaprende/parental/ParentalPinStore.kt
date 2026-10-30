package pt.vcc.falaaprende.parental

import android.content.Context
import java.security.SecureRandom
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import java.util.Base64

/** PIN local: PBKDF2 com salt; nunca guardar o PIN em texto simples. */
object ParentalPinStore {
    private const val PREFS = "parental_pin"
    private const val SALT = "salt"
    private const val HASH = "hash"
    private const val ITERATIONS = 210_000
    private const val PIN_LENGTH = 6
    private const val FAILURES = "failures"
    private const val LOCKED_UNTIL = "locked_until"
    private const val MAX_FAILURES = 5
    private const val LOCK_DURATION_MS = 60_000L

    fun isConfigured(context: Context): Boolean =
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .contains(HASH)

    fun isValidFormat(pin: String): Boolean =
        pin.length == PIN_LENGTH && pin.all { it in '0'..'9' }

    fun configure(context: Context, pin: String): Boolean {
        if (!isValidFormat(pin) || isConfigured(context)) return false
        val salt = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val hash = derive(pin, salt)
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putString(SALT, Base64.getEncoder().encodeToString(salt))
            .putString(HASH, Base64.getEncoder().encodeToString(hash)).apply()
        return true
    }

    fun verify(context: Context, pin: String): Boolean {
        val prefs = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        if (android.os.SystemClock.elapsedRealtime() < prefs.getLong(LOCKED_UNTIL, 0L)) return false
        if (!isValidFormat(pin)) return false
        val salt = prefs.getString(SALT, null) ?: return false
        val hash = prefs.getString(HASH, null) ?: return false
        val matches = try {
            val expected = Base64.getDecoder().decode(hash)
            val candidate = derive(pin, Base64.getDecoder().decode(salt))
            java.security.MessageDigest.isEqual(expected, candidate)
        } catch (_: IllegalArgumentException) { false }
        if (matches) {
            prefs.edit().remove(FAILURES).remove(LOCKED_UNTIL).apply()
        } else {
            val failures = prefs.getInt(FAILURES, 0) + 1
            val editor = prefs.edit()
            if (failures >= MAX_FAILURES) {
                editor.putInt(FAILURES, 0)
                    .putLong(LOCKED_UNTIL, android.os.SystemClock.elapsedRealtime() + LOCK_DURATION_MS)
            } else editor.putInt(FAILURES, failures)
            editor.apply()
        }
        return matches
    }

    fun remove(context: Context, pin: String): Boolean {
        if (!verify(context, pin)) return false
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().clear().apply()
        return true
    }

    private fun derive(pin: String, salt: ByteArray): ByteArray {
        val spec = PBEKeySpec(pin.toCharArray(), salt, ITERATIONS, 256)
        return try {
            SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).encoded
        } finally { spec.clearPassword() }
    }
}
