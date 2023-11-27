package com.hexagonal.domain;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class PersonaBo {
    private ObjectId id;
    private String nombre;
    private String edad;
    private Integer experiencia;
    private Integer estado;
    private List<String> telefonos;
    private IdentidadBo identidad;

    public PersonaBo() {

    }

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

    public IdentidadBo getIdentidad() {
        return identidad;
    }

    public void setIdentidad(IdentidadBo identidad) {
        this.identidad = identidad;
    }

    public PersonaBo(ObjectId id, String nombre, String edad, Integer experiencia, Integer estado, List<String> telefonos, IdentidadBo identidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
        this.estado = estado;
        this.telefonos = telefonos;
        this.identidad = identidad;
    }
}
