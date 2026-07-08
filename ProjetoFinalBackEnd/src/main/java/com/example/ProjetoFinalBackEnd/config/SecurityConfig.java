package com.example.ProjetoFinalBackEnd.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF para testes com API REST
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

    return http.build();
    }
    //Inserindo o CORS ao BackEnd para receber Requisições do FrontEnd

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();

        //Liberando as portas padrão do React (porta:3000) e Vite (porta:5173)

        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:5173"));

        //Liberando os acessos aos métodos HTTP

        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));

        //Liberando acesso geral aos Headers do sistema

        configuration.setAllowedHeaders(List.of("*"));

        //Liberando acesso as credenciais

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    
}
