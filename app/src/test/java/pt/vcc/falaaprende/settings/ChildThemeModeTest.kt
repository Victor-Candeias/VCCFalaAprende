package pt.vcc.falaaprende.settings

import org.junit.Assert.assertEquals
import org.junit.Test

class ChildThemeModeTest {
    @Test fun knownModesRoundTrip() {
        ChildThemeMode.entries.forEach { mode ->
            assertEquals(mode, ChildThemeMode.parse(mode.name))
        }
    }

    @Test fun invalidOrMissingModeDefaultsToSystem() {
        assertEquals(ChildThemeMode.SYSTEM, ChildThemeMode.parse(null))
        assertEquals(ChildThemeMode.SYSTEM, ChildThemeMode.parse("invalid"))
    }

    @Test fun allModesHaveAccessibleLabels() {
        assertEquals(ChildThemeMode.entries.size, ChildThemeMode.entries.map { it.label }.distinct().size)
    }
}
