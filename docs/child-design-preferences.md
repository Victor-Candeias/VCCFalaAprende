# VCC-020 — Design system infantil: preferências visuais

Em **Definições > Aspeto da aplicação**, é possível selecionar os temas **Automático**, **Claro** ou **Escuro**. A escolha é aplicada imediatamente e guardada em `SharedPreferences` privados para as próximas execuções.

- O tema Automático segue a preferência do sistema operativo.
- O design system mantém tipografia, cores e dimensões de toque próprias da aplicação.
- Não existe recolha de dados pessoais, telemetria ou acesso à Internet.
- Valores inválidos ou inexistentes são interpretados como Automático.

## Validação

1. Selecionar Claro, Escuro e Automático e verificar contraste e legibilidade.
2. Reiniciar a aplicação e confirmar que o tema escolhido permanece.
3. Alterar o tema do sistema com Automático selecionado.
4. Testar TalkBack, escala de letra ampliada e alvos de toque.
5. Executar `./gradlew test assembleDebug`.

**Pendente:** compilação e validação visual/manual antes de integrar o PR.
