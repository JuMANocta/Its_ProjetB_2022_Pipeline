package com.compagny.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecuController {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((autorize)->autorize
                // .requestMatchers("/").permitAll()
                // .requestMatchers("/api").permitAll()
                // .requestMatchers("/api/**").hasRole("ADMIN")
                // .requestMatchers("/api/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll())
            .formLogin((formLogin)->formLogin
                //.loginPage("/login")
                .permitAll())
            .logout((logout)->logout
                //.logoutUrl("/logout")
                .permitAll());

        return http.build();
    }
}
