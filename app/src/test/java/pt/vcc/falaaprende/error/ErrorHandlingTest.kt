package pt.vcc.falaaprende.error

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.concurrent.CancellationException

class ErrorHandlingTest {
    @Test fun successfulOperationReturnsValue() {
        val result = safely { 42 }
        assertEquals(OperationResult.Success(42), result)
    }

    @Test fun failedOperationUsesFriendlyMessageWithoutExceptionDetails() {
        val result = safely(AppErrorCode.STORAGE) {
            throw IllegalStateException("sensitive internal details")
        }
        assertTrue(result is OperationResult.Failure)
        val error = (result as OperationResult.Failure).error
        assertEquals(AppErrorCode.STORAGE, error.code)
        assertFalse(error.message.contains("sensitive"))
    }

    @Test(expected = CancellationException::class)
    fun cancellationIsNotSwallowed() {
        safely { throw CancellationException("cancel") }
    }

    @Test fun everyErrorCodeHasNonBlankMessage() {
        AppErrorCode.entries.forEach { code ->
            assertTrue(ErrorMessages.forCode(code).isNotBlank())
        }
    }
}
