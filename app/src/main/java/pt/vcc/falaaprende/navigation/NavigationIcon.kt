package pt.vcc.falaaprende.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon

/** Ícones vetoriais com rótulos fornecidos pelo NavigationBarItem. */
@Composable
fun NavigationIcon(destination: AppDestination) {
    val image = when (destination) {
        AppDestination.Home -> Icons.Filled.Home
        AppDestination.Activities -> Icons.AutoMirrored.Filled.List
        AppDestination.Settings -> Icons.Filled.Settings
    }
    Icon(imageVector = image, contentDescription = null)
}
