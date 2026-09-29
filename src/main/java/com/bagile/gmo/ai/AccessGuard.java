package com.bagile.gmo.ai;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The assistant must never show more than the user could see in the screens. Each tool checks the same
 * habilitation codes that {@code SecurityConfig} requires on the matching REST resource.
 * Tools run synchronously on the request thread, so the caller's SecurityContext is available here.
 */
final class AccessGuard {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AccessGuard.class);

    static final String[] ORDERS = {"TRANSPORT_ORDER", "TRANSPORT_ORDER_VIEW"};
    static final String[] TRIPS = {"TRANSPORT_PLAN", "TRANSPORT_PLAN_VIEW"};

    private AccessGuard() {
    }

    static void requireAny(String area, String... codes) {
        LOG.info("Assistant tool called ({}) by {}", area, currentUser());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new AssistantAccessDeniedException("User is not authenticated.");
        }
        Set<String> granted = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        if (granted.contains("ADMIN") || Arrays.stream(codes).anyMatch(granted::contains)) {
            return;
        }
        throw new AssistantAccessDeniedException(
                "Permission denied: the user has no access to " + area + ". Do not reveal any " + area + " data.");
    }

    static String currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth == null ? "anonymous" : auth.getName();
    }

    static class AssistantAccessDeniedException extends RuntimeException {
        AssistantAccessDeniedException(String message) {
            super(message);
        }
    }
}
