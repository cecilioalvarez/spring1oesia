package es.oesia.spring1.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.oesia.spring1.models.Persona;

public interface PersonaRepository  extends CrudRepository<Persona, Integer>{

	@Query ("select distinct (p) from Persona p join fetch p.categoria")
	public List<Persona> findAllWithCategories();

}