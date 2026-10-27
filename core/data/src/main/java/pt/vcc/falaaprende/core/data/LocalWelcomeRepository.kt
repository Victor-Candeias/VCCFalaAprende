package pt.vcc.falaaprende.core.data

import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.core.domain.repository.WelcomeRepository

class LocalWelcomeRepository : WelcomeRepository {
    override fun getWelcomeMessage(): WelcomeMessage =
        WelcomeMessage(
            title = "VCC Fala & Aprende",
            subtitle = "Aprender a comunicar, brincar e crescer!"
        )
}
