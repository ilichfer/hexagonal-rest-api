package com.hexagonal.application.useCase;


import com.hexagonal.application.port.in.PersonaPort;
import com.hexagonal.application.port.out.LoadPersonaPort;
import com.hexagonal.domain.PersonaBo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaUseCase implements PersonaPort {

    private final LoadPersonaPort personaPort;

    public PersonaUseCase(LoadPersonaPort personaPort) {
        this.personaPort = personaPort;
    }

    @Override
    public List<PersonaBo> findAll() throws Exception {
        return personaPort.loadAll();
    }

    @Override
    public PersonaBo save(PersonaBo persona) throws Exception {
        return null;
    }
}
