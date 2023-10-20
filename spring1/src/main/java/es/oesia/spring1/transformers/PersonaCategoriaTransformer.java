package es.oesia.spring1.transformers;

import es.oesia.spring1.dtos.PersonaCategoriaDTO;
import es.oesia.spring1.models.Persona;

public class PersonaCategoriaTransformer {

	public static PersonaCategoriaDTO transformar(Persona persona) {
		
		
		PersonaCategoriaDTO dto= new PersonaCategoriaDTO();
		dto.setId(persona.getId());
		dto.setApellidos(persona.getApellidos());
		dto.setNombre(persona.getNombre());
		dto.setNombreCategoria(persona.getCategoria().getNombre());
		dto.setCategoriaId(persona.getCategoria().getId());
		return dto;
	}
	
}
