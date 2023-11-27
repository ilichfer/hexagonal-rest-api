package com.hexagonal.application.port.out;


import com.hexagonal.domain.PersonaBo;

import java.util.List;

public interface LoadPersonaPort {
    List<PersonaBo> loadAll() throws Exception;

    public PersonaBo save(PersonaBo persona);
}
