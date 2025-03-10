package com.joaopedro.case_veiculos_jr.service;

import com.joaopedro.case_veiculos_jr.client.VeiculoClient;
import com.joaopedro.case_veiculos_jr.domain.VeiculoMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private static final Logger logger = LoggerFactory.getLogger(VeiculoService.class);
    private final VeiculoClient apiVeiculosClient;
    private final String chaveApi;


    public VeiculoService(VeiculoClient apiVeiculosClient, @Value("${api.veiculos.key}") String apiKey) {
        this.apiVeiculosClient = apiVeiculosClient;
        this.chaveApi = apiKey;
    }

    public String checkApi() {
        String healthStatus = apiVeiculosClient.checkHealth();
        logger.info("Health status: {}", healthStatus);
        return healthStatus;
    }

    public List<VeiculoMock> buscarPlacas() {
        try {
            List<VeiculoMock> veiculos = apiVeiculosClient.findAll(chaveApi);
            logger.info("Received {} vehicles", veiculos.size());
            System.out.println(veiculos); // Log para verificar a quantidade de veículos recebidos
            return veiculos;
        } catch (Exception e) {
            logger.error("Error while fetching vehicle data", e);  // Log para erros na chamada
            throw e;
        }
    }


    public VeiculoMock buscarVeiculoPorPlaca(String placa) {
        try {
            VeiculoMock response = apiVeiculosClient.findByPlaca(placa, chaveApi);
            return response;
        } catch (Exception e) {
            logger.error("Error while fetching vehicle by placa", e);
            throw e;
        }
    }

    public VeiculoMock buscarVeiculoPorPlacaEMes(String placa, int mes) {
        try {
            VeiculoMock response = apiVeiculosClient.findByPlacaAndMes(placa, mes, chaveApi);
            return response;
        } catch (Exception e) {
            logger.error("Error while fetching vehicle by placa and mes", e);
            throw e;
        }
    }
}