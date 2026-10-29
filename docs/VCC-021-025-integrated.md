# VCC-021 a VCC-025 — Integração conjunta

## VCC-021 — Injeção de dependências
A aplicação reutiliza o `AppContainer` e persiste o último resultado do diagnóstico de componentes internos.

## VCC-022 — Base de dados Room
O ecrã de armazenamento consulta, insere e elimina registos de teste através do DAO Room. Guarda adicionalmente a última contagem bem-sucedida em preferências locais, identificada como snapshot, sem substituir os dados da base de dados.

## VCC-023 — Pipeline CI
Checklist manual offline por etapa, guardada em preferências locais. **Não representa o estado real do GitHub Actions**.

## VCC-024 — Gestão de erros
Guarda apenas o código do exemplo de erro selecionado; nunca guarda stack traces, mensagens técnicas ou dados pessoais.

## VCC-025 — Consentimento parental
Apresenta informação para responsáveis e permite autorizar ou revogar localmente. Sem autorização registada, a secção Atividades apresenta um aviso e encaminha para a página de consentimento. **Não existe verificação de idade/identidade, nem garantia jurídica de consentimento válido.** Antes de produção, implementar um fluxo de verificação adequado ao contexto legal e rever os requisitos de privacidade infantil.

## Verificações necessárias
1. Executar `./gradlew test assembleDebug`.
2. Room: adicionar registo, reiniciar, confirmar contagem; limpar e confirmar zero.
3. CI: marcar etapas, reiniciar, confirmar persistência; não confundir com execução real.
4. Erros: selecionar exemplo, reiniciar e confirmar seleção; limpar seleção.
5. Consentimento: sem autorização, Atividades bloqueadas; autorizar, voltar e aceder; revogar e confirmar novo bloqueio.
6. Confirmar acessibilidade TalkBack, contraste e textos pt-PT.

**Estado:** alterações de código submetidas; build, testes instrumentados, revisão funcional e revisão legal pendentes.
