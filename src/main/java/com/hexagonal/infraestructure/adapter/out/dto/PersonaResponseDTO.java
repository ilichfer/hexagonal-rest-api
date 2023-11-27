package com.hexagonal.infraestructure.adapter.out.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class PersonaResponseDTO {

    private ObjectId id;
    private String nombre;
    private String edad;
    private Integer experiencia;
    private Integer estado;
    private List<String> telefonos;
    private IdentidadDTO identidad;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public IdentidadDTO getIdentidad() {
        return identidad;
    }

    public void setIdentidad(IdentidadDTO identidad) {
        this.identidad = identidad;
    }
}
