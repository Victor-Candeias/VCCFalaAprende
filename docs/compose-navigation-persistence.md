# VCC-019 — Persistência da navegação Compose

A aplicação guarda localmente apenas a última secção principal visitada: **Início**, **Atividades** ou **Definições**. Ao reiniciar a aplicação, a navegação começa nessa secção.

## Segurança e limites

- Persistência privada com `SharedPreferences`, sem rede nem permissões adicionais.
- Rotas internas (armazenamento, arquitetura, erros, pipeline) não são guardadas.
- Rotas desconhecidas são tratadas como **Início**.
- Não são guardados parâmetros de navegação, conteúdos de atividades nem dados de crianças.
- A navegação continua a usar `NavHost` e `navigateToTopLevel` para preservar o estado e evitar duplicados.

## Validação

1. Navegar para **Atividades**, fechar e reabrir a aplicação: deve iniciar em Atividades.
2. Repetir com **Definições**.
3. Abrir um ecrã técnico, fechar e reabrir: deve regressar à última secção principal.
4. Limpar os dados da aplicação: deve iniciar em **Início**.
5. Verificar TalkBack e executar `./gradlew test assembleDebug`.

**Pendente:** compilação, testes no dispositivo e revisão funcional.
