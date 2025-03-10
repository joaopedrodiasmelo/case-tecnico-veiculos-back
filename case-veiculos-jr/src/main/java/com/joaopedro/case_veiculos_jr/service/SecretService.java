package com.joaopedro.case_veiculos_jr.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Service
public class SecretService {

    private final SecretsManagerClient secretsClient;
    private final ObjectMapper objectMapper;

    public SecretService(SecretsManagerClient secretsClient, ObjectMapper objectMapper) {
        this.secretsClient = secretsClient;
        this.objectMapper = objectMapper;
    }

    public String getSecretValue(String secretName) {
        GetSecretValueRequest request = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse response = secretsClient.getSecretValue(request);
        return response.secretString();
    }

    public String getApiUrl() {
        String secretValue = getSecretValue("secrets-case-veiculos3");
        try {
            JsonNode jsonNode = objectMapper.readTree(secretValue);
            return jsonNode.get("private_ip").asText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar o segredo", e);
        }
    }

    public String getApiKey() {
        String secretValue = getSecretValue("secrets-case-veiculos3");
        try {
            JsonNode jsonNode = objectMapper.readTree(secretValue);
            return jsonNode.get("apiKey").asText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar o segredo", e);
        }
    }

    public String getRedisHost() {
        String secretValue = getSecretValue("secrets-case-veiculos3");
        try {
            JsonNode jsonNode = objectMapper.readTree(secretValue);
            return jsonNode.get("redis_endpoint").asText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter Redis Host", e);
        }
    }

    public int getRedisPort() {
        String secretValue = getSecretValue("secrets-case-veiculos3");
        try {
            JsonNode jsonNode = objectMapper.readTree(secretValue);
            return jsonNode.get("redis_port").asInt();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter Redis Port", e);
        }
    }
}