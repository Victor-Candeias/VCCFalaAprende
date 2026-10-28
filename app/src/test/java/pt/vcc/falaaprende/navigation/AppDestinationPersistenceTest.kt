package pt.vcc.falaaprende.navigation

import org.junit.Assert.assertEquals
import org.junit.Test

class AppDestinationPersistenceTest {
    @Test fun validRoutesRoundTrip() {
        AppDestination.entries.forEach { destination ->
            assertEquals(destination, AppDestination.fromRoute(destination.route))
        }
    }

    @Test fun unknownAndNestedRoutesFallBackToHome() {
        assertEquals(AppDestination.Home, AppDestination.fromRoute(null))
        assertEquals(AppDestination.Home, AppDestination.fromRoute("storage"))
        assertEquals(AppDestination.Home, AppDestination.fromRoute("invalid"))
    }
}
