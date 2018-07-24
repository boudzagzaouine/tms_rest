package com.bagile.tms.config.core;

import com.sinno.ems.config.AppConfig;
import com.sinno.ems.config.filter.SimpleCORSFilter;
import net.bull.javamelody.MonitoringFilter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{RepositoryRestMvcConfiguration.class};
        //return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Instead we used SecurityWebApplicationInitializer

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                //new DelegatingFilterProxy("springSecurityFilterChain")
                new SimpleCORSFilter(), new MonitoringFilter()
        };
    }
}