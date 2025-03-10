package com.joaopedro.case_veiculos_jr.config;

import com.joaopedro.case_veiculos_jr.service.SecretService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private SecretService secretService;

    @PostConstruct
    public void init() {
        try {
            // Propriedades da API
            String apiUrl = secretService.getApiUrl();
            String apiKey = secretService.getApiKey();

            System.setProperty("api.veiculos.url", apiUrl);
            System.setProperty("api.veiculos.key", apiKey);


            // Propriedades do Redis
            String redisHost = secretService.getRedisHost();
            int redisPort = secretService.getRedisPort();

            System.setProperty("spring.redis.host", redisHost);
            System.setProperty("spring.redis.port", String.valueOf(redisPort));


        } catch (Exception e) {
            throw new RuntimeException("Erro ao configurar as propriedades da API", e);
        }
    }
}