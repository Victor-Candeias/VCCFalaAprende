package pt.vcc.falaaprende.di

/** Estado público e não sensível de um serviço. */
data class DependencyStatus(val name: String, val available: Boolean)

object DependencyStatusProvider {
    fun inspect(dependencies: AppDependencies): List<DependencyStatus> = listOf(
        check("Repositório de boas-vindas") { dependencies.welcomeRepository },
        check("Caso de uso de boas-vindas") { dependencies.getWelcomeMessage }
    )

    private inline fun check(name: String, factory: () -> Any): DependencyStatus =
        try {
            factory()
            DependencyStatus(name, true)
        } catch (error: Exception) {
            if (error is java.util.concurrent.CancellationException) throw error
            DependencyStatus(name, false)
        }
}
