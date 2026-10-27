# VCC Fala & Aprende

**Especificação funcional e técnica completa — Android**  
Versão: 1.0 | Data: 27-10-2026 | Idioma: português europeu (pt-PT)

## 1. Visão do produto

Aplicação educativa e de apoio à intervenção em terapia da fala para crianças, orientada inicialmente para os **3 aos 10 anos**. Disponibiliza atividades lúdicas de linguagem, consciência fonológica, articulação, vocabulário, compreensão, narrativa, pré-leitura, leitura e escrita, com acompanhamento por pais/cuidadores e terapeutas da fala.

**Limite clínico:** a aplicação é uma ferramenta complementar e **não diagnostica, não prescreve tratamento e não substitui avaliação ou intervenção de um terapeuta da fala**. Os conteúdos e critérios de progressão devem ser revistos por profissionais habilitados.

### Objetivos
- Facilitar treino consistente, motivador e acessível.
- Permitir planos personalizados por competência e dificuldade.
- Oferecer feedback lúdico sem rotular a fala da criança como correta/incorreta com base apenas em IA.
- Funcionar **offline-first**, sem publicidade nem rastreio comercial.
- Proteger dados e gravações de menores por desenho.

### Públicos e perfis
- **Criança:** atividades com interface simples, áudio, imagens e recompensas.
- **Responsável:** gestão de perfis, limites, consentimentos, progresso e exercícios em casa.
- **Terapeuta:** biblioteca, planos, observações, sessões e relatórios; acesso condicionado à autorização dos responsáveis.
- **Administrador de conteúdos:** revisão editorial, versões e publicação de pacotes de exercícios.

## 2. Catálogo completo de módulos funcionais

### M01 — Onboarding, consentimento e segurança infantil
- Introdução acessível para responsáveis; escolha de idioma e voz pt-PT.
- Consentimento informado para gravação de áudio, exportação e partilha opcional.
- Porta parental (PIN ou autenticação do dispositivo) para definições sensíveis.
- Política de privacidade clara; dados mínimos; eliminação de perfil e dados.
- Acesso offline e sem criação obrigatória de conta.

### M02 — Perfis de crianças
- Nome/apelido, avatar, faixa etária, preferências e necessidades de acessibilidade.
- Múltiplos perfis no mesmo dispositivo; progresso separado.
- Objetivos de aprendizagem definidos pelo adulto/terapeuta, sem diagnóstico automático.
- Configuração de duração e intensidade das sessões.

### M03 — Avaliação inicial pedagógica e definição de objetivos
- Questionário opcional para responsáveis e seleção de competências a trabalhar.
- Atividades de observação inicial, **sem interpretação diagnóstica**.
- Metas mensuráveis (ex.: completar 8 atividades de segmentação silábica).
- Registo de observações manuais pelo terapeuta.

### M04 — Sons da fala e articulação
- Biblioteca de fonemas do português europeu, com exemplos áudio revistos.
- Treino progressivo: som isolado → sílaba → palavra → frase → uso contextualizado.
- Posição do som na palavra: inicial, medial e final, quando aplicável.
- Ilustrações e demonstrações de movimentos articulatórios validadas por terapeuta.
- Pares mínimos e contrastes fonológicos selecionados por profissional.
- Sem classificação automática clínica de articulação.

### M05 — Discriminação auditiva
- Identificar sons, palavras semelhantes e diferenças auditivas.
- Escolher entre imagens após ouvir estímulo; repetir áudio sem penalização.
- Níveis de dificuldade e registo de tentativas.
- Recomendação de auscultadores apenas quando adequado e com volume seguro.

### M06 — Consciência fonológica
- Rimas, aliteração, identificação de som inicial/final.
- Segmentação e combinação silábica; contagem de sílabas.
- Atividades fonémicas adequadas à idade e desenvolvimento.
- Cartões, arrastar e largar, seleção múltipla e áudio.

### M07 — Vocabulário e semântica
- Nomeação e reconhecimento de objetos, animais, alimentos, ações e lugares.
- Categorias, atributos, opostos, associações e relações semânticas.
- Pacotes temáticos e vocabulário quotidiano em pt-PT.
- Cartões visuais com imagem, palavra, áudio e frases de exemplo.

### M08 — Compreensão oral e instruções
- Instruções simples e sequenciais (1–3 passos, conforme capacidade).
- Compreensão de perguntas: quem, o quê, onde, quando e porquê.
- Histórias curtas com perguntas de compreensão.
- Ajustes de velocidade, repetição e apoio visual.

### M09 — Morfossintaxe e construção frásica
- Ordenar palavras para formar frases.
- Completar frases, concordância e tempos verbais adequados ao nível.
- Descrever imagens e construir frases progressivamente mais elaboradas.
- Exercícios com feedback explicativo e exemplos naturais de pt-PT.

### M10 — Narrativa e comunicação funcional
- Sequências de 3–6 imagens para contar histórias.
- Início, desenvolvimento e fim; personagens, locais e acontecimentos.
- Simulações de pedidos, turnos de conversa e situações do quotidiano.
- Gravação opcional de narrativas para revisão por adulto/terapeuta.

### M11 — Pré-leitura, leitura e escrita
- Relação grafema–fonema, reconhecimento de letras e sílabas.
- Formação de palavras, leitura guiada e correspondência imagem–texto.
- Escrita por seleção, teclado e traçado quando apropriado.
- Ortografia e compreensão de frases/textos graduados.
- Adaptação a crianças ainda não alfabetizadas.

### M12 — Jogos terapêuticos e gamificação
- **Qual é a palavra?**: ouvir e selecionar imagem.
- **Constrói a palavra**: juntar sílabas/letras.
- **Encontra a rima**: identificar pares rimados.
- **Conta a história**: ordenar cartões e narrar.
- **Caça ao som**: encontrar imagens com som-alvo.
- **Memória dos sons**: pares imagem–áudio.
- **Bingo das palavras**: reconhecimento auditivo.
- **Completa a frase**: escolher termo adequado.
- **Descobre a diferença**: discriminação entre palavras próximas.
- **Cartões A/B/C**: três imagens, escolha e revelação lúdica de smile; simulação visual de revelação ao toque/pressão prolongada (ecrãs não detetam calor do dedo).
- Recompensas cosméticas, sem mecanismos de pressão ou publicidade.

### M13 — Biblioteca de áudio e leitura em voz alta
- Vozes pt-PT instaladas no dispositivo (TextToSpeech) com fallback para áudio gravado.
- Reprodução lenta, normal e repetição; controlo de volume.
- Áudio humano de referência para fonemas e palavras sensíveis à pronúncia.
- Legendas e transcrições quando disponíveis.

### M14 — Gravação e reprodução de voz
- Gravar tentativa de palavra, frase ou história com autorização.
- Ouvir lado a lado o modelo e a gravação da criança.
- Retenção configurável, eliminação imediata e controlo parental.
- Indicador claro de microfone ativo; sem gravação em segundo plano.
- Avaliação manual opcional pelo terapeuta; **não atribuir diagnóstico por reconhecimento automático**.

### M15 — Sessões e planos personalizados
- Plano por criança com objetivos, atividades, frequência e duração sugerida.
- Sessões livres, guiadas ou atribuídas pelo terapeuta.
- Pausa e retoma; descanso; duração adequada à idade.
- Histórico de atividades, notas e ajustes do plano.

### M16 — Área dos pais e cuidadores
- Painel de evolução, calendário e atividades para casa.
- Recomendações de participação sem pressão nem comparação entre crianças.
- Definições de áudio, acessibilidade, privacidade e tempo de utilização.
- Gestão de consentimentos, exportação e eliminação de dados.

### M17 — Área do terapeuta da fala
- Lista de crianças autorizadas e planos individualizados.
- Criação/edição de atividades e seleção de alvos linguísticos.
- Observações estruturadas, avaliação manual e notas por sessão.
- Revisão de gravações quando autorizada e disponível no dispositivo ou por partilha explícita.
- Relatórios exportáveis para acompanhamento, com linguagem não diagnóstica automatizada.

### M18 — Progresso, relatórios e estatísticas
- Métricas: atividades realizadas, taxa de respostas, tempo, regularidade e evolução por competência.
- Distinguir desempenho em jogos de evolução clínica.
- Gráficos por período e objetivo; comparação apenas da criança consigo própria.
- Exportação PDF/CSV/JSON com controlo de acesso.

### M19 — Editor e catálogo de conteúdos
- Gestão de cartões, imagens, áudios, palavras, instruções e respostas.
- Metadados: competência, faixa etária, nível, fonema, posição, tema e origem.
- Validação editorial e revisão clínica antes de distribuir conteúdos.
- Importação/exportação JSON com esquema versionado.
- Licenças de imagens/áudio registadas; evitar cópia de materiais protegidos.

### M20 — Acessibilidade e inclusão
- Tipografia legível, botões grandes, contraste, navegação sem leitura obrigatória.
- Redução de animações e efeitos sonoros; ausência de contagens regressivas obrigatórias.
- Apoio a TalkBack, texto escalável e alternativas à resposta oral.
- Ajuste sensorial e modos de utilização assistida.

### M21 — Configuração e personalização
- Tema, avatares, sons, ritmo de jogo e tipos de reforço positivo.
- Conteúdos por idade, competência e nível, com escolha manual do adulto.
- Preferências por perfil; exportação/restauro local.

### M22 — Pacotes de conteúdos e atualização
- Pacotes base instalados com a app e packs opcionais descarregáveis.
- Assinatura/checksum, versão, compatibilidade e rollback de pacotes.
- Atualização sem substituir progresso local.
- Operação integral sem ligação à Internet para packs instalados.

### M23 — Sincronização e partilha opcional (fase avançada)
- Sincronização entre dispositivos **desativada por defeito**.
- Autorização granular para partilha entre responsável e terapeuta.
- Encriptação em trânsito e em repouso; revogação de acesso.
- Não criar backend nem enviar áudio para terceiros no MVP.

### M24 — Administração, qualidade e auditoria
- Versionamento de conteúdos e histórico de alterações.
- Testes automáticos de integridade dos exercícios e respostas.
- Registo local de erros sem dados pessoais em logs.
- Auditoria de acessos a gravações/relatórios, quando houver perfis profissionais.

## 3. Ecrãs e navegação

1. Splash / apresentação.
2. Onboarding e consentimentos.
3. Seleção/criação de perfil.
4. Início da criança: atividades recomendadas e jogos.
5. Disciplinas/competências (sons, sílabas, vocabulário, frases, histórias, leitura).
6. Catálogo e filtros de atividades.
7. Ecrã de atividade multimédia (imagem, áudio, opções, feedback).
8. Ecrã de gravação e comparação de áudio.
9. Ecrã de recompensa e conclusão de sessão.
10. Plano de atividades / calendário.
11. Painel parental com porta de acesso.
12. Progresso e relatórios.
13. Gestão de privacidade, dados e consentimentos.
14. Área profissional do terapeuta.
15. Editor de exercícios e planos.
16. Gestão de pacotes de conteúdos.
17. Definições e acessibilidade.

**Fluxo principal:** perfil → atividade → instrução por áudio/imagem → resposta → feedback encorajador → registo de progresso → atividade seguinte.

## 4. Requisitos não funcionais

- Android: definir `minSdk` após avaliação de dispositivos-alvo; sugestão inicial API 26+.
- Totalmente utilizável offline para conteúdo instalado.
- Arranque rápido, resposta tátil imediata, armazenamento eficiente de áudio.
- Conteúdos e locuções revistos para português europeu.
- Privacidade infantil: minimização de dados, retenção curta e configurável, sem publicidade e sem analytics de terceiros por defeito.
- Cumprimento aplicável do RGPD, incluindo requisitos relativos a menores, com revisão jurídica antes de distribuição.
- Sem decisões clínicas automatizadas; funcionalidades de análise acústica futura sujeitas a validação científica, revisão regulatória e eventual enquadramento como dispositivo médico conforme finalidade anunciada.

## 5. Arquitetura técnica

**Stack recomendada:** Kotlin, Jetpack Compose, Material 3, MVVM + Clean Architecture, Hilt, Coroutines/Flow, Navigation Compose, Room, DataStore, MediaRecorder/AudioRecord, Media3/ExoPlayer, Android TextToSpeech, WorkManager para tarefas locais.

```text
app/
  core/
    database/          # Room, migrations
    media/             # áudio, gravação, TTS
    privacy/           # consentimento, retenção, encriptação
    ui/                # tema, componentes, acessibilidade
    content/           # importação/validação de packs
  feature/
    onboarding/
    profiles/
    home/
    articulation/
    auditory/
    phonology/
    vocabulary/
    comprehension/
    sentences/
    narrative/
    literacy/
    games/
    recording/
    sessions/
    plans/
    parent/
    therapist/
    reports/
    content_editor/
    settings/
```

### Camadas
- **Presentation:** Compose screens, ViewModels, estado UI.
- **Domain:** casos de uso (StartSession, SubmitAnswer, SaveRecording, BuildPlan, ExportReport).
- **Data:** Room, ficheiros locais, assets, repositórios e importadores.
- **Content:** catálogo versionado e regras de progressão configuráveis.

## 6. Modelo de dados (Room — proposta)

| Entidade | Campos principais | Objetivo |
|---|---|---|
| ChildProfile | id, displayName, birthYear?, avatarId, createdAt | Perfil infantil |
| GuardianSettings | id, pinHashRef, preferencesJson | Controlo parental |
| ConsentRecord | id, childId, purpose, granted, timestamp, version | Consentimentos |
| Skill | id, code, name, description | Competências |
| LearningObjective | id, childId, skillId, description, target, status | Metas |
| ContentPack | id, version, locale, license, checksum | Pacotes |
| Exercise | id, packId, skillId, type, difficulty, instructions, metadataJson | Exercícios |
| ExerciseOption | id, exerciseId, label, mediaId, isCorrect, sortOrder | Respostas |
| MediaAsset | id, type, localPath, attribution, checksum | Imagens/áudio |
| Session | id, childId, planId?, startedAt, endedAt | Sessões |
| Attempt | id, sessionId, exerciseId, responseJson, score?, durationMs | Tentativas |
| Recording | id, childId, sessionId, exerciseId, encryptedPath, createdAt, expiresAt | Gravações |
| TherapistNote | id, childId, sessionId?, note, authorAlias, createdAt | Observações |
| LearningPlan | id, childId, title, createdAt, status | Planos |
| PlanExercise | id, planId, exerciseId, sequence, frequency | Itens do plano |
| Reward | id, childId, rewardType, awardedAt | Recompensas |
| AuditEvent | id, eventType, entityId, timestamp | Auditoria local |

**Nota:** `birthYear` deve ser opcional e recolhido apenas se necessário; usar pseudónimos. Áudio guardado fora da BD, em armazenamento privado da aplicação e cifrado quando apropriado. Guardar na BD apenas metadados e caminhos controlados.

### Exemplo de exercício JSON

```json
{
  "schemaVersion": 1,
  "id": "PTPT_PHONO_RHYME_001",
  "locale": "pt-PT",
  "skill": "phonological_awareness",
  "type": "single_choice_audio_image",
  "ageRange": { "min": 4, "max": 7 },
  "instruction": "Qual destas palavras rima com gato?",
  "audioAsset": "audio/rimas/gato_intro.ogg",
  "options": [
    { "id": "A", "text": "pato", "image": "images/pato.webp", "correct": true },
    { "id": "B", "text": "mesa", "image": "images/mesa.webp", "correct": false },
    { "id": "C", "text": "bola", "image": "images/bola.webp", "correct": false }
  ],
  "feedback": { "positive": "Boa descoberta!", "retry": "Vamos ouvir outra vez." },
  "reviewStatus": "approved"
}
```

## 7. Motor de exercícios

**Tipos base:** seleção única/múltipla, correspondência, arrastar/ordenar, imagem–áudio, completar, gravação, resposta livre assistida e cartões A/B/C.

**Regras:**
- Cada exercício declara competência, pré-requisitos, estímulos, respostas, feedback e critérios de conclusão.
- Registar tentativas e tempo sem expor rankings públicos.
- Repetição adaptativa baseada no desempenho no jogo; decisões terapêuticas reservadas ao profissional.
- Evitar reforço negativo, mensagens punitivas e penalizações por hesitação.

## 8. Privacidade, segurança e aspetos clínicos

1. Consentimento dos responsáveis antes de gravar ou partilhar voz.
2. Gravações locais por defeito, com opção de eliminar e prazo de retenção configurável.
3. Exportações iniciadas pelo adulto, com confirmação e proteção dos ficheiros.
4. Permissões Android solicitadas apenas no momento da utilização.
5. Nunca enviar áudio para serviços externos sem informação e consentimento específicos.
6. Acesso profissional sujeito a autorização explícita e revogável.
7. Não apresentar percentagens de “qualidade clínica da pronúncia” calculadas por ASR genérico.
8. Conteúdos revistos por terapeutas da fala com experiência em português europeu.
9. Avaliar requisitos de proteção de dados e possível regulamentação de software médico antes de anunciar funcionalidades de diagnóstico/tratamento.
10. Não utilizar métricas de jogo como diagnóstico ou prova de eficácia terapêutica.

## 9. MVP — primeira versão utilizável

**Incluído:**
- Onboarding, consentimentos e 1–3 perfis locais.
- Biblioteca inicial de imagens/áudio pt-PT.
- Sons e palavras; rimas; sílabas; vocabulário; compreensão simples.
- Quatro jogos: Qual é a palavra?, Encontra a rima, Constrói a palavra e Cartões A/B/C.
- TTS/reprodução de áudio, sem exigir gravação para jogar.
- Sessões e progresso local básico.
- Área parental com PIN, configurações e eliminação de dados.
- Modo offline, acessibilidade essencial e testes automatizados.

**Fora do MVP:** análise automática de pronúncia, cloud, sincronização, portal web, partilha com terapeutas, editor avançado e relatórios clínicos.

### Critérios de aceitação do MVP
- Criança conclui uma sessão offline sem conta ou Internet.
- Todos os exercícios funcionam com toque e têm instruções acessíveis.
- Perfis isolados; progresso persistente após reiniciar a app.
- Responsável consegue apagar perfil e respetivos dados.
- Nenhuma gravação ou dado pessoal é transmitido automaticamente.
- Conteúdos pt-PT passam por revisão editorial e validação funcional.

## 10. Roadmap de desenvolvimento

| Fase | Entregas | Prioridade |
|---|---|---|
| F0 — Fundação | Repositório, arquitetura, design system, Room, testes, CI | Crítica |
| F1 — MVP | Perfis, consentimentos, biblioteca, 4 jogos, sessões, progresso | Crítica |
| F2 — Áudio | Gravação local, comparação, retenção e exportação controlada | Alta |
| F3 — Linguagem | Discriminação, frases, narrativa, leitura e escrita | Alta |
| F4 — Personalização | Planos, objetivos, atividades para casa, relatórios | Alta |
| F5 — Profissionais | Área de terapeuta, observações, editor e packs | Média |
| F6 — Avançado | Partilha consentida, sincronização opcional, análises validadas | Condicional |

### Backlog inicial por épicos

- **E01 Fundação:** criar projeto Compose; modularização; navegação; DI; base Room; testes; pipeline CI.
- **E02 Privacidade:** onboarding; consentimentos; porta parental; gestão de permissões; apagar/exportar dados.
- **E03 Perfis:** criar/editar criança; avatares; preferências; isolamento de dados.
- **E04 Conteúdos:** schema JSON; importador; assets; validação; catálogo pt-PT; versionamento.
- **E05 Áudio:** player; TTS pt-PT; gravação; comparação; retenção; proteção de ficheiros.
- **E06 Exercícios:** motor; respostas; feedback; progressão; persistência de tentativas.
- **E07 Jogos:** implementar cada jogo; cartões A/B/C; acessibilidade; recompensas.
- **E08 Linguagem:** articulação; discriminação; fonologia; vocabulário; compreensão; frases; narrativa; literacia.
- **E09 Sessões:** planos; calendário; histórico; metas; recomendações não clínicas.
- **E10 Adultos:** dashboard parental; terapeuta; editor; relatórios e exportação.
- **E11 Qualidade:** revisão clínica; QA infantil; acessibilidade; segurança; testes offline; publicação.

## 11. Estratégia de testes

- Unitários: regras do motor, progressão, validação JSON e cálculo de estatísticas.
- Integração: Room/migrações, permissões, ficheiros e eliminação completa.
- UI: navegação, áreas parental/infantil, TalkBack, fontes ampliadas e diferentes tamanhos de ecrã.
- Conteúdos: revisão linguística pt-PT, precisão de áudios e adequação etária.
- Privacidade: verificar ausência de tráfego externo inesperado e isolamento entre perfis.
- Testes com crianças apenas com consentimento, supervisão e procedimentos apropriados.

## 12. Definição de pronto (Definition of Done)

Uma funcionalidade está pronta quando: cumpre critérios de aceitação; tem testes adequados; funciona offline quando aplicável; respeita acessibilidade e privacidade; não inclui afirmações clínicas indevidas; e tem documentação técnica e funcional atualizada.

## 13. Decisões a fechar antes da implementação

1. Faixa etária inicial: 3–10 anos ou segmentação por grupos 3–5, 6–7 e 8–10.
2. Quantidade e autoria dos conteúdos de lançamento.
3. Participação de terapeuta(s) da fala na revisão editorial.
4. Política de retenção de áudio e modelo de consentimento.
5. Suporte apenas Android ou futura versão tablet/web.
6. Necessidade real de perfis profissionais e partilha remota em fases futuras.
7. Nome comercial definitivo e identidade visual.

---

**Resumo:** VCC Fala & Aprende combina jogos educativos, atividades linguísticas e ferramentas de acompanhamento, com foco no português europeu, privacidade infantil e utilização offline. A intervenção e a interpretação clínica permanecem sob responsabilidade dos profissionais de saúde competentes.
