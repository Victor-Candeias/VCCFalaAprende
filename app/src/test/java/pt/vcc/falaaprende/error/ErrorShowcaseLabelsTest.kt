package pt.vcc.falaaprende.error

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ErrorShowcaseLabelsTest {
    @Test fun everyErrorHasAccessibleLabelAndSafeMessage() {
        assertEquals(4, AppErrorCode.entries.size)
        AppErrorCode.entries.forEach { code ->
            assertTrue(ErrorShowcaseLabels.forCode(code).isNotBlank())
            assertTrue(ErrorMessages.forCode(code).isNotBlank())
            assertTrue(!ErrorMessages.forCode(code).contains("Exception"))
        }
    }

    @Test fun storageMessageIsFriendly() {
        assertEquals("Erro de armazenamento", ErrorShowcaseLabels.forCode(AppErrorCode.STORAGE))
    }
}
