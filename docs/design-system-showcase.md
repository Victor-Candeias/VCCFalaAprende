# VCC-012 — Interface de demonstração do design system infantil

## Objetivo
Permitir visualizar componentes reais do design system nas Definições, sem criar um segundo tema ou duplicar os tokens existentes.

## Ecrã
- Cartão de boas-vindas com tipografia de leitura confortável.
- Botão interativo com estado que muda localmente.
- Botão desativado, para exemplificar estados indisponíveis.
- Layout vertical com scroll para ecrãs pequenos.
- Suporte aos temas claro e escuro existentes.

## Regras
A interface é apenas uma demonstração: não recolhe dados pessoais, não usa serviços de rede e não avalia capacidades de crianças.

## Validação
```bash
./gradlew clean test assembleDebug
```

Abrir Definições > Ver componentes, testar o botão duas vezes, confirmar o botão desativado, rolagem, modo escuro e TalkBack.
