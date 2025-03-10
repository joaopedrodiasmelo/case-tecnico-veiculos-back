package com.joaopedro.case_veiculos_jr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MolicarIndicadorMock {
    private String codigo;
    private String descricao;
}