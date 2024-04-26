package com.senai.imobiliariaapi.mapper;

import org.mapstruct.Mapper;

import com.senai.imobiliariaapi.dto.ImovelRequest;
import com.senai.imobiliariaapi.dto.ImovelResponse;
import com.senai.imobiliariaapi.model.Imovel;

@Mapper(componentModel = "spring")
public interface ImovelMapper {
  
  ImovelResponse toResponse(Imovel entity);

  Imovel toEntity(ImovelRequest request);
}
