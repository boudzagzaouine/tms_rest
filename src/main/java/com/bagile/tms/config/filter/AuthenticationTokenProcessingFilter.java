package com.bagile.tms.config.filter;

import com.sinno.ems.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = this.getAsHttpRequest(request);

        String authToken = this.extractAuthTokenFromRequest(httpRequest);
        String userName = TokenUtils.getUserNameFromToken(authToken);
        User user = null;
        if (null != SecurityContextHolder.getContext() && null != SecurityContextHolder.getContext().getAuthentication()) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        if (userName != null && user == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

            if (TokenUtils.validateToken(authToken, userDetails)) {

                UsernamePasswordAuthenticationToken token =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
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

//		String authToken = httpRequest.getParameter("token");
//		return authToken;
        String authToken = httpRequest.getHeader("token");
        if (null == authToken || "".equals(authToken)) {
            authToken = httpRequest.getParameter("token");
        }
        return authToken;
    }

}
