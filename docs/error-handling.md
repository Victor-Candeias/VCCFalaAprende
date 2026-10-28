# VCC-008 — Gestão de erros

## Contratos
- `AppErrorCode`: categorias de falhas previsíveis.
- `AppError`: código, mensagem pt-PT e possibilidade de repetir.
- `OperationResult.Success/Failure`: resultado tipificado.
- `safely`: adapta operações síncronas, sem ocultar cancelamentos.
- `ErrorScreen`: ecrã acessível com mensagem e botão de repetição.

## Integração
O arranque da `MainActivity` utiliza `safely` para obter a mensagem de boas-vindas. Quando ocorre uma exceção recuperável, apresenta `ErrorScreen` em vez de terminar abruptamente. O botão permite repetir a operação.

## Privacidade
As mensagens de erro não apresentam stack traces, identificadores de crianças nem conteúdos de exceções. Não existe telemetria nem envio de dados para a rede.

## Limites
Esta implementação não substitui tratamento de erros assíncronos, de Room ou de chamadas de rede nos futuros módulos. Essas operações deverão devolver `OperationResult` ou contratos de erro equivalentes, preservando cancelamentos de coroutines.

## Testes
```bash
./gradlew clean test assembleDebug
```

Verificar manualmente a abertura normal e, com um repositório fake que lança `IllegalStateException`, confirmar o ecrã de erro e o botão de repetição. Confirmar também TalkBack e textos pt-PT.
