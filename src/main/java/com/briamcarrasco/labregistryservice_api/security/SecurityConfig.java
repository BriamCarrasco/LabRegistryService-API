package com.briamcarrasco.labregistryservice_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad para la aplicación.
 * y la cadena de filtros de seguridad.
 */
@Configuration
public class SecurityConfig {


    /**
     * Configura la cadena de filtros de seguridad de Spring Security.
     * En este caso, deshabilita CSRF y permite todas las solicitudes sin autenticación.
     *
     * @param http Objeto HttpSecurity para configurar la seguridad HTTP.
     * @return SecurityFilterChain configurada.
     * @throws Exception Si ocurre un error en la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .anyRequest().permitAll()
            );
        return http.build();
    }

}