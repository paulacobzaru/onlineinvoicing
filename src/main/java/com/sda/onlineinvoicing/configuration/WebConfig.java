//https://frontbackend.com/thymeleaf/formatting-date-in-thymeleaf

package com.sda.onlineinvoicing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.LocalDate;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/pages/home");
        registry.addViewController("/pricing").setViewName("/pages/pricing");
        registry.addViewController("/contactus").setViewName("/pages/contactus");
        registry.addViewController("/register").setViewName("/pages/register");
        registry.addViewController("/app").setViewName("/app/index");
        registry.addViewController("/home").setViewName("/pages/home");
        registry.addViewController("/app/index").setViewName("app/index");
        registry.addViewController("/app/fragments/header").setViewName("fragments/header");
        registry.addViewController("/app/fragments/sidebar").setViewName("fragments/sidebar");
        registry.addViewController("/403").setViewName("/errors/403");
        registry.addViewController("/privacy").setViewName("/pages/privacy");
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.UK);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
