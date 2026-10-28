package pt.vcc.falaaprende.settings

import android.content.Context

/** Guarda apenas o identificador de um módulo técnico selecionado pelo utilizador. */
object ArchitectureSelectionStore {
    private const val PREFS = "architecture_selection"
    private const val KEY = "selected_module"

    fun read(context: Context): String? {
        val saved = context.applicationContext
            .getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY, null)
        return ArchitectureInfo.validModuleName(saved)
    }

    fun write(context: Context, moduleName: String?) {
        val valid = ArchitectureInfo.validModuleName(moduleName)
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().apply {
                if (valid == null) remove(KEY) else putString(KEY, valid)
            }.apply()
    }
}
