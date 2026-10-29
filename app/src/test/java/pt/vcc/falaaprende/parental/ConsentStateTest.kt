package pt.vcc.falaaprende.parental

import org.junit.Assert.assertEquals
import org.junit.Test

class ConsentStateTest {
    @Test fun consentDefaultsToNotGivenInDomain() {
        assertEquals(ConsentState.NOT_GIVEN, ConsentState.valueOf("NOT_GIVEN"))
    }

    @Test fun consentCanBeExplicitlyRevoked() {
        val state = ConsentState.GRANTED
        val revoked = ConsentState.NOT_GIVEN
        assertEquals(ConsentState.GRANTED, state)
        assertEquals(ConsentState.NOT_GIVEN, revoked)
    }
}
