package pt.vcc.falaaprende.settings

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CiPipelineInfoTest {
    @Test fun stepsAreOrderedAndDescribed() {
        assertEquals(4, CiPipelineInfo.steps.size)
        assertEquals("Preparação", CiPipelineInfo.steps.first().title)
        assertTrue(CiPipelineInfo.steps.all { it.title.isNotBlank() && it.description.isNotBlank() })
    }

    @Test fun workflowPathIsRelative() {
        assertEquals(".github/workflows/android-ci.yml", CiPipelineInfo.workflowPath)
    }
}
