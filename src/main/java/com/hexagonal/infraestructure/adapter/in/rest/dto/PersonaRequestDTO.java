package com.hexagonal.infraestructure.adapter.in.rest.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class PersonaRequestDTO {

    private ObjectId id;
    private String nombre;
    private String edad;
    private Integer experiencia;
    private Integer estado;
    private List<String> telefonos;
    private IdentidadDTO identidad;
}
