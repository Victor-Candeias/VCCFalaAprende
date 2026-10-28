package pt.vcc.falaaprende.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

@Composable
fun ErrorScreen(
    error: AppError,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(FalaAprendeSpacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Ups! Algo não correu bem.",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Text(
            error.message,
            modifier = Modifier.padding(top = FalaAprendeSpacing.Medium),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        if (error.canRetry) {
            ChildPrimaryButton(
                label = "Tentar novamente",
                onClick = onRetry,
                modifier = Modifier.padding(top = FalaAprendeSpacing.Large)
            )
        }
    }
}
