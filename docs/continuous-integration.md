# VCC-007 — Pipeline CI Android

## Objetivo
Validar automaticamente Pull Requests e alterações na `main` com GitHub Actions.

## Eventos
- `pull_request` para `main`
- `push` para `main`
- `workflow_dispatch` para execução manual

## Ambiente
- Runner Ubuntu
- Java 17 (Temurin)
- Android SDK 35
- Gradle 8.10.2, configurado pelo Gradle Wrapper versionado no repositório

O workflow invoca `./gradlew`, usando o mesmo Gradle Wrapper disponível no Codespace.

## Validação
O comando executado é:

```bash
./gradlew --no-daemon clean test assembleDebug
```

O workflow falha caso a compilação ou os testes falhem.

## Artefactos
- `VCCFalaAprende-debug-apk`: APK Debug gerado.
- `android-unit-test-reports`: relatórios de testes quando disponíveis.

Os artefactos são retidos durante 14 dias.

## Segurança e privacidade
- Permissões limitadas a `contents: read`.
- Não são necessários secrets ou credenciais de publicação.
- Não há distribuição automática do APK para terceiros.
- Não há envio de dados de crianças para serviços externos.

## Critérios de aceitação e validação manual
1. Abrir Pull Request para `main` e verificar a execução do workflow.
2. Confirmar que os testes e `assembleDebug` terminam com sucesso.
3. Confirmar que o APK está disponível nos artefactos da execução.
4. Provocar uma falha num teste numa branch temporária e verificar que o job falha.
5. Após merge, verificar a execução em `main`.

O workflow deve ser executado no GitHub Actions para confirmar os critérios; criar o ficheiro não prova que o pipeline passou.
