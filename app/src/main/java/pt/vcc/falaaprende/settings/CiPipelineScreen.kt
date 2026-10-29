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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

@Composable
fun CiPipelineScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var checked by remember(context) { mutableStateOf(CiPipelineInfo.steps.indices.map { CiChecklistStore.read(context, it) }) }
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
                Text(if (checked[index]) "Confirmado manualmente" else "Por confirmar")
                ChildPrimaryButton(
                    label = if (checked[index]) "Desmarcar etapa" else "Marcar etapa como verificada",
                    onClick = {
                        val next = !checked[index]
                        CiChecklistStore.save(context, index, next)
                        checked = checked.toMutableList().also { it[index] = next }
                    }
                )
            }
        }
        ChildContentCard(title = "Como confirmar o resultado") {
            Text("Consulta o separador Actions do repositório para verificar a execução e descarregar o APK.")
            Text("Uma compilação local não garante que o pipeline remoto tenha terminado com sucesso.")
        }
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}
