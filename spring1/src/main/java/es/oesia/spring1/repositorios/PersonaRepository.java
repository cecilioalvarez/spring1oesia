package es.oesia.spring1.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.oesia.spring1.dtos.PersonaCategoriaDTO;
import es.oesia.spring1.models.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Integer>{

	@Query ("select distinct (p) from Persona p join fetch p.categoria")
	public List<Persona> findAllWithCategories();
	
	
	@Query ("select new es.oesia.spring1.dtos.PersonaCategoriaDTO(p.id,p.nombre,p.apellidos,c.id,c.nombre) from Persona p join  p.categoria c")
	public List<PersonaCategoriaDTO> findAllWithCategoriesDTO();
	
	
}