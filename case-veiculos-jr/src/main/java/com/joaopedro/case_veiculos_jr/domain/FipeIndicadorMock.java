package com.joaopedro.case_veiculos_jr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class FipeIndicadorMock {
    private String codigoFIPE;
    private List<FipeValueMock> valores;
}