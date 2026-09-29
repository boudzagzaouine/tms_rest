package com.bagile.gmo.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.util.UUID;

@Service
public class AssistantService {

    private static final Logger log = LoggerFactory.getLogger(AssistantService.class);
    private static final ZoneId CASABLANCA = ZoneId.of("Africa/Casablanca");

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;
    private final AssistantProperties properties;

    public AssistantService(ChatClient assistantChatClient, ChatMemory assistantChatMemory, AssistantProperties properties) {
        this.chatClient = assistantChatClient;
        this.chatMemory = assistantChatMemory;
        this.properties = properties;
    }

    public boolean isAvailable() {
        return properties.isConfigured();
    }

    public AssistantReply ask(String message, String conversationId) {
        String user = AccessGuard.currentUser();
        String conversation = conversationId == null || conversationId.isBlank()
                ? UUID.randomUUID().toString() : conversationId;
        LocalDate today = LocalDate.now(CASABLANCA);
        String todayText = today + " (" + today.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH) + ")";

        long start = System.currentTimeMillis();
        String answer = chatClient.prompt()
                .system(sys -> sys.param("today", todayText).param("user", user))
                .user(message)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, memoryKey(user, conversation)))
                .call()
                .content();
        log.info("Assistant answered user={} in {} ms", user, System.currentTimeMillis() - start);
        return new AssistantReply(conversation, answer);
    }

    public void forget(String conversationId) {
        chatMemory.clear(memoryKey(AccessGuard.currentUser(), conversationId));
    }

    /** Conversations are namespaced by user so nobody can read another user's history by guessing an id. */
    private static String memoryKey(String user, String conversationId) {
        return user + ":" + conversationId;
    }

    public record AssistantReply(String conversationId, String answer) {
    }

}
