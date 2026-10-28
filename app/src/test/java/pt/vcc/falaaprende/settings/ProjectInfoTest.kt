package pt.vcc.falaaprende.settings

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProjectInfoTest {
    @Test fun projectInfoContainsBuildMetadata() {
        val info = ProjectInfoProvider.current()
        assertEquals("VCC Fala & Aprende", info.appName)
        assertTrue(info.versionCode > 0)
        assertTrue(info.versionName.isNotBlank())
        assertTrue(info.minSdk <= info.targetSdk)
    }
}
