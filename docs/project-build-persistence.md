# VCC-017 — Persistência de metadados de compilação

A aplicação mantém as informações de compilação em `BuildConfig`. O histórico local regista a primeira versão observada, a versão anterior (quando existe) e a versão atual.

- Persistência: `SharedPreferences` privado da aplicação, sem permissões nem acesso à rede.
- A versão atual continua a vir de `BuildConfig.VERSION_NAME`, nunca de valores editáveis.
- Não são guardados nomes, identificadores de crianças, dados clínicos ou telemetria.
- Uma atualização da aplicação preserva o histórico; a limpeza dos dados da aplicação reinicia-o.
- A interface em **Definições > Sobre a aplicação** mostra o histórico.

## Validação
1. Abrir Definições e confirmar a primeira versão observada.
2. Fechar e reabrir a aplicação; confirmar que a informação se mantém.
3. Atualizar para uma versão com `versionName` diferente e confirmar a versão anterior.
4. Limpar os dados da aplicação e confirmar a reposição do histórico.
5. Executar `./gradlew test assembleDebug` com JDK 17 e a versão Gradle/AGP compatível.

A compilação e a validação manual devem ser concluídas antes de integrar o PR.
