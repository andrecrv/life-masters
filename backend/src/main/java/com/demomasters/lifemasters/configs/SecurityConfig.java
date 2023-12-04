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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Give access permissions to webapp
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authCustomizer -> authCustomizer
                        //USERS
                        .requestMatchers(HttpMethod.POST, "/api/create-user").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/*/delete-user").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/*/update-user").permitAll()
                        .requestMatchers("/api/username/**").permitAll()
                        .requestMatchers("/api/users", "/api/user/**").permitAll()
                        //TASKS
                        .requestMatchers(HttpMethod.POST, "/api/tasks/*/create-task").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/tasks/delete-task/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/tasks/update-task/**").permitAll()
                        .requestMatchers("/api/task/**", "/api/tasks/*/list", "/api/tasks/*/status/**","/api/tasks/*/priority/**", "/api/tasks/*/type/**").permitAll()
                        .requestMatchers("/api/tasks").permitAll()
                        //GOALS
                        .requestMatchers(HttpMethod.POST, "/api/goals/*/create-goal").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/goals/delete-goal/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/goals/update-goal/**").permitAll()
                        .requestMatchers("/api/goal/**", "/api/goals/*/list", "/api/goals/*/status/**","/api/goals/*/difficulty/**", "/api/goals/*/type/**").permitAll()
                        .requestMatchers("/api/goals").permitAll()
                        .requestMatchers("/api/**").authenticated()
                )
                .build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
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