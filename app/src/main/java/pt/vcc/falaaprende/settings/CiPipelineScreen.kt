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
import androidx.compose.ui.Modifier
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

@Composable
fun CiPipelineScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Pipeline de integração contínua", style = MaterialTheme.typography.headlineMedium)
        ChildContentCard(title = "Informação sobre a compilação") {
            Text("Este ecrã descreve o processo de compilação, não o estado atual do GitHub Actions.")
            Text("A informação está disponível offline.")
            Text("Workflow: ${CiPipelineInfo.workflowPath}")
        }
        CiPipelineInfo.steps.forEachIndexed { index, step ->
            ChildContentCard(title = "${index + 1}. ${step.title}") {
                Text(step.description, style = MaterialTheme.typography.bodyLarge)
            }
        }
        ChildContentCard(title = "Como confirmar o resultado") {
            Text("Consulta o separador Actions do repositório para verificar a execução e descarregar o APK.")
            Text("Uma compilação local não garante que o pipeline remoto tenha terminado com sucesso.")
        }
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}
