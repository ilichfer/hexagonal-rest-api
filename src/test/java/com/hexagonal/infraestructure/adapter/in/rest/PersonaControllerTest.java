package com.hexagonal.infraestructure.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hexagonal.application.port.in.PersonaPort;
import com.hexagonal.application.useCase.PersonaUseCase;
import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.PersonaAdapter;
import com.hexagonal.infraestructure.adapter.in.mapper.PersonaMapper;
import com.hexagonal.infraestructure.adapter.in.mapper.PersonaMapperImpl;
import com.hexagonal.infraestructure.adapter.out.dto.PersonaResponseDTO;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class PersonaControllerTest {

    @MockBean
    PersonaPort personaPort = mock(PersonaPort.class);
    @Mock
   PersonaMapper personaMapper = mock(PersonaMapper.class);


    List<PersonaBo> listPersona;
    List<PersonaResponseDTO> listPersonaDto;
    PersonaBo personaBo;
    PersonaResponseDTO personaDto;

    @BeforeEach
    public void setUp() throws Exception {
        listPersona = new ArrayList<>();

        personaBo = new PersonaBo();
        personaBo.setEdad("33");
        personaBo.setEstado(1);
        personaBo.setExperiencia(70);
        personaBo.setNombre("ilich");
        personaBo.setId(new ObjectId());

        listPersona.add(personaBo);

        listPersonaDto = new ArrayList<>();

        personaDto = new PersonaResponseDTO();

        listPersonaDto.add(personaDto);
    }

    /**
     * Method under test: {@link PersonaController#findAllDto()}
     */
    @Test
    void testFindAllDto() throws Exception {
       // PersonaMapperImpl personaMapper = new PersonaMapperImpl();
        (new PersonaController(personaMapper, new PersonaUseCase(new PersonaAdapter()))).findAllDto();
    }

    /**
     * Method under test: {@link PersonaController#findAllDto()}
     */
    @Test
    void testFindAllDto2() throws Exception {
        when(personaPort.findAll()).thenReturn(listPersona);
        when(personaMapper.ListBotoPersonaDto(listPersona)).thenReturn(listPersonaDto);
        ResponseEntity<List<PersonaResponseDTO>> actualFindAllDtoResult = (new PersonaController(new PersonaMapperImpl(),
                personaPort)).findAllDto();
    }

    /**
     * Method under test: {@link PersonaController#findAllDto()}
     */
    @Test
    void testFindAllDto3() throws Exception {

        PersonaAdapter personaPort = mock(PersonaAdapter.class);
        ArrayList<PersonaBo> personaBoList = new ArrayList<>();
        when(personaPort.loadAll()).thenReturn(personaBoList);
        PersonaUseCase personaPort2 = new PersonaUseCase(personaPort);
        ResponseEntity<List<PersonaResponseDTO>> actualFindAllDtoResult = (new PersonaController(new PersonaMapperImpl(),
                personaPort2)).findAllDto();
        assertEquals(personaBoList, actualFindAllDtoResult.getBody());
        assertEquals(HttpStatus.OK, actualFindAllDtoResult.getStatusCode());
        assertTrue(actualFindAllDtoResult.getHeaders().isEmpty());
        verify(personaPort).loadAll();
    }

    /**
     * Method under test: {@link PersonaController#findAllDto()}
     */
    @Test
    void testFindAllDto4() throws Exception {
        PersonaAdapter personaPort = mock(PersonaAdapter.class);
        when(personaPort.loadAll()).thenReturn(new ArrayList<>());
        (new PersonaController(null, new PersonaUseCase(personaPort))).findAllDto();
    }

}

