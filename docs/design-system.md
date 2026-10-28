# VCC-004 — Design System Infantil

## Objetivo
Identidade visual amigável e consistente, em português de Portugal, para crianças dos 3 aos 10 anos.

## Tokens
- **Cores:** Ocean (azul principal), Sunshine (amarelo), Coral, Mint, Paper, Ink e Lavender.
- **Espaçamento:** 4, 8, 16, 24 e 32 dp.
- **Alvos táteis:** mínimo de 48 dp; botão principal com altura mínima de 56 dp.
- **Cantos:** 20 dp em botões e 24 dp em cartões.
- **Tipografia:** escala Material 3 ajustada a títulos e leitura infantil, respeitando a escala de fontes do sistema.

## Componentes
- `FalaAprendeTheme`: esquema de cores claro/escuro e tipografia.
- `ChildPrimaryButton`: botão com texto acessível e alvo tátil amplo.
- `ChildContentCard`: cartão de conteúdo reutilizável.
- `FalaAprendeSpacing`, `FalaAprendeSizing`: tokens dimensionais.

## Acessibilidade
Contraste elevado nas combinações principais; botões identificáveis por texto, sem depender apenas da cor; suporte a escala de texto do Android; componentes com rótulos semânticos. Validar contraste e TalkBack em dispositivo real.

## Integração
O ecrã inicial utiliza `ChildContentCard` e `ChildPrimaryButton`. Outros ecrãs continuam placeholders.

## Validação
```bash
./gradlew clean test assembleDebug
```

Verificar manualmente tema claro/escuro, tamanhos de letra elevados, TalkBack, navegação ecrã inicial → Atividades e orientação do dispositivo.
