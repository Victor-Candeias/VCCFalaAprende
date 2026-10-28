package pt.vcc.falaaprende.navigation

/**
 * Rotas estáveis e independentes de conteúdos fornecidos pelo utilizador.
 */
enum class AppDestination(val route: String, val label: String) {
    Home("home", "Início"),
    Activities("activities", "Atividades"),
    Settings("settings", "Definições");

    companion object {
        fun fromRoute(route: String?): AppDestination =
            entries.firstOrNull { it.route == route } ?: Home
    }
}
