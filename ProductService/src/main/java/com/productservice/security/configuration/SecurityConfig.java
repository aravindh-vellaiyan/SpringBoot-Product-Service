package com.productservice.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests((authorize) -> {
//            authorize.anyRequest().authenticated();
//        }).formLogin(Customizer.withDefaults());
        httpSecurity
                .authorizeHttpRequests((authorize) -> {
                    authorize
                            .anyRequest().authenticated();
                })
                .cors().disable()
                .csrf().disable()
        return httpSecurity.build();
    }
}
