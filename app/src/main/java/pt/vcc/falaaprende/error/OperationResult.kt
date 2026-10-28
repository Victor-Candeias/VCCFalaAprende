package pt.vcc.falaaprende.error

sealed interface OperationResult<out T> {
    data class Success<T>(val value: T) : OperationResult<T>
    data class Failure(val error: AppError) : OperationResult<Nothing>
}

/**
 * Protege operações síncronas previsíveis.
 * Não captura erros graves da VM nem cancelações.
 */
inline fun <T> safely(
    errorCode: AppErrorCode = AppErrorCode.UNEXPECTED,
    operation: () -> T
): OperationResult<T> = try {
    OperationResult.Success(operation())
} catch (e: Exception) {
    if (e is java.util.concurrent.CancellationException) throw e
    OperationResult.Failure(AppError(errorCode, ErrorMessages.forCode(errorCode)))
}
