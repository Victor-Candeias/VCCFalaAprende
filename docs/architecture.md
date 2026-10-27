# VCC-002 — Clean Architecture

## Módulos
- `app`: aplicação, Activity, composição e wiring de dependências.
- `core:domain`: modelos, contratos de repositório e casos de uso Kotlin puro; sem Android.
- `core:data`: implementações de repositórios e futuras fontes locais Room.
- `core:common`: tipos e utilitários partilhados, sem dependência Android.
- `core:designsystem`: tema e componentes Compose reutilizáveis.

## Direção das dependências
`app -> domain, data, designsystem`
`data -> domain, common`
`domain -> common`

O domínio nunca depende da camada de dados, da aplicação ou do Android.

## Exemplo funcional
`MainActivity -> GetWelcomeMessageUseCase -> WelcomeRepository -> LocalWelcomeRepository`.

## Validação
Executar `./gradlew :core:domain:test :app:assembleDebug` num Codespace com Android SDK 35.
