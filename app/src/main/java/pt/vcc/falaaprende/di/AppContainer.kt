package pt.vcc.falaaprende.di

import android.content.Context
import androidx.room.Room
import pt.vcc.falaaprende.core.data.local.DiagnosticDao
import pt.vcc.falaaprende.core.data.local.FalaAprendeDatabase
import pt.vcc.falaaprende.core.data.LocalWelcomeRepository
import pt.vcc.falaaprende.core.domain.repository.WelcomeRepository
import pt.vcc.falaaprende.core.domain.usecase.GetWelcomeMessageUseCase

/**
 * Contrato de composição para permitir substituir dependências em testes.
 * Não depende de rede, contas ou dados pessoais.
 */
interface AppDependencies {
    val diagnosticDao: DiagnosticDao
    val welcomeRepository: WelcomeRepository
    val getWelcomeMessage: GetWelcomeMessageUseCase
}

/**
 * Composition root da aplicação. As dependências são criadas uma vez por
 * instância de Application e partilhadas durante o seu ciclo de vida.
 */
class AppContainer(
    override val welcomeRepository: WelcomeRepository = LocalWelcomeRepository(),
    private val context: Context? = null
) : AppDependencies {
    private val database: FalaAprendeDatabase by lazy {
        Room.databaseBuilder(requireNotNull(context) { "Android Context necessário para Room" }.applicationContext, FalaAprendeDatabase::class.java, "falaaprende.db").build()
    }
    override val diagnosticDao: DiagnosticDao by lazy { database.diagnosticDao() }
    override val getWelcomeMessage: GetWelcomeMessageUseCase by lazy {
        GetWelcomeMessageUseCase(welcomeRepository)
    }
}
