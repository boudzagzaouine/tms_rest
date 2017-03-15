package com.sinno.ems.config;

import com.sinno.ems.config.filter.AuthenticationTokenProcessingFilter;
import com.sinno.ems.config.filter.CustomAccessDeniedHandler;
import com.sinno.ems.config.filter.CustomAuthenticationEntryPoint;
import com.sinno.ems.config.filter.SimpleCORSFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationTokenProcessingFilter authenticationTokenFilter;

    @Autowired
    private CustomAuthenticationEntryPoint authEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private SimpleCORSFilter filter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(authenticationService);

        auth.userDetailsService(userDetailsService).passwordEncoder(
                passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
        http.sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.ALWAYS);

        http.authorizeRequests()
                .antMatchers("/authentification", "/monitoring")
                .permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .addFilterBefore(authenticationTokenFilter,
                        UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable().exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // new Md5PasswordEncoder();
        return new BCryptPasswordEncoder();
    }

}