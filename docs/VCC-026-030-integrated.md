# VCC-026–030 — PIN, privacidade e microfone

## Funcionalidades implementadas

- **VCC-026:** PIN local de seis dígitos, PBKDF2-HMAC-SHA256 com salt aleatório e bloqueio temporário após cinco tentativas falhadas. A sessão de desbloqueio é apenas de memória e termina ao sair do ecrã. O PIN protege apenas o novo ecrã de privacidade; não constitui verificação da identidade parental.
- **VCC-027:** política de retenção apresentada em português e limpeza explícita das preferências técnicas conhecidas.
- **VCC-028:** exportação voluntária, através do seletor de ficheiros Android, de um **resumo JSON**, não dos dados completos.
- **VCC-029:** limpeza das preferências técnicas e revogação de consentimento. **Ainda não existem perfis infantis implementados para eliminar**; a base de dados Room e eventuais ficheiros de áudio não são eliminados por este fluxo.
- **VCC-030:** permissão `RECORD_AUDIO` declarada no manifesto e pedida apenas por ação explícita. Não é iniciada qualquer gravação.

## Limitações de segurança e privacidade

O PIN local não comprova a idade ou identidade de um responsável e o ecrã de consentimento anterior continua independente deste PIN. Não considerar estes fluxos uma implementação completa de controlo parental ou de RGPD. A exportação não inclui perfis, Room ou áudio. A limpeza não deve ser apresentada como eliminação integral dos dados.

## Validação pendente

1. `./gradlew test assembleDebug` (JDK 17).
2. Configurar PIN; testar desbloqueio, PIN inválido e cinco tentativas incorretas.
3. Verificar que o PIN não aparece em texto claro em preferências ou interface.
4. Exportar o JSON e confirmar que contém apenas o resumo descrito.
5. Confirmar limpeza de preferências e revogação de consentimento.
6. Testar permissão de microfone concedida, recusada e revogada nas definições Android.
7. Testar TalkBack, navegação e rotação do ecrã.
8. Rever privacidade infantil, gestão de perfis futuros, políticas de retenção e autenticação parental antes de produção.

**Estado:** implementação inicial submetida; testes de dispositivo e revisão de segurança pendentes.
