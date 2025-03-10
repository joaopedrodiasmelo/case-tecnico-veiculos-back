package com.joaopedro.case_veiculos_jr.response;

import com.joaopedro.case_veiculos_jr.domain.FipeIndicadorMock;
import com.joaopedro.case_veiculos_jr.domain.IcarrosIndicadorMock;
import com.joaopedro.case_veiculos_jr.domain.MolicarIndicadorMock;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class VeiculoGetResponse {

    private String codigo;
    private String mensagem;
    private String placa;
    private String chassi;
    private String ufJurisdicao;
    private String nomeMunicipioEmplacamento;
    private int anoFabricacao;
    private int anoModelo;
    private String marca;
    private String modelo;
    private String tipoVeiculo;
    private String tipoCarroceria;
    private String numeroCarroceria;
    private String corPredominante;
    private String combustivel;
    private int potencia;
    private int cilindradas;
    private int capacidadePassageiros;
    private String numeroCaixaCambio;
    private int numeroEixos;
    private String numeroMotor;
    private String dataEmplacamento;
    private int quantidadeAquisicoes;
    private String dataUltimaAquisicao;
    private String ufUltimaAquisicao;
    private String ufAtual;
    private String nomeMunicipioUltimaAquisicao;
    private List<FipeIndicadorMock> indicadoresFipe;
    private List<MolicarIndicadorMock> indicadoresMolicar;
    private List<IcarrosIndicadorMock> indicadoresIcarros;

}