package com.bagile.gmo.config;

import com.bagile.gmo.config.filter.CustomAccessDeniedHandler;
import com.bagile.gmo.config.filter.CustomAuthenticationEntryPoint;
import com.bagile.gmo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Stateless JWT security configuration (Spring Security 6).
 *
 * <p>Authorization is managed centrally here (no per-endpoint {@code @PreAuthorize}). Each protected
 * resource is mapped to its habilitation code in {@link #RESOURCE_CODES}; the rule loop then derives
 * the required authority from the HTTP method:</p>
 * <ul>
 *   <li>GET    {@code /resource/**}         -> {@code CODE} or {@code CODE_VIEW}</li>
 *   <li>POST   {@code /resource/delete*}    -> {@code CODE} or {@code CODE_DELETE}</li>
 *   <li>DELETE {@code /resource/**}         -> {@code CODE} or {@code CODE_DELETE}</li>
 *   <li>PUT    {@code /resource/**}         -> {@code CODE} or {@code CODE_EDIT}</li>
 *   <li>POST   {@code /resource/**}         -> {@code CODE} or {@code CODE_CREATE} or {@code CODE_EDIT}</li>
 * </ul>
 *
 * <p>The bare entity code is always accepted because the habilitation set is uneven (e.g. HABILITATION
 * has no _VIEW/_CREATE). Authorities come from the JWT (the user's habilitation codes). Any path not
 * listed falls through to {@code authenticated()}, so nothing is accidentally locked down. To protect
 * another resource, add one line to {@link #RESOURCE_CODES}.</p>
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    /** URL prefix (controller base path) -> habilitation code root. */
    private static final Map<String, String> RESOURCE_CODES = new LinkedHashMap<>();
    static {
        // Administration / security-sensitive (the "gestion des habilitations")
        RESOURCE_CODES.put("/habilitations", "HABILITATION");
        RESOURCE_CODES.put("/groupHabilitations", "GROUP_HABILITATION");
        RESOURCE_CODES.put("/userGroups", "USER_GROUP");
        RESOURCE_CODES.put("/users", "USER");
        // Core domain resources
        RESOURCE_CODES.put("/accounts", "ACCOUNT");
        RESOURCE_CODES.put("/activityAreas", "ACTIVITY_AREA");
        RESOURCE_CODES.put("/contacts", "CONTACT");
        RESOURCE_CODES.put("/companys", "COMPANY");
        RESOURCE_CODES.put("/drivers", "DRIVER");
        RESOURCE_CODES.put("/insurances", "INSURANCE");
        RESOURCE_CODES.put("/orderTransports", "TRANSPORT_ORDER");
        RESOURCE_CODES.put("/transportPlans", "TRANSPORT_PLAN");
        RESOURCE_CODES.put("/transports", "TRANSPORT");
        RESOURCE_CODES.put("/vehicleCategories", "CATEGORY_VEHICLE");
        RESOURCE_CODES.put("/vehicleTrays", "VEHICLE_TRAY");
        RESOURCE_CODES.put("/subscriptionCards", "SUBSCRIPTION_CARD");
        RESOURCE_CODES.put("/subscriptionCardTypes", "SUBSCRIPTION_CARD_TYPE");
    }

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomAuthenticationEntryPoint authEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          CustomAuthenticationEntryPoint authEntryPoint,
                          CustomAccessDeniedHandler accessDeniedHandler) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authEntryPoint = authEntryPoint;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    // 0) CORS preflight requests carry no Authorization header, so they must be
                    //    allowed through or every cross-origin call with a Bearer token would be
                    //    blocked by a 401 on its OPTIONS preflight.
                    auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    // 1) Public / authentication endpoints
                    auth.requestMatchers("/api/auth/login", "/api/auth/refresh", "/authentification",
                            "/monitoring", "/api/public/**").permitAll();
                    // 2) Reserved admin area
                    auth.requestMatchers("/api/admin/**").hasAuthority("ADMIN");

                    // 3) Habilitation-based rules per resource (registered specific-first)
                    RESOURCE_CODES.forEach((path, code) -> {
                        String base = path + "/**";
                        auth.requestMatchers(HttpMethod.GET, base)
                                .hasAnyAuthority(code, code + "_VIEW");
                        // delete must be matched before the generic POST rule below
                        auth.requestMatchers(HttpMethod.POST, path + "/delete", path + "/delete/**", path + "/deleteAll")
                                .hasAnyAuthority(code, code + "_DELETE");
                        auth.requestMatchers(HttpMethod.DELETE, base)
                                .hasAnyAuthority(code, code + "_DELETE");
                        auth.requestMatchers(HttpMethod.PUT, base)
                                .hasAnyAuthority(code, code + "_EDIT");
                        auth.requestMatchers(HttpMethod.POST, base)
                                .hasAnyAuthority(code, code + "_CREATE", code + "_EDIT");
                    });

                    // 4) Everything else just needs a valid token
                    auth.requestMatchers("/api/user/**").authenticated();
                    auth.anyRequest().authenticated();
                })
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(authEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
