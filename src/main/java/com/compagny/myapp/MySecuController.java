package com.compagny.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecuController {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((autorize)->autorize
                // .requestMatchers("/").permitAll()
                //.requestMatchers("/api").permitAll()
                // .requestMatchers("/api/**").hasRole("ADMIN")
                //.requestMatchers("/api/personnes").permitAll()
                //.anyRequest().authenticated())
                .anyRequest().permitAll())
            .formLogin((formLogin)->formLogin
                //.loginPage("/login")
                .permitAll())
            .logout((logout)->logout
                //.logoutUrl("/logout")
                .permitAll())
            .csrf().disable() //pour utiliser l'API sans token
            .headers().frameOptions().sameOrigin();//pour utiliser la console H2
        return http.build();
    }

}
