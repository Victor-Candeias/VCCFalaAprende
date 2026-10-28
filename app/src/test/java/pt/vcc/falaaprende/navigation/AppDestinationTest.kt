package pt.vcc.falaaprende.navigation

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class AppDestinationTest {
    @Test fun routesAreUnique() {
        val routes = AppDestination.entries.map { it.route }
        assertEquals(routes.size, routes.distinct().size)
    }

    @Test fun unknownRouteFallsBackToHome() {
        assertEquals(AppDestination.Home, AppDestination.fromRoute("unknown"))
        assertEquals(AppDestination.Home, AppDestination.fromRoute(null))
    }

    @Test fun routeResolvesDestination() {
        assertEquals(AppDestination.Settings, AppDestination.fromRoute("settings"))
        assertNotEquals(AppDestination.Home, AppDestination.fromRoute("activities"))
    }
}
