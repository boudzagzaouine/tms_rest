package com.bagile.gmo.config.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
//@PropertySource("classpath:mail/emailconfig.properties")
public class SpringMailConfig {

    private static final String JAVA_MAIL_FILE = "classpath:mail/javamail.properties";

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl ( );
        mailSender.setHost ("smtp.gmail.com");
        mailSender.setPort (587);

        mailSender.setUsername ("my.gmail@gmail.com");
        mailSender.setPassword ("password");

        Properties props = mailSender.getJavaMailProperties ( );
        props.put ("mail.transport.protocol", "smtp");
        props.put ("mail.smtp.auth", "true");
        props.put ("mail.smtp.starttls.enable", "true");
        props.put ("mail.debug", "true");

        return mailSender;
    }

}