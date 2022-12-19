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
        // utilisation de bcrypt pour le cryptage des mots de passe
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("Mot de passe crypté: " + bCryptPasswordEncoder.encode("test"));
        System.out.println(bCryptPasswordEncoder.matches("admin", "$2a$10$s8a9Fh/guwH19CR5zCEk2u9Idn82IISRVVhGoI4xjgfx.tqpgqAlC"));
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
