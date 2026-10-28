# VCC-013 — Interface de injeção de dependências

## Objetivo
Disponibilizar nas Definições uma vista informativa do estado dos componentes essenciais criados no VCC-005.

## Componentes
- `DependencyStatusProvider`: inspeciona a resolução das dependências sem apresentar exceções ou identificadores internos.
- `DependencyInfoScreen`: mostra o estado de disponibilidade, permite repetir a verificação e regressar às Definições.
- `AppDependencies`: contrato existente reutilizado sem introduzir um segundo contentor.

## Limitações
A verificação confirma apenas que as dependências podem ser resolvidas. Não executa testes funcionais ao repositório nem garante a disponibilidade de serviços futuros.

## Privacidade
Não são expostas credenciais, dados de crianças, stack traces ou valores de configuração. Não existe comunicação de rede.

## Testes
```bash
./gradlew clean test assembleDebug
```

Validar Definições > Ver componentes internos, repetir verificação e regressar. Confirmar ecrãs pequenos e TalkBack.
