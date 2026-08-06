package com.repmaster.repmaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures application security.
 */
@Configuration
public class SecurityConfig {

    /**
     * Creates a BCrypt password encoder.
     *
     * @return Password encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    /**
     * Allows access to all pages while keeping BCrypt available.
     *
     * @param http Spring Security configuration.
     * @return Security filter chain.
     * @throws Exception if configuration fails.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .anyRequest().permitAll()

                )

                .formLogin(form -> form.disable());

        return http.build();

    }

}