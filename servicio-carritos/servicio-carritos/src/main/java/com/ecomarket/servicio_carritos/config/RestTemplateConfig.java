package com.ecomarket.servicio_carritos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean // Sirve para inyectar RestTemplate en otros componentes
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}