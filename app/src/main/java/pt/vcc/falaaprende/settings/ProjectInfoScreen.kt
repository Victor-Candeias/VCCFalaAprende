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
    versionHistory: BuildVersionHistory? = null,
    themeMode: ChildThemeMode = ChildThemeMode.SYSTEM,
    onThemeModeChange: (ChildThemeMode) -> Unit = {},
    modifier: Modifier = Modifier,
    onShowArchitecture: () -> Unit = {},
    onShowDependencies: () -> Unit = {},
    onShowStorage: () -> Unit = {},
    onShowCiPipeline: () -> Unit = {},
    onShowErrorManagement: () -> Unit = {},
    onShowParentalConsent: () -> Unit = {},
    onShowPrivacySettings: () -> Unit = {}
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
            if (versionHistory != null) {
                Text("Primeira versão utilizada: ${versionHistory.firstSeenVersion}")
                versionHistory.previousVersion?.let { Text("Versão anterior: $it") }
                if (versionHistory.isNewVersion) Text("A aplicação foi atualizada para esta versão.")
            }
        }
        ChildContentCard(title = "Aspeto da aplicação") {
            Text("Modo atual: ${themeMode.label}")
            ChildThemeMode.entries.forEach { mode ->
                ChildPrimaryButton(label = "Tema ${mode.label}", onClick = { onThemeModeChange(mode) })
            }
        }
        ChildPrimaryButton(label = "Ver arquitetura", onClick = onShowArchitecture)
        ChildPrimaryButton(label = "Ver componentes internos", onClick = onShowDependencies)
        ChildPrimaryButton(label = "Armazenamento local", onClick = onShowStorage)
        ChildPrimaryButton(label = "Pipeline CI", onClick = onShowCiPipeline)
        ChildPrimaryButton(label = "Gestão de erros", onClick = onShowErrorManagement)
        ChildPrimaryButton(label = "Consentimento parental", onClick = onShowParentalConsent)
        ChildPrimaryButton(label = "Privacidade e segurança", onClick = onShowPrivacySettings)
        ChildContentCard(title = "Informações técnicas") {
            Text("Android mínimo: API ${info.minSdk}")
            Text("Android de destino: API ${info.targetSdk}")
            Text("Desenvolvida em Kotlin e Jetpack Compose.")
            Text("As atividades principais foram concebidas para funcionar offline.")
        }
    }
}
