package pt.vcc.falaaprende.settings

/** Descrição estática do pipeline. Não representa resultados em tempo real. */
data class CiPipelineStep(val title: String, val description: String)

object CiPipelineInfo {
    val steps = listOf(
        CiPipelineStep("Preparação", "Instalação do JDK 17 e Android SDK 35."),
        CiPipelineStep("Testes", "Execução de testes unitários com Gradle."),
        CiPipelineStep("Compilação", "Geração do APK Debug."),
        CiPipelineStep("Artefactos", "Disponibilização do APK e dos relatórios de testes.")
    )
    const val workflowPath = ".github/workflows/android-ci.yml"
}
