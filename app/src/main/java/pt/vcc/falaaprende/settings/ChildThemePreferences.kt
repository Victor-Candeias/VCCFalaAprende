package pt.vcc.falaaprende.settings

import android.content.Context

enum class ChildThemeMode(val label: String) {
    SYSTEM("Automático"), LIGHT("Claro"), DARK("Escuro");

    companion object {
        fun parse(value: String?): ChildThemeMode =
            entries.firstOrNull { it.name == value } ?: SYSTEM
    }
}

/** Preferência visual local; não contém dados pessoais. */
object ChildThemePreferences {
    private const val PREFS = "child_theme_preferences"
    private const val KEY_MODE = "theme_mode"

    fun read(context: Context): ChildThemeMode =
        ChildThemeMode.parse(
            context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getString(KEY_MODE, null)
        )

    fun save(context: Context, mode: ChildThemeMode) {
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putString(KEY_MODE, mode.name).apply()
    }
}
