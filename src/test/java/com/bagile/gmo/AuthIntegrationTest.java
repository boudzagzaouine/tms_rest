package com.bagile.gmo;

import com.bagile.gmo.login.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthenticationManager authenticationManager;

    @Test
    public void loginAndAccessProtectedEndpoint() throws Exception {
        // Arrange: mock authentication manager to return an Authentication with USER_READ authority
        UserDetails userDetails = User.withUsername("tester").password("pass").authorities(new SimpleGrantedAuthority("USER_READ"), new SimpleGrantedAuthority("USER_CREATE")).build();
        Authentication auth = org.mockito.Mockito.mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn(userDetails);
        when(authenticationManager.authenticate(any())).thenReturn(auth);

        // Act: call login
        LoginRequest login = new LoginRequest();
        login.setEmail("tester");
        login.setPassword("pass");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequest> request = new HttpEntity<>(login, headers);

        ResponseEntity<String> loginResp = restTemplate.postForEntity("/auth/login", request, String.class);
        assertThat(loginResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        String body = loginResp.getBody();
        assertThat(body).contains("token");

        Map<?,?> map = objectMapper.readValue(body, Map.class);
        String token = (String) map.get("token");

        // call protected resource
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setBearerAuth(token);
        HttpEntity<Void> req2 = new HttpEntity<>(headers2);
        ResponseEntity<String> protectedResp = restTemplate.exchange("/api/test/secure", HttpMethod.GET, req2, String.class);

        // Assert
        assertThat(protectedResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(protectedResp.getBody()).isEqualTo("secure-data");
    }
}
