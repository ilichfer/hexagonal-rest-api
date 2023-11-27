package com.hexagonal.application.port.in;


import com.hexagonal.domain.PersonaBo;

import java.util.List;

public interface PersonaPort {

    public List<PersonaBo> findAll() throws Exception;
    public PersonaBo save(PersonaBo persona) throws Exception;

}
