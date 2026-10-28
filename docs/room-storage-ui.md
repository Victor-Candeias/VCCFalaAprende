# VCC-014 — Room e interface de diagnóstico

## Implementação
Room 2.6.1 com KSP e Kotlin 2.0.21. O módulo `:core:data` define `DiagnosticEntry`, `DiagnosticDao` e `FalaAprendeDatabase`. A aplicação cria uma instância singleton por processo e disponibiliza o DAO via `AppDependencies`.

Em Definições > Armazenamento local, a interface permite contar, adicionar e apagar **apenas registos de teste**. As operações executam-se em `Dispatchers.IO` e são capturadas falhas previsíveis.

## Privacidade
Não guarda dados de crianças. A tabela contém somente ID gerado e texto fixo. Não há chamadas de rede.

## Verificação
```bash
./gradlew clean test assembleDebug
```

1. Abrir Definições > Armazenamento local.
2. Adicionar um registo, confirmar que o contador aumenta.
3. Fechar e reabrir a aplicação, confirmar persistência.
4. Limpar os registos, confirmar contador zero.
5. Testar modo offline, rolagem e TalkBack.

**Limite:** a tabela é exclusivamente técnica. Modelos de progresso e dados pedagógicos exigem entidades e migrações próprias em work items posteriores.
