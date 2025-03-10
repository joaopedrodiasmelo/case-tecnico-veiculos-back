package com.joaopedro.case_veiculos_jr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class FipeValueMock {
    private double valorFIPE;
    private String dataConsulta;
    private String nomenclaturaFIPE;
    private double indiceComparacao;
    private boolean desvalorizacao;
}