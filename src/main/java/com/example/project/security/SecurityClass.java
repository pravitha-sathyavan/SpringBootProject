package com.example.project.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityClass {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    public void configureGlobal(@NotNull AuthenticationManagerBuilder auth) throws Exception {
        log.info("Setting in-memory security");
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }

    @Bean
    public SecurityFilterChain securityConfiguration(HttpSecurity http) throws Exception{
        return http
                .csrf((csrf)->csrf.disable())
                .build();
    }


}