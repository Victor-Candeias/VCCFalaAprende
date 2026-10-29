package pt.vcc.falaaprende.settings

import android.content.Context

/** Guarda apenas a contagem de registos técnicos de teste. */
object RoomDiagnosticSnapshot {
    private const val PREFS = "room_diagnostic_snapshot"
    private const val KEY_COUNT = "last_count"

    fun read(context: Context): Int? {
        val prefs = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return if (prefs.contains(KEY_COUNT)) prefs.getInt(KEY_COUNT, 0) else null
    }

    fun save(context: Context, count: Int) {
        require(count >= 0)
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putInt(KEY_COUNT, count).apply()
    }
}
