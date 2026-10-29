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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing
import pt.vcc.falaaprende.di.AppDependencies
import pt.vcc.falaaprende.di.DependencyStatusProvider
import pt.vcc.falaaprende.di.DependencyStatusStore

@Composable
fun DependencyInfoScreen(
    dependencies: AppDependencies,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var previousStatuses by remember(context) {
        mutableStateOf(DependencyStatusStore.read(context))
    }
    var statuses by remember(dependencies) {
        mutableStateOf(DependencyStatusProvider.inspect(dependencies))
    }
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Componentes internos", style = MaterialTheme.typography.headlineMedium)
        Text(
            "Verifica se os componentes essenciais estão disponíveis. Esta página não mostra dados pessoais.",
            style = MaterialTheme.typography.bodyLarge
        )
        if (previousStatuses.isNotEmpty()) {
            ChildContentCard(title = "Última verificação guardada") {
                previousStatuses.forEach { status ->
                    Text("${status.name}: ${if (status.available) "Disponível" else "Indisponível"}")
                }
            }
        }
        Text("Estado nesta sessão", style = MaterialTheme.typography.titleMedium)
        statuses.forEach { status ->
            ChildContentCard(title = status.name) {
                Text(
                    if (status.available) "Disponível" else "Indisponível",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        ChildPrimaryButton(
            label = "Verificar novamente",
            onClick = {
                statuses = DependencyStatusProvider.inspect(dependencies)
                DependencyStatusStore.save(context, statuses)
                previousStatuses = statuses
            }
        )
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}
