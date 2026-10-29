# VCC-021 — Persistência e integração da injeção de dependências

A composição de dependências continua centralizada em `AppContainer`, que permite substituir o repositório por um fake em testes e reutiliza as instâncias de serviços.

O ecrã **Definições > Ver componentes internos** apresenta o estado nesta sessão e, quando existe, a última verificação guardada. O botão **Verificar novamente** executa uma nova inspeção e grava apenas o nome permitido do serviço e o respetivo estado booleano.

- Armazenamento: `SharedPreferences` privados, sem rede.
- Não são guardadas exceções, identificadores, conteúdos infantis ou dados clínicos.
- O snapshot é informativo e não substitui a verificação atual.
- A inspeção não abre a base de dados Room nem executa operações clínicas.

## Validação

1. Abrir o ecrã e verificar os estados atuais.
2. Selecionar **Verificar novamente**, sair e regressar; deve existir a última verificação guardada.
3. Limpar os dados da aplicação; o snapshot deve desaparecer.
4. Confirmar acessibilidade com TalkBack.
5. Executar `./gradlew test assembleDebug` e rever os testes `AppContainerTest` e `DependencyStatusProviderTest`.

**Pendente:** build, validação em dispositivo e revisão antes de integrar.
