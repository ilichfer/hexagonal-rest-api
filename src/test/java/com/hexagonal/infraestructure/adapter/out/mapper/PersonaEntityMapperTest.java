package com.hexagonal.infraestructure.adapter.out.mapper;

import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.out.model.Persona;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaEntityMapperTest {

    @Autowired
    private PersonaEntityMapper personaEntityMapper;

    List<Persona> listPersonaEntity;
    List<PersonaBo> listPersona;

    Persona persona;
    PersonaBo pBo;

    @BeforeEach
    public void setUp() throws Exception {
        listPersonaEntity = new ArrayList<>();
        persona = new Persona();
        persona.setEdad("33");
        persona.setEstado(1);
        persona.setExperiencia(70);
        persona.setNombre("ilich");
        persona.setId(new ObjectId());

        listPersonaEntity.add(persona);

        listPersona = new ArrayList<>();
        pBo = new PersonaBo();
        pBo.setEdad("33");
        pBo.setEstado(1);
        pBo.setExperiencia(70);
        pBo.setNombre("ilich");
        pBo.setId(new ObjectId());

        listPersona.add(pBo);
        //Mockito.when(personaAdapter.loadAll()).thenReturn(list);
    }

    @Test
    void entityToUserBo() {
        PersonaBo targetBo = personaEntityMapper.INSTANCE.entityToUserBo( persona );
        assertNotNull(persona.getNombre());
        assertNotNull(targetBo.getNombre());
        assertEquals(targetBo.getNombre(), persona.getNombre());

    }

    @Test
    void BoToUserEntity() {
        Persona pEntity = personaEntityMapper.INSTANCE.boToUserEntity( pBo );
        assertNotNull(pEntity.getNombre());
        assertNotNull(pBo.getNombre());
        assertEquals(pBo.getNombre(), pEntity.getNombre());

    }

    @Test
    void listEntityToUserBo() {

        List<PersonaBo> target = personaEntityMapper.INSTANCE.listEntityToUserBo( listPersonaEntity );
        assertEquals(1, target.size());
        Assertions.assertNotNull( target.get(0) );
    }
}