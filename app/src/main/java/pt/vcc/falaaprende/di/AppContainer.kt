package pt.vcc.falaaprende.di

import pt.vcc.falaaprende.core.data.LocalWelcomeRepository
import pt.vcc.falaaprende.core.domain.repository.WelcomeRepository
import pt.vcc.falaaprende.core.domain.usecase.GetWelcomeMessageUseCase

/**
 * Contrato de composição para permitir substituir dependências em testes.
 * Não depende de rede, contas ou dados pessoais.
 */
interface AppDependencies {
    val welcomeRepository: WelcomeRepository
    val getWelcomeMessage: GetWelcomeMessageUseCase
}

/**
 * Composition root da aplicação. As dependências são criadas uma vez por
 * instância de Application e partilhadas durante o seu ciclo de vida.
 */
class AppContainer(
    override val welcomeRepository: WelcomeRepository = LocalWelcomeRepository()
) : AppDependencies {
    override val getWelcomeMessage: GetWelcomeMessageUseCase by lazy {
        GetWelcomeMessageUseCase(welcomeRepository)
    }
}
