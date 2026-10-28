package pt.vcc.falaaprende

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pt.vcc.falaaprende.core.designsystem.FalaAprendeTheme
import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.error.ErrorScreen
import pt.vcc.falaaprende.error.OperationResult
import pt.vcc.falaaprende.error.safely
import pt.vcc.falaaprende.navigation.AppDestination
import pt.vcc.falaaprende.navigation.NavigationPreferenceStore
import pt.vcc.falaaprende.navigation.NavigationIcon
import pt.vcc.falaaprende.navigation.navigationStateDescription
import pt.vcc.falaaprende.navigation.FalaAprendeNavHost
import pt.vcc.falaaprende.navigation.navigateToTopLevel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dependencies = (application as FalaAprendeApplication).dependencies
        var result by mutableStateOf(safely { dependencies.getWelcomeMessage() })
        setContent {
            when (val current = result) {
                is OperationResult.Success -> FalaAprendeApp(current.value, dependencies)
                is OperationResult.Failure -> FalaAprendeTheme {
                    ErrorScreen(
                        error = current.error,
                        onRetry = { result = safely { dependencies.getWelcomeMessage() } }
                    )
                }
            }
        }
    }
}

@Composable
fun FalaAprendeApp(welcome: WelcomeMessage, dependencies: pt.vcc.falaaprende.di.AppDependencies) {
    FalaAprendeTheme {
        val context = LocalContext.current
        val restoredDestination = remember(context) { NavigationPreferenceStore.read(context) }
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val selected = AppDestination.fromRoute(backStackEntry?.destination?.route)
        LaunchedEffect(backStackEntry?.destination?.route) {
            val route = backStackEntry?.destination?.route
            val topLevel = AppDestination.entries.firstOrNull { it.route == route }
            if (topLevel != null) NavigationPreferenceStore.save(context, topLevel)
        }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    AppDestination.entries.forEach { destination ->
                        NavigationBarItem(
                            selected = selected == destination,
                            onClick = { navController.navigateToTopLevel(destination) },
                            modifier = Modifier.semantics {
                                stateDescription = navigationStateDescription(destination, selected == destination)
                            },
                            icon = { NavigationIcon(destination) },
                            label = { Text(destination.label) },
                            alwaysShowLabel = true
                        )
                    }
                }
            }
        ) { innerPadding ->
            FalaAprendeNavHost(
                navController = navController,
                welcome = welcome,
                dependencies = dependencies,
                startDestination = restoredDestination,
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
        }
    }
}
