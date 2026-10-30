package pt.vcc.falaaprende.privacy

import android.content.Context
import org.json.JSONObject
import pt.vcc.falaaprende.parental.ParentalConsentStore
import pt.vcc.falaaprende.parental.ConsentState

/** Inventário e operações sobre os dados locais atualmente conhecidos. */
object PrivacyDataManager {
    private val technicalPreferences = listOf(
        "navigation_preferences", "child_theme_preferences",
        "dependency_status_snapshot", "room_diagnostic_snapshot",
        "ci_manual_checklist", "error_example", "architecture_selection",
        "build_version_history"
    )

    fun exportSummary(context: Context): String {
        val consent = ParentalConsentStore.read(context)
        return JSONObject().apply {
            put("schemaVersion", 1)
            put("application", "VCC Fala & Aprende")
            put("parentalConsent", consent.name)
            put("technicalPreferencesIncluded", false)
            put("note", "Resumo local; não inclui ficheiros, perfis ou conteúdo da base de dados.")
        }.toString(2)
    }

    /** Elimina preferências técnicas conhecidas e o consentimento local.
     * Não apaga automaticamente a base de dados Room nem ficheiros de áudio.
     */
    fun clearKnownPreferences(context: Context) {
        technicalPreferences.forEach { name ->
            context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)
                .edit().clear().commit()
        }
        ParentalConsentStore.save(context, ConsentState.NOT_GIVEN)
    }

    fun retentionPolicyText(): String =
        "Os dados técnicos são guardados neste dispositivo até serem eliminados nas definições " +
        "ou até os dados da aplicação serem apagados pelo Android. Não há sincronização automática."
}
