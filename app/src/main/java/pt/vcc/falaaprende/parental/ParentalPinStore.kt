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
        if (!isValidFormat(pin)) return false
        val prefs = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val salt = prefs.getString(SALT, null) ?: return false
        val hash = prefs.getString(HASH, null) ?: return false
        return try {
            val expected = Base64.getDecoder().decode(hash)
            val candidate = derive(pin, Base64.getDecoder().decode(salt))
            java.security.MessageDigest.isEqual(expected, candidate)
        } catch (_: IllegalArgumentException) { false }
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
