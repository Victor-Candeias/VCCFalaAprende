package pt.vcc.falaaprende.parental

import android.content.Context

/** Consentimento local explícito e revogável; não comprova identidade ou idade. */
enum class ConsentState { NOT_GIVEN, GRANTED }

object ParentalConsentStore {
    private const val PREFS = "parental_consent"
    private const val KEY = "consent_granted"

    fun read(context: Context): ConsentState =
        if (context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getBoolean(KEY, false)) ConsentState.GRANTED else ConsentState.NOT_GIVEN

    fun save(context: Context, state: ConsentState) {
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putBoolean(KEY, state == ConsentState.GRANTED).apply()
    }
}
