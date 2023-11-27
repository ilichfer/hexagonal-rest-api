package com.hexagonal.application.useCase;

import com.hexagonal.application.port.out.LoadPersonaPort;
import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.PersonaAdapter;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ContextConfiguration(classes = {PersonaUseCase.class})
@ExtendWith(SpringExtension.class)
class PersonaUseCaseTest {


    @MockBean
    private LoadPersonaPort loadPersonaPort;

    @Mock
    private PersonaAdapter personaPort;

    @Autowired
    private PersonaUseCase personaUseCase;

    List<PersonaBo> listPersona;

    @BeforeEach
    public void setUp() throws Exception {
        listPersona = new ArrayList<>();
        PersonaBo pBo = new PersonaBo();
        pBo.setEdad("33");
        pBo.setEstado(1);
        pBo.setExperiencia(70);
        pBo.setNombre("ilich");
        pBo.setId(new ObjectId());

        listPersona.add(pBo);
        //Mockito.when(personaAdapter.loadAll()).thenReturn(list);
    }

    @Test
    public void testFindById() {

    }

    /**
     * Method under test: {@link PersonaUseCase#findAll()}
     */
    @Test
    void testFindAll() throws Exception {
        when(loadPersonaPort.loadAll()).thenReturn(listPersona);
        List<PersonaBo> actualFindAllResult = personaUseCase.findAll();
        assertEquals(listPersona, actualFindAllResult);
        assertTrue(!actualFindAllResult.isEmpty());
        verify(loadPersonaPort).loadAll();
    }

    /**
     * Method under test: {@link PersonaUseCase#findAll()}
     */
    @Test
    void testFindAll2() throws Exception {
        when(loadPersonaPort.loadAll()).thenThrow(new Exception("foo"));
        assertThrows(Exception.class, () -> personaUseCase.findAll());
        verify(loadPersonaPort).loadAll();
    }

    @Test
    void save() {
    }
}