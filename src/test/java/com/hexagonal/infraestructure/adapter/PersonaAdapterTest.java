package com.hexagonal.infraestructure.adapter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.out.mapper.PersonaEntityMapper;
import com.hexagonal.infraestructure.adapter.out.model.Identidad;
import com.hexagonal.infraestructure.adapter.out.model.Persona;
import com.hexagonal.infraestructure.adapter.out.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonaAdapter.class})
@ExtendWith(SpringExtension.class)
class PersonaAdapterTest {
    @Autowired
    private PersonaAdapter personaAdapter;

    @MockBean
    private PersonaRepository personaRepository;

    @MockBean
    private PersonaEntityMapper personaEntityMapper;

    List<Persona> listPersonaEntity;
    List<PersonaBo> listPersona;

    Persona personaEntity;
    PersonaBo personaBo;

    @BeforeEach
    public void setUp() throws Exception {
        listPersonaEntity = new ArrayList<>();
        personaEntity = new Persona();
        personaEntity.setEdad("33");
        personaEntity.setEstado(1);
        personaEntity.setExperiencia(70);
        personaEntity.setNombre("ilich");
        personaEntity.setId(new ObjectId());

        listPersonaEntity.add(personaEntity);

        listPersona = new ArrayList<>();
        personaBo = new PersonaBo();
        personaBo.setEdad("33");
        personaBo.setEstado(1);
        personaBo.setExperiencia(70);
        personaBo.setNombre("ilich");
        personaBo.setId(new ObjectId());

        listPersona.add(personaBo);
        //Mockito.when(personaAdapter.loadAll()).thenReturn(list);
    }

    /**
     * Method under test: {@link PersonaAdapter#loadAll()}
     */
    @Test
    void testLoadAll() throws Exception {
        when(personaRepository.findAll()).thenReturn(listPersonaEntity);
        when(personaEntityMapper.listEntityToUserBo( listPersonaEntity )).thenReturn(listPersona);
        List<PersonaBo> listBo = personaEntityMapper.INSTANCE.listEntityToUserBo( listPersonaEntity );

        List<PersonaBo> actualFindAllResult = personaAdapter.loadAll();
        assertEquals(1, listBo.size());
        Assertions.assertNotNull( listBo.get(0) );
    }

    /**
     * Method under test: {@link PersonaAdapter#loadAll()}
     */
    @Test
    void testLoadAll2() throws Exception {
        when(personaRepository.findAll()).thenReturn(new ArrayList<>());
        personaAdapter.loadAll();
    }

    /**
     * Method under test: {@link PersonaAdapter#save(PersonaBo)}
     */
    @Test
    void testSave() {

        Identidad identidad = new Identidad();
        identidad.setCedula("0123456789ABCDEF");
        identidad.setEstadoCivil("0123456789ABCDEF");
        identidad.setPais("0123456789ABCDEF");
        identidad.setSexo("0123456789ABCDEF");

        personaEntity.setIdentidad(identidad);
        personaEntity.setTelefonos(new ArrayList<>());
        when(personaRepository.insert(Mockito.<Persona>any())).thenReturn(personaEntity);
        when(personaEntityMapper.boToUserEntity(personaBo)).thenReturn(personaEntity);
        when(personaEntityMapper.entityToUserBo(personaEntity)).thenReturn(personaBo);

        PersonaBo pBo = personaEntityMapper.INSTANCE.entityToUserBo(personaEntity);
        Persona pEntity= personaEntityMapper.INSTANCE.boToUserEntity(personaBo);
        PersonaBo p  =  personaAdapter.save(personaBo);

        assertEquals(personaBo, p);
        Assertions.assertNotNull( p.getNombre() );
    }
}

