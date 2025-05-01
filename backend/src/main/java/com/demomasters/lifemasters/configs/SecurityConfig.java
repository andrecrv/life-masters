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
                        //.requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        //.requestMatchers(HttpMethod.DELETE, "/api/users/*").permitAll()
                        //.requestMatchers(HttpMethod.PUT, "/api/users/*").permitAll()
                        .requestMatchers("/api/users", "/api/users/**").permitAll()
                        //TASKS
                        //.requestMatchers(HttpMethod.POST, "/api/tasks").permitAll()
                        //.requestMatchers(HttpMethod.DELETE, "/api/tasks/*").permitAll()
                        //.requestMatchers(HttpMethod.PUT, "/api/tasks/*").permitAll()
                        .requestMatchers("/api/tasks", "/api/tasks/*").permitAll()
                        //GOALS
                        //.requestMatchers(HttpMethod.POST, "/api/goals").permitAll()
                        //.requestMatchers(HttpMethod.DELETE, "/api/goals/*").permitAll()
                        //.requestMatchers(HttpMethod.PUT, "/api/goals/*").permitAll()
                        .requestMatchers("/api/goals", "/api/goals/*").permitAll()
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
                .username("pguser")
                .password("pgpass")
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