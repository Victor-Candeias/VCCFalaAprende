package pt.vcc.falaaprende.di

import android.content.Context

/** Snapshot local de disponibilidade técnica, sem dados pessoais ou detalhes de erros. */
object DependencyStatusStore {
    private const val PREFS = "dependency_status_snapshot"
    private const val KEY_PREFIX = "service_"
    private val supported = setOf("Repositório de boas-vindas", "Caso de uso de boas-vindas")

    fun read(context: Context): List<DependencyStatus> {
        val prefs = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return supported.sorted().mapNotNull { name ->
            val key = KEY_PREFIX + name
            if (prefs.contains(key)) DependencyStatus(name, prefs.getBoolean(key, false)) else null
        }
    }

    fun save(context: Context, statuses: List<DependencyStatus>) {
        val editor = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().clear()
        statuses.filter { it.name in supported }.forEach {
            editor.putBoolean(KEY_PREFIX + it.name, it.available)
        }
        editor.apply()
    }
}
