package pt.vcc.falaaprende.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

@Composable
fun ProjectInfoScreen(
    info: ProjectInfo,
    modifier: Modifier = Modifier,
    onShowArchitecture: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Sobre a aplicação", style = MaterialTheme.typography.headlineMedium)
        ChildContentCard(title = info.appName) {
            Text("Versão: ${info.versionName} (${info.versionCode})")
            Text("Tipo de compilação: ${info.buildType}")
        }
        ChildPrimaryButton(label = "Ver arquitetura", onClick = onShowArchitecture)
        ChildContentCard(title = "Informações técnicas") {
            Text("Android mínimo: API ${info.minSdk}")
            Text("Android de destino: API ${info.targetSdk}")
            Text("Desenvolvida em Kotlin e Jetpack Compose.")
            Text("As atividades principais foram concebidas para funcionar offline.")
        }
    }
}
