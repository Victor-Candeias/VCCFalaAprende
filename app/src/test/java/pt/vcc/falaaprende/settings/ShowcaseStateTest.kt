package pt.vcc.falaaprende.settings

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ShowcaseStateTest {
    @Test fun toggleCanBeReversed() {
        assertTrue(ShowcaseState.next(false))
        assertFalse(ShowcaseState.next(true))
    }

    @Test fun actionLabelsAreInPortuguese() {
        assertEquals("Experimentar", ShowcaseState.actionLabel(false))
        assertEquals("Recomeçar", ShowcaseState.actionLabel(true))
    }
}
