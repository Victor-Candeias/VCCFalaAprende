package pt.vcc.falaaprende.settings

/** Descrição estática dos módulos, sem inspecionar dados do dispositivo. */
data class ArchitectureModule(
    val name: String,
    val responsibility: String
)

object ArchitectureInfo {
    val modules: List<ArchitectureModule> = listOf(
        ArchitectureModule(":app", "Interface Android, navegação e composição de dependências."),
        ArchitectureModule(":core:domain", "Modelos, contratos e regras de negócio."),
        ArchitectureModule(":core:data", "Implementações de repositórios e acesso a dados locais."),
        ArchitectureModule(":core:common", "Utilitários partilhados entre módulos."),
        ArchitectureModule(":core:designsystem", "Tema, cores, tipografia e componentes reutilizáveis.")
    )
}
