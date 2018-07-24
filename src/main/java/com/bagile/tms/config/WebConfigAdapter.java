/**
 *
 */
package com.bagile.tms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import net.bull.javamelody.SessionListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.List;
import java.util.Locale;

/**
 * @author SINNO
 */
@Configuration
@EnableWebMvc
public class WebConfigAdapter extends WebMvcConfigurerAdapter {

    // More configuration....

    /*
     * Here we register the Hibernate4Module into an ObjectMapper, then set this
     * custom-configured ObjectMapper to the MessageConverter and return it to
     * be added to the HttpMessageConverters of our application
     */
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();
        //mapper.enableDefaultTyping();
        //mapper.setVisibilityChecker(mapper.getVisibilityChecker().with(Visibility.ANY));
        // Registering Hibernate4Module to support lazy objects
        //mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.registerModule(new Hibernate4Module());
        //mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
//		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        messageConverter.setObjectMapper(mapper);

        return messageConverter;

    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        // Here we add our custom-configured HttpMessageConverter
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/message");
        messageSource.setDefaultEncoding("UTF-8");
        //      messageSource.
        return messageSource;
    }

    @Bean
    public SessionListener sessionListener() {
        return new SessionListener();
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("loc");
        registry.addInterceptor(interceptor);
    }

    // More configuration....
}
