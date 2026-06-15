package com.bagile.gmo.smoke;

import com.bagile.gmo.entities.UsrUser;
import com.bagile.gmo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Phase 0 migration regression oracle (do NOT change behavior — only pin it).
 *
 * Purpose: capture the EXISTING runtime contract of the backend on Spring Boot 2.2 / Java 8
 * so the Java 21 / Spring Boot 3.4 / JWT migration can prove it did not silently break:
 *   1. The full Spring context boots (all entity mappings + wiring) against the dev DB.
 *   2. The security filter chain is active (protected endpoints reject anonymous calls).
 *   3. A token is accepted and a controller -> service -> repository -> DB round-trip works.
 *   4. The login endpoint is reachable without authentication (permitAll).
 *
 * Runs against the locally configured datasource (DBConfig -> localhost:5432/emsdb).
 * The real e-mail used for the token is read from the DB at runtime, so the test is not
 * coupled to any specific seeded row.
 *
 * NOTE: test #3 documents today's (intentionally permissive) token behaviour. After the JWT
 * migration this expectation is EXPECTED to change — update it deliberately, do not delete it.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SmokeBackendTest {

    private static final String CONTEXT_PATH = "/tms-rest";
    private static final String PROTECTED_READ = "/users/size";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private UserRepository userRepository;

    private String anActiveUserEmail;

    @BeforeEach
    void resolveRealUser() {
        List<UsrUser> users = userRepository.findAll();
        anActiveUserEmail = users.stream()
                .filter(u -> Boolean.TRUE.equals(u.getUsrUserIsActive()))
                .map(UsrUser::getUsrUserEmail)
                .filter(e -> e != null && !e.isEmpty())
                .findFirst()
                .orElse(null);
        assertNotNull(anActiveUserEmail, "Expected at least one active user with an e-mail in the dev DB");
    }

    private String url(String path) {
        return "http://localhost:" + port + CONTEXT_PATH + path;
    }

    /** 1. Full application context boots against the real schema. */
    @Test
    void contextBootsAndServerIsUp() {
        assertTrue(port > 0, "embedded server should have started on a random port");
    }

    /** 2. Security chain rejects an anonymous call to a protected endpoint. */
    @Test
    void protectedEndpoint_withoutToken_isRejected() {
        ResponseEntity<String> resp = rest.getForEntity(url(PROTECTED_READ), String.class);
        assertFalse(resp.getStatusCode().is2xxSuccessful(),
                "protected endpoint must NOT be reachable without a token, was: " + resp.getStatusCode());
    }

    /** 3. A token is accepted and the controller->service->repo->DB round-trip returns data. */
    @Test
    void protectedEndpoint_withToken_returnsCount() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", anActiveUserEmail + ":0:smoke"); // parts[0] must be a real e-mail
        ResponseEntity<String> resp = rest.exchange(
                url(PROTECTED_READ), HttpMethod.GET, new HttpEntity<>(headers), String.class);
        assertTrue(resp.getStatusCode().is2xxSuccessful(),
                "authenticated read should succeed, was: " + resp.getStatusCode());
        assertNotNull(resp.getBody());
        assertTrue(resp.getBody().trim().matches("\\d+"),
                "GET " + PROTECTED_READ + " should return a numeric count, was: " + resp.getBody());
    }

    /** 4. Login endpoint is permitAll (reachable without authentication). */
    @Test
    void loginEndpoint_isReachableWithoutAuth() {
        ResponseEntity<String> resp = rest.postForEntity(
                url("/authentification?email=no-such-user@example.invalid&password=nope"),
                null, String.class);
        assertFalse(resp.getStatusCode().value() == 401 || resp.getStatusCode().value() == 403,
                "login endpoint must be reachable without auth, was: " + resp.getStatusCode());
    }
}
