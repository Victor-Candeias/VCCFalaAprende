# GitHub Codespaces — VCC Fala & Aprende

1. No GitHub, seleciona **Code → Codespaces → Create codespace on main**.
2. Espera que o container instale Java 17 e Android SDK (API 35).
3. Abre um terminal e verifica: `java -version` e `sdkmanager --list_installed`.
4. Executa `./gradlew assembleDebug` para gerar o APK de debug.
5. O APK de debug ficará em `app/build/outputs/apk/debug/`.

## Limitações

O Codespaces é adequado a editar código, executar Gradle, testes unitários e gerar APKs. O emulador Android gráfico pode não funcionar num Codespace padrão; instala o APK num dispositivo físico ou usa Android Studio local para testes de interface.

## Versões e manutenção

A imagem usa Debian 12 e JDK 17. O SDK instala platform-tools, Android API 35 e build-tools 35.0.0. Atualiza as versões se o projeto Gradle exigir outra API. A instalação do SDK ocorre no primeiro arranque/rebuild e requer acesso à Internet.

## Notas de segurança

Não colocar tokens, chaves nem dados reais de crianças no repositório. Utilizar secrets do Codespaces para credenciais de serviços externos, se vierem a ser necessárias.
