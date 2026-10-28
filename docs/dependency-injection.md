# VCC-005 — Injeção de dependências

## Abordagem
Injeção manual por construtor com **Composition Root** na camada `app`, sem frameworks adicionais.

- `AppDependencies`: contrato das dependências disponibilizadas à aplicação.
- `AppContainer`: fornece o `WelcomeRepository` e constrói `GetWelcomeMessageUseCase`.
- `FalaAprendeApplication`: gere o ciclo de vida do contentor.
- `MainActivity`: consome o caso de uso através do contentor, sem instanciar repositórios.

## Direção das dependências
`app -> core:data -> core:domain`; os contratos permanecem em `core:domain`. O domínio não conhece Android, a implementação local nem o contentor.

## Testabilidade
`AppContainer` aceita um `WelcomeRepository` por construtor. O teste `AppContainerTest` injeta um fake e verifica a resposta do caso de uso e a reutilização da instância.

## Privacidade e offline
Não há novas permissões Android, ligações de rede nem tratamento de dados pessoais.

## Validação
```bash
./gradlew clean test assembleDebug
```

Validar também abertura da aplicação e apresentação do ecrã Início. Futuras dependências devem ser acrescentadas ao contrato e ao contentor, evitando criação direta nas Activities.
