package pt.vcc.falaaprende

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pt.vcc.falaaprende.core.data.LocalWelcomeRepository
import pt.vcc.falaaprende.core.designsystem.FalaAprendeTheme
import pt.vcc.falaaprende.core.domain.model.WelcomeMessage
import pt.vcc.falaaprende.core.domain.usecase.GetWelcomeMessageUseCase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val welcome = GetWelcomeMessageUseCase(LocalWelcomeRepository())()
        setContent { FalaAprendeApp(welcome) }
    }
}

@Composable
fun FalaAprendeApp(welcome: WelcomeMessage) {
    FalaAprendeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(welcome.title, style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
                Text(welcome.subtitle, modifier = Modifier.padding(top = 16.dp), style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center)
            }
        }
    }
}
