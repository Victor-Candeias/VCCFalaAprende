package pt.vcc.falaaprende.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.vcc.falaaprende.core.domain.model.WelcomeMessage

@Composable
fun FalaAprendeNavHost(
    navController: NavHostController,
    welcome: WelcomeMessage,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.route,
        modifier = modifier
    ) {
        composable(AppDestination.Home.route) {
            DestinationScreen(
                title = welcome.title,
                description = welcome.subtitle,
                actionLabel = "Explorar atividades",
                onAction = { navController.navigateToTopLevel(AppDestination.Activities) }
            )
        }
        composable(AppDestination.Activities.route) {
            DestinationScreen(
                title = "Atividades",
                description = "Em breve, vais encontrar aqui jogos e exercícios educativos."
            )
        }
        composable(AppDestination.Settings.route) {
            DestinationScreen(
                title = "Definições",
                description = "Em breve, vais poder personalizar a aplicação."
            )
        }
    }
}

fun NavHostController.navigateToTopLevel(destination: AppDestination) {
    navigate(destination.route) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
private fun DestinationScreen(
    title: String,
    description: String,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(FalaAprendeSpacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ChildContentCard(title = title) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start
            )
        }
        if (actionLabel != null && onAction != null) {
            ChildPrimaryButton(
                label = actionLabel,
                onClick = onAction,
                modifier = Modifier.padding(top = FalaAprendeSpacing.Large)
            )
        }
    }
}
