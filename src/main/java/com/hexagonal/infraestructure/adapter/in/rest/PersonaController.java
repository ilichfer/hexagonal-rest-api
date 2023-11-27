package com.hexagonal.infraestructure.adapter.in.rest;

import com.hexagonal.application.port.in.PersonaPort;
import com.hexagonal.infraestructure.adapter.in.mapper.PersonaMapper;
import com.hexagonal.infraestructure.adapter.out.dto.PersonaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private final PersonaMapper personaMapper;
    @Autowired
    private final PersonaPort personaPort;

    public PersonaController(PersonaMapper personaMapper, PersonaPort personaPort) {
        this.personaMapper = personaMapper;
        this.personaPort = personaPort;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PersonaResponseDTO>> findAllDto() throws Exception {
        List<PersonaResponseDTO> list = personaMapper.ListBotoPersonaDto(personaPort.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
