package pt.vcc.falaaprende.navigation

import android.content.Context

/** Guarda somente a última secção principal; nunca persiste argumentos ou dados de crianças. */
object NavigationPreferenceStore {
    private const val PREFS = "navigation_preferences"
    private const val KEY = "last_top_level_route"

    fun read(context: Context): AppDestination {
        val route = context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY, null)
        return AppDestination.fromRoute(route)
    }

    fun save(context: Context, destination: AppDestination) {
        context.applicationContext.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putString(KEY, destination.route).apply()
    }
}
