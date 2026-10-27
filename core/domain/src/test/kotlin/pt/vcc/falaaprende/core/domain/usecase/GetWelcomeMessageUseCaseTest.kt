package pt.vcc.falaaprende.core.domain.usecase

import org.junit.Assert.assertEquals
import org.junit.Test
import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.core.domain.repository.WelcomeRepository

class GetWelcomeMessageUseCaseTest {
    @Test fun returnsRepositoryMessage() {
        val expected = WelcomeMessage("Título", "Subtítulo")
        val repository = object : WelcomeRepository {
            override fun getWelcomeMessage() = expected
        }
        assertEquals(expected, GetWelcomeMessageUseCase(repository)())
    }
}
