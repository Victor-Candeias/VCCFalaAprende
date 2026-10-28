# VCC-015 — Pipeline CI

## Funcionalidade
A aplicação apresenta, em **Definições > Pipeline CI**, os passos do pipeline de integração contínua. Os dados são estáticos, funcionam offline e **não** indicam o estado real de uma execução. Para consultar resultados é necessário aceder ao GitHub Actions.

## Workflow
O ficheiro `.github/workflows/android-ci.yml` executa testes e compilação Debug com JDK 17 e Android SDK 35. Publica o APK Debug e os relatórios de teste, incluindo em caso de falha. O log do Gradle fica disponível como artefacto para diagnosticar falhas do daemon.

## Validação
```bash
./gradlew --no-daemon --max-workers=2 test assembleDebug
```

1. Abrir Definições > Pipeline CI e confirmar os quatro passos e o aviso de estado não sincronizado.
2. Confirmar que o ecrã funciona sem rede e com TalkBack.
3. Abrir o separador Actions no GitHub e confirmar artefactos do workflow.
4. Confirmar que os testes unitários passam.

Não são tratados dados pessoais ou avaliações clínicas.
