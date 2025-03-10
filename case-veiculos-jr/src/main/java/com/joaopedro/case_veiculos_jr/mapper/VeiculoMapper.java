package com.joaopedro.case_veiculos_jr.mapper;

import com.joaopedro.case_veiculos_jr.domain.VeiculoMock;
import com.joaopedro.case_veiculos_jr.response.VeiculoGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VeiculoMapper {

    VeiculoGetResponse toVeiculoGetResponse(VeiculoMock veiculoMock);

    List<VeiculoGetResponse> toVeiculoGetResponseList(List<VeiculoMock> veiculoMocks);
}