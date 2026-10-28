package pt.vcc.falaaprende.di

import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test
import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.core.domain.repository.WelcomeRepository

class AppContainerTest {
    @Test
    fun injectedRepositoryIsUsedByUseCase() {
        val expected = WelcomeMessage("Teste", "Sem rede")
        val fake = object : WelcomeRepository {
            override fun getWelcomeMessage() = expected
        }
        val container = AppContainer(fake)

        assertSame(fake, container.welcomeRepository)
        assertEquals(expected, container.getWelcomeMessage())
    }

    @Test
    fun useCaseIsReused() {
        val container = AppContainer()
        assertSame(container.getWelcomeMessage, container.getWelcomeMessage)
    }
}
