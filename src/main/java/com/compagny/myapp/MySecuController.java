package com.compagny.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecuController {
    @Autowired
    private UserRepository userRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((autorize) -> autorize
                        // .requestMatchers("/").permitAll()
                        .requestMatchers("/api").permitAll()
                        // .requestMatchers("/api/**").hasRole("ADMIN")
                        // .requestMatchers("/api/personnes").permitAll()
                        .anyRequest().authenticated())
                        //.anyRequest().permitAll())
                .formLogin((formLogin) -> formLogin
                        // .loginPage("/login")
                        .permitAll())
                .logout((logout) -> logout
                        // .logoutUrl("/logout")
                        .permitAll())
                .csrf().disable() // pour utiliser l'API sans token CSRF
                .headers().frameOptions().sameOrigin();// pour utiliser la console H2
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // cette méthode viens ajouter un utilisateur admin dans la base de données et test 
    public void injectBdd(){
        System.out.println("Injecting Admin in BDD");
        userRepository.save(new Users(null, "admin", passwordEncoder().encode("admin"), "ROLE_ADMIN"));
        userRepository.save(new Users(null, "test", passwordEncoder().encode("test"), "ROLE_USER"));
    }
}
