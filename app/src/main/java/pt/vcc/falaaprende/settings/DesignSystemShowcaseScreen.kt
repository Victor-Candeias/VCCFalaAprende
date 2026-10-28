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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

/** Pré-visualização local dos componentes reutilizáveis do design system. */
@Composable
fun DesignSystemShowcaseScreen(modifier: Modifier = Modifier) {
    var selected by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Large)
    ) {
        Text("Componentes da aplicação", style = MaterialTheme.typography.headlineMedium)
        Text(
            "Exemplos de botões, cartões e mensagens que usamos nas atividades.",
            style = MaterialTheme.typography.bodyLarge
        )
        ChildContentCard(title = "Olá! Vamos aprender?") {
            Text("Aprender pode ser divertido!", style = MaterialTheme.typography.bodyLarge)
        }
        ChildContentCard(title = "Botão interativo") {
            Text(
                if (selected) "Muito bem! Escolheste o botão." else "Experimenta tocar no botão.",
                style = MaterialTheme.typography.bodyLarge
            )
            ChildPrimaryButton(
                label = if (selected) "Recomeçar" else "Experimentar",
                onClick = { selected = !selected },
                modifier = Modifier.padding(top = FalaAprendeSpacing.Medium)
            )
        }
        ChildContentCard(title = "Estado indisponível") {
            Text("Exemplo de um botão desativado.", style = MaterialTheme.typography.bodyLarge)
            ChildPrimaryButton(
                label = "Ainda não disponível",
                onClick = {},
                enabled = false,
                modifier = Modifier.padding(top = FalaAprendeSpacing.Medium)
            )
        }
    }
}
