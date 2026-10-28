package pt.vcc.falaaprende.core.domain.usecase

import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.core.domain.repository.WelcomeRepository

class GetWelcomeMessageUseCase(private val repository: WelcomeRepository) {
    operator fun invoke(): WelcomeMessage = repository.getWelcomeMessage()
}
