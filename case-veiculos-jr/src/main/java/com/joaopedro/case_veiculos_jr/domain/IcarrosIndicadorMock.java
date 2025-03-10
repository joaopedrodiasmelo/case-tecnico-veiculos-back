package com.joaopedro.case_veiculos_jr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class IcarrosIndicadorMock {
    private String codigoICARROS;
    private double valorICARROS;
    private String mesConsulta;
    private String nomenclaturaICARROS;
    private double indiceComparacao;
    private boolean desvalorizacao;
}