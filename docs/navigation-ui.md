# VCC-011 — Interface de navegação Compose

## Alterações
- A barra inferior apresenta ícones vetoriais (Início, Atividades, Definições), em vez de letras.
- O separador selecionado continua assinalado por `NavigationBarItem` e tem descrição de estado pt-PT.
- O componente reutiliza o `NavHost` do VCC-003 e preserva as rotas existentes.
- Não são introduzidas novas permissões nem serviços de rede.

## Acessibilidade
Os ícones são decorativos (`contentDescription = null`), pois cada item já possui rótulo textual. A descrição do estado selecionado é fornecida através de `stateDescription`. Verificar com TalkBack para evitar leitura redundante.

## Testes
```bash
./gradlew clean test assembleDebug
```

Validar manualmente os três separadores, alternância repetida, seleção visual, modo escuro e TalkBack.
