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
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

@Composable
fun ArchitectureInfoScreen(
    modules: List<ArchitectureModule> = ArchitectureInfo.modules,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Arquitetura da aplicação", style = MaterialTheme.typography.headlineMedium)
        Text(
            "A aplicação está organizada em módulos para facilitar a manutenção e os testes.",
            style = MaterialTheme.typography.bodyLarge
        )
        modules.forEach { module ->
            ChildContentCard(title = module.name) {
                Text(module.responsibility, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
