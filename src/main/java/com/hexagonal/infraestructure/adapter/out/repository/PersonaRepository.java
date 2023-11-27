package com.hexagonal.infraestructure.adapter.out.repository;


import com.hexagonal.infraestructure.adapter.out.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {

}
