package com.starterkit.springboot.brs.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;

/**
 * Created by Arpit Khandelwal.
 */
@Configuration
public class PageConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/agency").setViewName("agency");
        registry.addViewController("/bus").setViewName("bus");
        registry.addViewController("/trip").setViewName("trip");
        registry.addViewController("/logout").setViewName("logout");
    }
    @Bean
    public LayoutDialect layoutDialect(){
        return new LayoutDialect();
    }
    @Bean
    public TemplateEngine templateEngine(){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addDialect(layoutDialect());
        return templateEngine;
    }
}
