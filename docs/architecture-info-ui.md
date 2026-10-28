# VCC-010 — Interface dos módulos Clean Architecture

## Objetivo
Disponibilizar nas Definições uma vista informativa da estrutura modular criada no VCC-002.

## Módulos
- `:app`: UI Compose, navegação e composition root.
- `:core:domain`: contratos, modelos e casos de uso.
- `:core:data`: repositórios e persistência.
- `:core:common`: código partilhado.
- `:core:designsystem`: componentes visuais reutilizáveis.

## Implementação
`ArchitectureInfo` define o catálogo estático de módulos; `ArchitectureInfoScreen` apresenta cartões Compose. A partir de Definições, o utilizador abre a vista através do botão "Ver arquitetura", com navegação de regresso do Android.

## Limites
Esta página é informativa, não inspeciona dependências Gradle em tempo de execução. Se os módulos forem alterados, atualizar o catálogo e o teste.

## Privacidade e acessibilidade
A página funciona offline, não acede a dados pessoais e utiliza componentes do design system com scroll vertical.

## Validação
```bash
./gradlew clean test assembleDebug
```

Abrir Definições > Ver arquitetura, verificar os cinco módulos, scroll e navegação de regresso. Validar com TalkBack.
