package pt.vcc.falaaprende.error

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
import androidx.compose.ui.platform.LocalContext
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

/** Demonstra estados previsíveis sem executar operações perigosas ou recolher dados. */
@Composable
fun ErrorShowcaseScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var selected by rememberSaveable { mutableStateOf(ErrorExampleStore.read(context)?.name) }
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Gestão de erros", style = MaterialTheme.typography.headlineMedium)
        Text("Exemplos de mensagens apresentadas quando uma operação não pode continuar.")
        if (selected == null) {
            AppErrorCode.entries.forEach { code ->
                ChildPrimaryButton(
                    label = ErrorShowcaseLabels.forCode(code),
                    onClick = {
                        selected = code.name
                        ErrorExampleStore.save(context, code)
                    }
                )
            }
        } else {
            val code = AppErrorCode.entries.firstOrNull { it.name == selected }
            if (code == null) {
                ChildContentCard(title = "Estado desconhecido") {
                    Text("Não foi possível apresentar este exemplo.")
                }
            } else {
                ChildContentCard(title = ErrorShowcaseLabels.forCode(code)) {
                    Text(ErrorMessages.forCode(code), style = MaterialTheme.typography.bodyLarge)
                }
                ChildPrimaryButton(
                    label = "Tentar novamente",
                    onClick = {
                        selected = null
                        ErrorExampleStore.save(context, null)
                    }
                )
            }
            ChildPrimaryButton(label = "Ver outros exemplos", onClick = { selected = null })
        }
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}

object ErrorShowcaseLabels {
    fun forCode(code: AppErrorCode): String = when (code) {
        AppErrorCode.STORAGE -> "Erro de armazenamento"
        AppErrorCode.NETWORK -> "Erro de ligação"
        AppErrorCode.INVALID_DATA -> "Dados inválidos"
        AppErrorCode.UNEXPECTED -> "Erro inesperado"
    }
}
