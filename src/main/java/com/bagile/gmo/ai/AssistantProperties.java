package com.bagile.gmo.ai;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Settings for the TMS AI assistant, bound from {@code tms.assistant.*}.
 *
 * @param enabled     turns the assistant endpoint on or off
 * @param apiKey      LLM API key (Gemini or OpenAI). When blank, the endpoint answers 503 instead of failing.
 * @param maxMessages how many past messages of a conversation are sent back to the model
 */
@ConfigurationProperties("tms.assistant")
public record AssistantProperties(boolean enabled, String apiKey, int maxMessages) {

    public AssistantProperties {
        if (maxMessages <= 0) {
            maxMessages = 20;
        }
    }

    public boolean isConfigured() {
        return enabled && apiKey != null && !apiKey.isBlank() && !"not-set".equals(apiKey);
    }
}
