package pt.vcc.falaaprende.settings

import org.junit.Assert.assertNull
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ArchitectureInfoTest {
    @Test fun allExpectedModulesAreDocumented() {
        val names = ArchitectureInfo.modules.map { it.name }
        assertEquals(5, names.size)
        assertEquals(names.size, names.distinct().size)
        assertTrue(names.containsAll(listOf(
            ":app", ":core:domain", ":core:data",
            ":core:common", ":core:designsystem"
        )))
    }

    @Test fun selectionOnlyAcceptsKnownModules() {
        assertEquals(":core:domain", ArchitectureInfo.validModuleName(":core:domain"))
        assertNull(ArchitectureInfo.validModuleName("unknown"))
        assertNull(ArchitectureInfo.validModuleName(null))
    }

    @Test fun descriptionsAreNonEmpty() {
        assertTrue(ArchitectureInfo.modules.all { it.responsibility.isNotBlank() })
    }
}
