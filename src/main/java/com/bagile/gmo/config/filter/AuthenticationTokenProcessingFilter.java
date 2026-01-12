package com.bagile.gmo.config.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.bagile.gmo.util.TokenUtils;

@Component
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

    @Autowired
    private TokenUtils tokenUtils;

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = this.getAsHttpRequest(request);

        String authToken = this.extractAuthTokenFromRequest(httpRequest);
        String userName = tokenUtils.getUserNameFromToken(authToken);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            if (tokenUtils.validateToken(authToken)) {
                List<String> perms = tokenUtils.getPermissionsFromToken(authToken);
                List<SimpleGrantedAuthority> authorities = perms.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                UsernamePasswordAuthenticationToken token =
                        new UsernamePasswordAuthenticationToken(userName, null, authorities);
                token.setDetails(new WebAuthenticationDetails((HttpServletRequest) request));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }

        chain.doFilter(request, response);
    }

    private HttpServletRequest getAsHttpRequest(ServletRequest request) {

        if (!(request instanceof HttpServletRequest)) {
            throw new RuntimeException("Expecting an HTTP request");
        }
        return (HttpServletRequest) request;
    }

    private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
        String authHeader = httpRequest.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        String authToken = httpRequest.getHeader("token");
        if (authToken == null || authToken.isEmpty()) {
            authToken = httpRequest.getParameter("token");
        }
        return authToken;
    }

}
