package pt.vcc.falaaprende.di

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DependencyStatusProviderTest {
    @Test fun injectedServicesAreAvailableOffline() {
        val container = AppContainer()
        val statuses = DependencyStatusProvider.inspect(container)
        assertEquals(2, statuses.size)
        assertTrue(statuses.all { it.available })
    }

    @Test fun diagnosticsDoNotExposePersonalData() {
        val statuses = DependencyStatusProvider.inspect(AppContainer())
        assertTrue(statuses.all { it.name.isNotBlank() && !it.name.contains("@") })
    }
}
