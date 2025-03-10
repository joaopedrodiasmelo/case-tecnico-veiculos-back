package com.joaopedro.case_veiculos_jr.controller;

import com.joaopedro.case_veiculos_jr.domain.VeiculoMock;
import com.joaopedro.case_veiculos_jr.mapper.VeiculoMapper;
import com.joaopedro.case_veiculos_jr.response.VeiculoGetResponse;
import com.joaopedro.case_veiculos_jr.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);
    private final VeiculoService veiculosService;
    private final VeiculoMapper mapper;



    @GetMapping("/health")
    public ResponseEntity<String> checkApiHealth() {
        logger.info("Checking API health...");
        return ResponseEntity.ok("Aplicação está OK");
    }


    @Cacheable(value = "veiculos", key = "'todas-placas'")
    @GetMapping("/placas")
    public ResponseEntity<List<VeiculoGetResponse>> buscarPlacas() {
        logger.info("Procurando veiculos.");
        List<VeiculoMock> veiculos = veiculosService.buscarPlacas();
        List<VeiculoGetResponse> veiculoGetResponse =mapper.toVeiculoGetResponseList(veiculos);
        return ResponseEntity.ok(veiculoGetResponse);
    }


    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoGetResponse> buscarVeiculoPorPlaca(@PathVariable String placa) {
        logger.info("Procurando veiculos pela placa: {}", placa);
        VeiculoMock veiculo = veiculosService.buscarVeiculoPorPlaca(placa);
        VeiculoGetResponse veiculoGetResponse = mapper.toVeiculoGetResponse(veiculo);
        return ResponseEntity.ok(veiculoGetResponse);
    }


    @GetMapping("/{placa}/mes")
    public ResponseEntity<VeiculoGetResponse> buscarVeiculoPorPlacaEMes(
            @PathVariable String placa,
            @RequestParam int mes) {
        logger.info("Procurando veiculo pela placa e mes: {}, {}", placa, mes);
        VeiculoMock veiculo = veiculosService.buscarVeiculoPorPlacaEMes(placa, mes);
        VeiculoGetResponse veiculoGetResponse = mapper.toVeiculoGetResponse(veiculo);
        return ResponseEntity.ok(veiculoGetResponse);
    }
}

