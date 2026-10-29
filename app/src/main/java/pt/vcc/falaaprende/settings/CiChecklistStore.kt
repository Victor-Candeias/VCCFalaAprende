package pt.vcc.falaaprende.settings

import android.content.Context

/** Checklist manual; não representa o estado real do GitHub Actions. */
object CiChecklistStore {
    private const val PREFS = "ci_manual_checklist"

    fun read(context: Context, index: Int): Boolean =
        index in CiPipelineInfo.steps.indices &&
            context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getBoolean("step_$index", false)

    fun save(context: Context, index: Int, checked: Boolean) {
        require(index in CiPipelineInfo.steps.indices)
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putBoolean("step_$index", checked).apply()
    }
}
