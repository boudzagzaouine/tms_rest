# TMS AI assistant

A chat assistant, available on every page of `tms_web`, that answers questions about the TMS data in plain
language: French, English or Darija written in Latin letters. Examples:

- "Quel est le chiffre d'affaires par client en juillet ?"
- "Donne-moi le détail de l'OT5797", then "Et où se trouve le camion de ce voyage ?"
- "Quels voyages sont en retard ?"
- "chkoun a7san chauffeur had l3am?"
- "Which vehicles have an overdue technical inspection?"

## How it works

```
tms_web (Angular)                      tms_rest (Spring Boot)                            LLM (Gemini)
floating chat widget  ──POST /api/assistant/chat──▶ AssistantController
  (JWT via JwtInterceptor)                            │
                                                      ▼
                                       Spring AI ChatClient ──── prompt + tool list ───▶ decides which
                                       + chat memory (per user)                          tool(s) to call
                                                      │ ◀──────── tool call ────────────
                                                      ▼
                                       TmsAssistantTools (read-only SQL, habilitations checked)
                                                      │ ──────── tool result ─────────▶ writes the answer
                                                      ▼ ◀──────── final answer ─────────
                                             answer (markdown) → rendered in the widget
```

The LLM **never writes SQL** and never sees the database directly. It can only call a fixed set of tools
(Spring AI `@Tool` methods), each backed by a parameterized, read-only query:

| Tool | What it answers |
|---|---|
| `searchTransportOrders` | Transport orders filtered by status, client, cities and dates |
| `getTransportOrder` | One order (e.g. OT5797) with all its trips, driver, vehicle and timestamps |
| `searchTrips` | Trips (plans de transport) by driver, vehicle, status, cities, dates, open only |
| `findDelayedTrips` | Trips in transit too long, or planned but never started |
| `getLastKnownPosition` | Last GPS point of a vehicle/driver/trip, the nearest city and a Google Maps link |
| `countByStatus` | Number of orders or trips per status |
| `revenueSummary` | Revenue HT/TTC and km by client, route or month |
| `activityRanking` | Driver or vehicle ranking: trips, closed trips, km, revenue |
| `listVehicles` | Fleet, availability, technical inspection and vignette due dates |

### Security

- The endpoint requires a valid JWT, like the rest of the API.
- Each tool checks the same habilitations as the matching REST resource (`TRANSPORT_ORDER*` for orders and
  revenue, `TRANSPORT_PLAN*` for trips, positions and rankings; `ADMIN` sees everything). A user who cannot
  open the trips screen gets "you don't have access" from the assistant too. This has been tested with a user
  whose group has orders but not trips.
- The tools are read-only. If a user asks to delete or change something, the assistant points to the right screen.
- Conversation memory is kept in memory on the server, keyed by user plus conversation id, and limited to the
  last 20 messages.

## Configuration

Everything is in `application.yml`, and each value can be overridden with an environment variable:

| Variable | Default | Purpose |
|---|---|---|
| `GEMINI_API_KEY` | *(none)* | API key from https://aistudio.google.com/apikey. Without it the app still starts; the chat shows "not configured". |
| `AI_MODEL` | `gemini-3.8-flash` | Model name. `gemini-3.5-flash-lite` is faster and has its own free quota. |
| `AI_REASONING_EFFORT` | `low` | Less "thinking" gives faster answers. |
| `AI_BASE_URL` / `AI_COMPLETIONS_PATH` | Gemini's OpenAI-compatible endpoint | Point these at OpenAI (or any OpenAI-compatible server) to switch provider. |
| `TMS_ASSISTANT_ENABLED` | `true` | Turns the feature off completely. |

**Switching to OpenAI:** set `AI_BASE_URL=https://api.openai.com`, `AI_COMPLETIONS_PATH=/v1/chat/completions`,
`AI_MODEL=gpt-4o-mini`, and put the OpenAI key in `GEMINI_API_KEY` (or rename the property).

### Free-tier limits (important)

The Gemini free tier allows about **5 requests per minute and 20 requests per day per model**. One question
uses 2 or 3 requests (question → tool call → answer), so that is roughly **7 to 10 questions per day**. That is
fine for a demo, but real use needs billing enabled on the Google project (Gemini Flash costs very little) or
another provider. When the quota is reached, the chat shows a clear "limit reached, try again in a minute" message.

### Gemini 3 "thought signatures"

Gemini 3 models reject a follow-up request unless the `thought_signature` returned with each function call is
sent back. Spring AI 1.0's OpenAI client drops that field, so `GeminiThoughtSignatureInterceptor` stores it by
tool-call id and puts it back on the next request. It only touches calls to `generativelanguage.googleapis.com`.

### Windows note

If startup fails with `Unable to establish loopback connection`, add this JVM option:
`-Djdk.net.unixdomain.tmpdir=C:\Temp` (create the folder first). It is a JDK/Windows temp-folder issue with
Netty, not an application bug.

## Files

Backend (`tms_rest`):
- `pom.xml`: Spring AI 1.0.9 BOM and `spring-ai-starter-model-openai`
- `src/main/resources/application.yml`: `spring.ai.*` and `tms.assistant.*`
- `src/main/java/com/bagile/gmo/ai/`
  - `AssistantController`: `POST /api/assistant/chat`, `GET /api/assistant/status`, `DELETE /api/assistant/conversations/{id}`
  - `AssistantService`: calls the model with the date, user and conversation memory
  - `AssistantConfig`: system prompt, ChatClient, memory, HTTP timeouts
  - `TmsAssistantTools`: the tools (SQL)
  - `AccessGuard`: habilitation checks
  - `GeminiThoughtSignatureInterceptor`, `AssistantProperties`

Frontend (`tms_web`):
- `src/app/layouts/assistant-chat/`: standalone component (floating button + panel), service, small markdown renderer
- `layout.component.html` / `layout.module.ts`: widget added to the main layout

## Ideas for next steps

- Stream the answer word by word (Server-Sent Events) instead of waiting for the full reply.
- Store conversations in PostgreSQL (`JdbcChatMemoryRepository`) so they survive restarts.
- Scope results by owner/agency for multi-company setups.
- Add write actions (e.g. "affecte le camion X au voyage Y") behind an explicit confirmation step.
