package com.bagile.gmo.ai;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Chat endpoint of the TMS assistant. Protected by the global "any request must be authenticated" rule;
 * finer access control is applied inside each tool.
 */
@RestController
@RequestMapping("/api/assistant")
public class AssistantController {

    private static final Logger log = LoggerFactory.getLogger(AssistantController.class);

    private final AssistantService assistant;

    public AssistantController(AssistantService assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        return Map.of("available", assistant.isAvailable());
    }

    @PostMapping("/chat")
    public ResponseEntity<?> chat(@Valid @RequestBody ChatRequest request) {
        if (!assistant.isAvailable()) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("error", "The AI assistant is not configured (missing API key)."));
        }
        try {
            return ResponseEntity.ok(assistant.ask(request.message(), request.conversationId()));
        } catch (RuntimeException e) {
            if (isQuotaError(e)) {
                log.warn("Assistant rate limit / quota reached: {}", e.getMessage() == null ? e : e.getMessage().lines().findFirst().orElse(""));
                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                        .body(Map.of("error", "L'assistant a atteint sa limite de requêtes. Réessayez dans une minute."));
            }
            log.warn("Assistant call failed", e);
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(Map.of("error", "Le service d'IA n'a pas répondu. Réessayez dans un instant."));
        }
    }

    /** Free-tier LLM keys have a small requests-per-minute quota; detect it to show a clear message. */
    static boolean isQuotaError(Throwable e) {
        for (Throwable t = e; t != null; t = t.getCause()) {
            String m = t.getMessage();
            if (m != null && (m.contains("HTTP 429") || m.contains("RESOURCE_EXHAUSTED"))) {
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/conversations/{conversationId}")
    public ResponseEntity<Void> reset(@PathVariable String conversationId) {
        assistant.forget(conversationId);
        return ResponseEntity.noContent().build();
    }

    public record ChatRequest(@NotBlank @Size(max = 2000) String message, @Size(max = 100) String conversationId) {
    }
}
