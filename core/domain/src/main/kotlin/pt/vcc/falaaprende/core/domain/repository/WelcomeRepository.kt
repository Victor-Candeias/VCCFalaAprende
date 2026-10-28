package pt.vcc.falaaprende.core.domain.repository

import pt.vcc.falaaprende.core.domain.model.WelcomeMessage

interface WelcomeRepository {
    fun getWelcomeMessage(): WelcomeMessage
}
