package pt.vcc.falaaprende.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.vcc.falaaprende.core.data.local.DiagnosticDao
import pt.vcc.falaaprende.core.data.local.DiagnosticEntry
import pt.vcc.falaaprende.core.designsystem.ChildContentCard
import pt.vcc.falaaprende.core.designsystem.ChildPrimaryButton
import pt.vcc.falaaprende.core.designsystem.FalaAprendeSpacing

@Composable
fun RoomDiagnosticScreen(dao: DiagnosticDao, onBack: () -> Unit) {
    var count by remember { mutableStateOf<Int?>(null) }
    var error by remember { mutableStateOf(false) }
    var busy by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    suspend fun refresh() {
        busy = true
        try {
            count = withContext(Dispatchers.IO) { dao.count() }
            error = false
        } catch (exception: Exception) {
            if (exception is CancellationException) throw exception
            error = true
        } finally {
            busy = false
        }
    }

    LaunchedEffect(dao) { refresh() }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .padding(FalaAprendeSpacing.Large),
        verticalArrangement = Arrangement.spacedBy(FalaAprendeSpacing.Medium)
    ) {
        Text("Armazenamento local", style = MaterialTheme.typography.headlineMedium)
        Text("Teste de persistência offline, sem dados pessoais.", style = MaterialTheme.typography.bodyLarge)
        ChildContentCard(title = "Base de dados Room") {
            if (busy) CircularProgressIndicator()
            Text(
                when {
                    error -> "Não foi possível aceder ao armazenamento."
                    count == null -> "A verificar armazenamento…"
                    else -> "Registos de teste: $count"
                },
                style = MaterialTheme.typography.bodyLarge
            )
        }
        ChildPrimaryButton(
            label = "Adicionar registo de teste",
            enabled = !busy,
            onClick = {
                scope.launch {
                    busy = true
                    try {
                        withContext(Dispatchers.IO) { dao.insert(DiagnosticEntry()) }
                        refresh()
                    } catch (exception: Exception) {
                        if (exception is CancellationException) throw exception
                        error = true
                        busy = false
                    }
                }
            }
        )
        ChildPrimaryButton(
            label = "Limpar registos de teste",
            enabled = !busy,
            onClick = {
                scope.launch {
                    busy = true
                    try {
                        withContext(Dispatchers.IO) { dao.clear() }
                        refresh()
                    } catch (exception: Exception) {
                        if (exception is CancellationException) throw exception
                        error = true
                        busy = false
                    }
                }
            }
        )
        ChildPrimaryButton(
            label = "Verificar novamente",
            enabled = !busy,
            onClick = { scope.launch { refresh() } }
        )
        ChildPrimaryButton(label = "Voltar às definições", onClick = onBack)
    }
}
