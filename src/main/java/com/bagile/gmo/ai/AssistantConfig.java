package com.bagile.gmo.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties(AssistantProperties.class)
public class AssistantConfig {

    static final String SYSTEM_PROMPT = """
            You are the assistant of a Transport Management System (TMS) used by a Moroccan road-transport company.
            Today is {today} (timezone Africa/Casablanca). The user is {user}.

            Vocabulary used in the application:
            - "ordre de transport" (OT, code like OT5797) = a customer transport order (client, route, price).
            - "plan de transport" / "voyage" / trip = the execution of an order by a driver ("chauffeur") and a vehicle
              (identified by its registration number, "matricule", e.g. 95225-A-7).
            - Statuses: CRÉE, VALIDÉ, En Cours, CHARGÉ, Fin Chargement, DECHARGÉ, Fin Dechargement, ARRIVÉ, FERMÉ, ANNULÉ, FACTURÉ, REGLÉ.
            - Prices are in Moroccan dirhams (MAD). HT = excluding VAT, TTC = including VAT.

            Rules:
            - Answer ONLY from the data returned by your tools. Never invent orders, drivers, vehicles, amounts or dates.
              If a tool returns nothing, say so and suggest how to refine the question.
            - Resolve relative dates ("this week", "last month", "hier", "had simana") yourself into ISO dates (yyyy-MM-dd) before calling tools.
            - If a tool says the user lacks permission, tell them politely they do not have access to that information.
            - Reply in the language of the user's question (French, English, or Moroccan Darija in Latin letters).
            - Be concise: short sentences, bullet points or a small markdown table for lists. Format amounts like 10 329,60 MAD.
            - When a list was truncated, say how many results exist in total.
            - You can only read data. If asked to create, modify or delete something, explain which screen of the TMS to use instead.
            """;

    /** Keeps Gemini 3 function calling working through the OpenAI-compatible endpoint (see the interceptor). */
    @Bean
    RestClientCustomizer geminiThoughtSignatureCustomizer(ObjectMapper objectMapper) {
        GeminiThoughtSignatureInterceptor interceptor = new GeminiThoughtSignatureInterceptor(objectMapper);
        // Timeouts so a slow or stuck LLM call can never hang the user's request forever.
        ClientHttpRequestFactorySettings timeouts = ClientHttpRequestFactorySettings.DEFAULTS
                .withConnectTimeout(Duration.ofSeconds(10))
                .withReadTimeout(Duration.ofSeconds(60));
        return builder -> builder
                .requestFactory(ClientHttpRequestFactories.get(timeouts))
                .requestInterceptor(interceptor);
    }

    @Bean
    ChatMemory assistantChatMemory(AssistantProperties properties) {
        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .maxMessages(properties.maxMessages())
                .build();
    }

    @Bean
    ChatClient assistantChatClient(ChatClient.Builder builder, ChatMemory assistantChatMemory, TmsAssistantTools tools) {
        return builder
                .defaultSystem(SYSTEM_PROMPT)
                .defaultTools(tools)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(assistantChatMemory).build())
                .build();
    }
}
