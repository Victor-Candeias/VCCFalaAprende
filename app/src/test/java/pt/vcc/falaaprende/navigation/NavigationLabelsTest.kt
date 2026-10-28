package pt.vcc.falaaprende.navigation

import org.junit.Assert.assertEquals
import org.junit.Test

class NavigationLabelsTest {
    @Test fun selectedTabHasPortugueseDescription() {
        assertEquals("Início, selecionado", navigationStateDescription(AppDestination.Home, true))
    }

    @Test fun unselectedTabUsesOnlyLabel() {
        assertEquals("Atividades", navigationStateDescription(AppDestination.Activities, false))
    }

    @Test fun allDestinationsHaveDistinctLabels() {
        assertEquals(AppDestination.entries.size, AppDestination.entries.map { it.label }.distinct().size)
    }
}
