package es.oesia.spring1.repositorios;

import org.springframework.data.repository.CrudRepository;

import es.oesia.spring1.models.Persona;

public interface PersonaRepository  extends CrudRepository<Persona, Integer>{
}