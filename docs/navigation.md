# VCC-003 — Navegação Jetpack Compose

## Ecrãs iniciais
- `home` — Início, apresentação e acesso às atividades
- `activities` — Atividades (placeholder para futuros Work Items)
- `settings` — Definições (placeholder para futuros Work Items)

## Implementação
A `MainActivity` cria o `NavHostController` com `rememberNavController()`. O `FalaAprendeNavHost` define as rotas e o conteúdo dos ecrãs. A navegação de topo utiliza `popUpTo`, `launchSingleTop`, `saveState` e `restoreState` para evitar cópias repetidas dos destinos.

A barra inferior permite navegar entre destinos, com etiquetas em pt-PT e estados selecionados acessíveis. O botão de retrocesso do Android é gerido pelo Navigation Compose.

## Offline e privacidade
As rotas não contêm dados pessoais e a navegação não realiza chamadas de rede. Os ecrãs ainda não implementam atividades educativas ou definições persistentes.

## Validação
```bash
./gradlew clean test assembleDebug
```

Validar manualmente: início por defeito; navegação Início → Atividades → Definições; botão voltar; rotação do dispositivo; evitar destinos duplicados ao tocar repetidamente.
