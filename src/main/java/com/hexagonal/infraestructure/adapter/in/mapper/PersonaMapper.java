package com.hexagonal.infraestructure.adapter.in.mapper;

import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.out.dto.PersonaResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);


    @Mapping( target = "nombre", source = "nombre" )
    @Mapping( target = "edad", source = "edad" )
    PersonaResponseDTO BotoPersonaDto(PersonaBo bo);
    List<PersonaResponseDTO> ListBotoPersonaDto(List<PersonaBo> personasList);
}
