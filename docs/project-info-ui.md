# VCC-009 — Interface de informações do projeto

## Objetivo
Apresentar nas Definições uma página informativa sobre a aplicação Android e a compilação.

## Implementação
- `ProjectInfo`: modelo imutável com nome, versão, build type e SDKs.
- `ProjectInfoProvider`: obtém versão e tipo de compilação do `BuildConfig`.
- `ProjectInfoScreen`: interface Jetpack Compose, com cartões, scroll vertical e tipografia do design system.
- Integração na rota existente `settings`.

## Segurança
A página não apresenta credenciais, dados pessoais, identificadores do dispositivo ou informações de crianças. Funciona offline.

## Verificação
```bash
./gradlew clean test assembleDebug
```

Abrir Definições e confirmar que o número de versão corresponde ao `versionName` do APK. Validar ecrãs pequenos e TalkBack.

## Evolução
As versões Android mínimas e de destino estão definidas no código; devem ser atualizadas quando o `build.gradle.kts` mudar.
