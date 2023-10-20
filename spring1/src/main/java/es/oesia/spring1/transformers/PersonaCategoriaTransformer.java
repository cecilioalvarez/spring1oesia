package es.oesia.spring1.transformers;

import es.oesia.spring1.dtos.PersonaCategoriaDTO;
import es.oesia.spring1.models.Categoria;
import es.oesia.spring1.models.Persona;

public class PersonaCategoriaTransformer {

	public static PersonaCategoriaDTO transformarToDTO(Persona persona) {
		
		PersonaCategoriaDTO dto= new PersonaCategoriaDTO();
		dto.setId(persona.getId());
		dto.setApellidos(persona.getApellidos());
		dto.setNombre(persona.getNombre());
		dto.setEdad(persona.getEdad());
		dto.setNombreCategoria(persona.getCategoria().getNombre());
		dto.setCategoriaId(persona.getCategoria().getId());
		return dto;
	}
	
public static Persona transformarToEntity(PersonaCategoriaDTO personaDTO) {
		
		
		Persona p= new Persona(personaDTO.getNombre(),personaDTO.getApellidos(),personaDTO.getEdad());
		Categoria c= new Categoria();
		c.setId(personaDTO.getCategoriaId());
		c.setNombre(personaDTO.getNombreCategoria());
		
		return p;
	}
	
	
	
}
