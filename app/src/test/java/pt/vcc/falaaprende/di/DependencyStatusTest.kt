package pt.vcc.falaaprende.di

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DependencyStatusTest {
    @Test fun containerReportsTwoAvailableDependencies() {
        val statuses = DependencyStatusProvider.inspect(AppContainer())
        assertEquals(2, statuses.size)
        assertTrue(statuses.all { it.available })
        assertTrue(statuses.all { it.name.isNotBlank() })
    }
}
