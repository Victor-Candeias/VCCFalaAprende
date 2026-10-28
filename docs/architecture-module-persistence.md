# VCC-018 — Persistência de módulos Clean Architecture

Em **Definições > Ver arquitetura**, é possível selecionar um dos cinco módulos Gradle e guardar essa preferência localmente. A escolha é conservada após reiniciar a aplicação e pode ser apagada pelo botão **Limpar seleção**.

A persistência usa `SharedPreferences` privados, aceita apenas identificadores conhecidos e não recolhe dados pessoais nem executa operações de rede. A seleção não altera as dependências Gradle nem as regras de negócio.

## Validação

1. Selecionar um módulo e confirmar a indicação «Módulo guardado».
2. Fechar e reabrir a aplicação e verificar que a seleção permanece.
3. Limpar a seleção e confirmar que não reaparece.
4. Validar acessibilidade com TalkBack e ecrãs pequenos.
5. Executar `./gradlew test assembleDebug` com JDK 17.

**Pendente:** build e revisão manual antes de integrar o PR.
