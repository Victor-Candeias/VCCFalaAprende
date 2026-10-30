package pt.vcc.falaaprende.privacy

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.core.content.ContextCompat
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing
import pt.vcc.falaaprende.parental.ParentalPinStore

@Composable
fun PrivacySettingsScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    var authorized by remember { mutableStateOf(false) }
    var configured by remember { mutableStateOf(ParentalPinStore.isConfigured(context)) }
    var pin by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }
    var confirmDelete by remember { mutableStateOf(false) }
    var microphoneGranted by remember {
        mutableStateOf(ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)
    }
    val micLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        microphoneGranted = it
    }
    val exportLauncher = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("application/json")) { uri ->
        if (uri != null && authorized) {
            try {
                context.contentResolver.openOutputStream(uri)?.use {
                    it.write(PrivacyDataManager.exportSummary(context).toByteArray(Charsets.UTF_8))
                } ?: error("Não foi possível abrir o ficheiro.")
                feedback = "Resumo exportado."
            } catch (_: Exception) { feedback = "Não foi possível exportar o resumo." }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Privacidade e segurança", style = MaterialTheme.typography.headlineMedium)
        ChildContentCard(title = "Acesso da pessoa responsável") {
            Text(if (configured) "Introduz o PIN parental de 6 dígitos." else "Define um PIN parental de 6 dígitos.")
            androidx.compose.material3.OutlinedTextField(
                value = pin,
                onValueChange = { pin = it.filter(Char::isDigit).take(6) },
                label = { Text("PIN parental") },
                visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                singleLine = true
            )
            ChildPrimaryButton(label = if (configured) "Desbloquear" else "Definir PIN",
                onClick = {
                    if (configured) {
                        authorized = ParentalPinStore.verify(context, pin)
                        feedback = if (authorized) "Acesso autorizado." else "PIN incorreto."
                    } else {
                        authorized = ParentalPinStore.configure(context, pin)
                        configured = ParentalPinStore.isConfigured(context)
                        feedback = if (authorized) "PIN definido." else "Utiliza exatamente 6 dígitos."
                    }
                    pin = ""
                })
            if (authorized) {
                ChildPrimaryButton(label = "Bloquear novamente", onClick = {
                    authorized = false
                    confirmDelete = false
                })
            }
        }
        if (authorized) {
            ChildContentCard(title = "Retenção de dados") {
                Text(PrivacyDataManager.retentionPolicyText())
            }
            ChildContentCard(title = "Exportação") {
                Text("Exporta apenas um resumo das preferências de consentimento; não é uma exportação completa.")
                ChildPrimaryButton(label = "Exportar resumo JSON", onClick = {
                    exportLauncher.launch("vcc-falaaprende-resumo.json")
                })
            }
            ChildContentCard(title = "Eliminação de dados") {
                Text("Limpa preferências técnicas e revoga o consentimento. Não elimina a base de dados Room, perfis futuros ou áudio.")
                if (!confirmDelete) {
                    ChildPrimaryButton(label = "Preparar eliminação", onClick = { confirmDelete = true })
                } else {
                    Text("Confirmas que pretendes limpar estas preferências?")
                    ChildPrimaryButton(label = "Confirmar eliminação", onClick = {
                        PrivacyDataManager.clearKnownPreferences(context)
                        confirmDelete = false
                        feedback = "Preferências eliminadas. Consentimento revogado."
                    })
                    ChildPrimaryButton(label = "Cancelar", onClick = { confirmDelete = false })
                }
            }
            ChildContentCard(title = "Microfone") {
                Text(if (microphoneGranted) "Permissão concedida." else "Permissão não concedida.")
                Text("A permissão só é solicitada após ação explícita. Esta página não inicia gravações.")
                if (!microphoneGranted) {
                    ChildPrimaryButton(label = "Pedir permissão de microfone", onClick = {
                        micLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    })
                }
            }
        }
        if (feedback.isNotEmpty()) Text(feedback)
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}
