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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pt.vcc.falaaprende.core.designsystem.FalaAprendeTheme
import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.navigation.AppDestination
import pt.vcc.falaaprende.navigation.FalaAprendeNavHost
import pt.vcc.falaaprende.navigation.navigateToTopLevel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dependencies = (application as FalaAprendeApplication).dependencies
        val welcome = dependencies.getWelcomeMessage()
        setContent { FalaAprendeApp(welcome) }
    }
}

@Composable
fun FalaAprendeApp(welcome: WelcomeMessage) {
    FalaAprendeTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val selected = AppDestination.fromRoute(backStackEntry?.destination?.route)

        Scaffold(
            bottomBar = {
                NavigationBar {
                    AppDestination.entries.forEach { destination ->
                        NavigationBarItem(
                            selected = selected == destination,
                            onClick = { navController.navigateToTopLevel(destination) },
                            icon = { Text(destination.label.take(1)) },
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
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
        }
    }
}
