package pt.vcc.falaaprende.error

/** Categorias de falha sem expor dados técnicos ou pessoais na interface. */
enum class AppErrorCode {
    STORAGE,
    NETWORK,
    INVALID_DATA,
    UNEXPECTED
}

data class AppError(
    val code: AppErrorCode,
    val message: String,
    val canRetry: Boolean = true
)

object ErrorMessages {
    fun forCode(code: AppErrorCode): String = when (code) {
        AppErrorCode.STORAGE -> "Não foi possível aceder aos dados guardados."
        AppErrorCode.NETWORK -> "Não foi possível estabelecer ligação. Podes tentar novamente."
        AppErrorCode.INVALID_DATA -> "Encontrámos dados que não conseguimos utilizar."
        AppErrorCode.UNEXPECTED -> "Ocorreu um problema inesperado. Tenta novamente."
    }
}
