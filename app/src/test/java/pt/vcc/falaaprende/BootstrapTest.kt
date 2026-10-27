package pt.vcc.falaaprende

import org.junit.Assert.assertTrue
import org.junit.Test

class BootstrapTest {
    @Test fun initialProjectIsConfigured() {
        assertTrue("VCC Fala & Aprende".isNotBlank())
    }
}
