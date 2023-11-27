package com.hexagonal.infraestructure.adapter;


import com.hexagonal.application.port.out.LoadPersonaPort;
import com.hexagonal.domain.PersonaBo;
import com.hexagonal.infraestructure.adapter.out.mapper.PersonaEntityMapper;
import com.hexagonal.infraestructure.adapter.out.model.Persona;
import com.hexagonal.infraestructure.adapter.out.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaAdapter implements LoadPersonaPort {

    private Logger LOGGER = LoggerFactory.getLogger(PersonaAdapter.class);

    @Autowired
    private  PersonaRepository personaRepository;
    @Autowired
    private PersonaEntityMapper personaEntityMapper;


    public PersonaAdapter() {
        this.personaRepository = personaRepository;
        this.personaEntityMapper = personaEntityMapper;
    }


    @Override
    public List<PersonaBo> loadAll() throws Exception {
        List<Persona> l =  personaRepository.findAll();
        return personaEntityMapper.listEntityToUserBo(l);
    }

    public PersonaBo save(PersonaBo persona) {
       return personaEntityMapper.entityToUserBo(personaRepository.insert(personaEntityMapper.boToUserEntity(persona)));
    }

}
