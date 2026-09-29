package com.bagile.gmo.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Gemini 3 models return a {@code thought_signature} with every function call and reject the next request
 * (HTTP 400 "Function call is missing a thought_signature") unless it is sent back with that call.
 * Spring AI's OpenAI-compatible client (1.0.x) does not keep this Gemini-specific field, so this interceptor
 * remembers the signature per tool-call id from each response and re-attaches it to the matching
 * assistant tool call in the following request. It only touches calls to generativelanguage.googleapis.com.
 */
class GeminiThoughtSignatureInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(GeminiThoughtSignatureInterceptor.class);
    private static final int MAX_ENTRIES = 2_000;

    private final ObjectMapper mapper;
    private final Map<String, String> signaturesByCallId = Collections.synchronizedMap(
            new LinkedHashMap<>(256, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                    return size() > MAX_ENTRIES;
                }
            });

    GeminiThoughtSignatureInterceptor(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        if (!isGeminiChatCall(request)) {
            return execution.execute(request, body);
        }
        byte[] outgoing = addSignatures(body);
        if (outgoing.length != body.length) {
            request.getHeaders().setContentLength(outgoing.length);
        }
        ClientHttpResponse response = execution.execute(request, outgoing);
        if (!response.getStatusCode().is2xxSuccessful()) {
            // leave error responses untouched so Spring AI's retry/error handling sees them as usual
            return response;
        }
        byte[] responseBody = response.getBody().readAllBytes();
        rememberSignatures(responseBody);
        return new BufferedResponse(response, responseBody);
    }

    static boolean isGeminiChatCall(HttpRequest request) {
        String host = request.getURI().getHost();
        return host != null && host.endsWith("generativelanguage.googleapis.com")
                && request.getURI().getPath().endsWith("/chat/completions");
    }

    byte[] addSignatures(byte[] body) {
        try {
            JsonNode root = mapper.readTree(body);
            boolean changed = false;
            for (JsonNode message : root.path("messages")) {
                for (JsonNode call : message.path("tool_calls")) {
                    String signature = signaturesByCallId.get(call.path("id").asText(""));
                    if (signature != null && call instanceof ObjectNode node && !node.has("extra_content")) {
                        node.putObject("extra_content").putObject("google").put("thought_signature", signature);
                        changed = true;
                    }
                }
            }
            return changed ? mapper.writeValueAsBytes(root) : body;
        } catch (IOException | RuntimeException e) {
            log.debug("Could not add Gemini thought signatures, sending request unchanged", e);
            return body;
        }
    }

    void rememberSignatures(byte[] responseBody) {
        try {
            for (JsonNode choice : mapper.readTree(responseBody).path("choices")) {
                for (JsonNode call : choice.path("message").path("tool_calls")) {
                    String id = call.path("id").asText("");
                    String signature = call.path("extra_content").path("google").path("thought_signature").asText("");
                    if (!id.isEmpty() && !signature.isEmpty()) {
                        signaturesByCallId.put(id, signature);
                    }
                }
            }
        } catch (IOException | RuntimeException e) {
            log.debug("Could not read Gemini thought signatures", e);
        }
    }

    /** The original response with its body already read into memory, so it can be consumed again. */
    private static final class BufferedResponse implements ClientHttpResponse {
        private final ClientHttpResponse delegate;
        private final byte[] body;

        BufferedResponse(ClientHttpResponse delegate, byte[] body) {
            this.delegate = delegate;
            this.body = body;
        }

        @Override
        public HttpStatusCode getStatusCode() throws IOException {
            return delegate.getStatusCode();
        }

        @Override
        public String getStatusText() throws IOException {
            return delegate.getStatusText();
        }

        @Override
        public HttpHeaders getHeaders() {
            return delegate.getHeaders();
        }

        @Override
        public InputStream getBody() {
            return new ByteArrayInputStream(body);
        }

        @Override
        public void close() {
            delegate.close();
        }
    }
}
