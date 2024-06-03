package com.springmvcproject.stickynotes.config;

import ch.qos.logback.core.joran.action.NOPAction;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authRequest -> {
            authRequest.requestMatchers("/about", "/css/**").permitAll();
            authRequest.requestMatchers("/","/note/**","/my-notes/**").authenticated();
            authRequest.requestMatchers("/users/**").hasAnyRole("ADMIN");

        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return  http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}