package pt.vcc.falaaprende.error

import android.content.Context

/** Guarda apenas a categoria de demonstração, nunca exceções ou dados de crianças. */
object ErrorExampleStore {
    private const val PREFS = "error_example"
    private const val KEY_CODE = "last_code"

    fun read(context: Context): AppErrorCode? {
        val name = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY_CODE, null)
        return AppErrorCode.entries.firstOrNull { it.name == name }
    }

    fun save(context: Context, code: AppErrorCode?) {
        val editor = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit()
        if (code == null) editor.remove(KEY_CODE) else editor.putString(KEY_CODE, code.name)
        editor.apply()
    }
}
