package com.demomasters.lifemasters.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Give access permissions to webapp
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authCustomizer -> authCustomizer
                        .requestMatchers(HttpMethod.POST, "/api/create-user").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/user/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/user/**").permitAll()
                        .requestMatchers("/api/users", "/api/user/**").permitAll()
                        .requestMatchers("/api/**").authenticated()
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Modify server user credentials
        UserDetails user = User.builder()
                .username("user")
                .password("$2a$10$1iHtzX.r3uVfjgK.iVkuFee39NtkD//gKL9oYSnC9xZGRA8RGX.Bu")
                .roles("USER")
                .build();
        //System.out.println("# Encrypted Password: " + passwordEncoder().encode("password"));
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}