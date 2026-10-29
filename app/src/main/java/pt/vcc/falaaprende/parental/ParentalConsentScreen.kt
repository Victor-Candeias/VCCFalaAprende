package pt.vcc.falaaprende.parental

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

@Composable
fun ParentalConsentScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    var consent by remember(context) { mutableStateOf(ParentalConsentStore.read(context)) }
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Consentimento parental", style = MaterialTheme.typography.headlineMedium)
        ChildContentCard(title = "Informação para a pessoa responsável") {
            Text("Esta aplicação apresenta atividades educativas offline. Não realiza diagnósticos clínicos.")
            Text("Esta escolha é guardada apenas neste dispositivo. Pode ser retirada a qualquer momento.")
            Text("O registo local não verifica a identidade nem a idade de quem autoriza.")
            Text(if (consent == ConsentState.GRANTED) "Autorização registada neste dispositivo."
                 else "Ainda não existe autorização registada.")
        }
        if (consent == ConsentState.NOT_GIVEN) {
            ChildPrimaryButton(label = "Sou responsável e autorizo a utilização",
                onClick = {
                    ParentalConsentStore.save(context, ConsentState.GRANTED)
                    consent = ConsentState.GRANTED
                })
        } else {
            ChildPrimaryButton(label = "Retirar autorização",
                onClick = {
                    ParentalConsentStore.save(context, ConsentState.NOT_GIVEN)
                    consent = ConsentState.NOT_GIVEN
                })
        }
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}
