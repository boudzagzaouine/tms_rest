package com.bagile.tms.config.core;

import com.bagile.tms.config.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {


    public SpringSecurityInitializer() {
        super(SecurityConfig.class);
    }
}