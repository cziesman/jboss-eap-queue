package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootJmsApp extends SpringBootServletInitializer {

    private static Class<SpringBootJmsApp> applicationClass = SpringBootJmsApp.class;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootJmsApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(applicationClass);
    }
}
