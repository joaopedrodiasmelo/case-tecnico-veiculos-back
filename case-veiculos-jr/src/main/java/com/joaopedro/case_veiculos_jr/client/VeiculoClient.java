package com.joaopedro.case_veiculos_jr.client;

import com.joaopedro.case_veiculos_jr.domain.VeiculoMock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "veiculos-api", url = "#{@secretService.getApiUrl()}")
public interface VeiculoClient {

    @GetMapping("/health")
    String checkHealth();

    @GetMapping("")
    List<VeiculoMock> findAll(@RequestHeader("api-veiculo-mock") String apiKey);

    @GetMapping("{placa}/")
    VeiculoMock findByPlaca(
            @PathVariable("placa") String placa,
            @RequestHeader("api-veiculo-mock") String apiKey);

    @GetMapping("{placa}")
    VeiculoMock findByPlacaAndMes(
            @PathVariable("placa") String placa,
            @RequestParam("mes") int mes,
            @RequestHeader("api-veiculo-mock") String apiKey);
}