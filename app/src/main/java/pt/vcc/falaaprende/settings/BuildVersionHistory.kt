package pt.vcc.falaaprende.settings

import android.content.Context

/** Apenas metadados técnicos locais; não guarda dados pessoais. */
data class BuildVersionHistory(
    val firstSeenVersion: String,
    val previousVersion: String?,
    val currentVersion: String,
    val isNewVersion: Boolean
)

object BuildVersionHistoryStore {
    private const val PREFS = "build_version_history"
    private const val FIRST = "first_seen"
    private const val LAST = "last_seen"
    private const val PREVIOUS = "previous"

    fun record(context: Context, currentVersion: String): BuildVersionHistory {
        require(currentVersion.isNotBlank()) { "A versão não pode estar vazia." }
        val prefs = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val first = prefs.getString(FIRST, null) ?: currentVersion
        val last = prefs.getString(LAST, null)
        val changed = last != null && last != currentVersion
        val previous = if (changed) last else prefs.getString(PREVIOUS, null)
        if (last != currentVersion || !prefs.contains(FIRST)) {
            prefs.edit()
                .putString(FIRST, first)
                .putString(LAST, currentVersion)
                .apply {
                    if (changed) putString(PREVIOUS, last)
                }
                .apply()
        }
        return BuildVersionHistory(first, previous, currentVersion, changed)
    }
}
