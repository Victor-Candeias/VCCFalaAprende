# VCC-016 — Gestão de erros

## Objetivo
Reutilizar os contratos `AppError`, `AppErrorCode`, `OperationResult` e `ErrorMessages` já existentes. A interface de demonstração fica disponível em **Definições > Gestão de erros**.

## Comportamento
- Quatro categorias: armazenamento, ligação, dados inválidos e erro inesperado.
- As mensagens são pt-PT e não expõem stack traces, caminhos locais ou informação pessoal.
- O botão **Tentar novamente** no ecrã de demonstração repõe o exemplo; não faz pedidos de rede nem modifica dados.
- A aplicação continua a usar `ErrorScreen` para falhas reais de inicialização.
- A interface funciona offline e permite navegação por leitor de ecrã.

## Testes
```bash
./gradlew --no-daemon --max-workers=2 test assembleDebug
```

Verificar manualmente os quatro exemplos, o botão Voltar, a rolagem, a rotação do dispositivo e TalkBack.

**Limitação:** os exemplos não representam erros reais. Não há diagnóstico clínico, telemetria ou recolha de dados de crianças.
