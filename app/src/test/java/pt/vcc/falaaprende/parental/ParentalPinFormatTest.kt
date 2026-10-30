package pt.vcc.falaaprende.parental

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ParentalPinFormatTest {
    @Test fun requiresSixAsciiDigits() {
        assertTrue(ParentalPinStore.isValidFormat("012345"))
        assertFalse(ParentalPinStore.isValidFormat("12345"))
        assertFalse(ParentalPinStore.isValidFormat("1234567"))
        assertFalse(ParentalPinStore.isValidFormat("12ab56"))
        assertFalse(ParentalPinStore.isValidFormat("１２３４５６"))
    }
}
