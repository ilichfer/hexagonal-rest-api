package com.hexagonal.infraestructure.adapter.out.mapper;


import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.out.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaEntityMapper {



    PersonaEntityMapper INSTANCE = Mappers.getMapper(PersonaEntityMapper.class);
    PersonaBo entityToUserBo(Persona persona);

    Persona boToUserEntity(PersonaBo personaBo);

    List<PersonaBo> listEntityToUserBo(List<Persona> personasList);
}
