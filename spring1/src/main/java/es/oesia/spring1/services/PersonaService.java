package es.oesia.spring1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.oesia.spring1.Persona;
import es.oesia.spring1.repositorios.PersonaRepository;

@Service
public class PersonaService {

	private final PersonaRepository personaRepo;

	//que esto es una interface y ahora tenemos dos implementaciones
	
	public PersonaService(@Qualifier("jpa") PersonaRepository personaRepo) {
		super();
		this.personaRepo = personaRepo;
	}

	@Transactional
	public Persona insertar(Persona persona) {
		return personaRepo.insertar(persona);
		
	}
	@Transactional
	public void borrar(Persona persona) {
		personaRepo.borrar(persona);
	}
	@Transactional
	public void update(int id,Persona persona) {
		//hemos hecho dos operativas una buscar
		//abriendo la transcion y otra salver
		Persona personaActualizar= buscarUno(id);
		personaActualizar.setNombre(persona.getNombre());
		personaActualizar.setApellidos(persona.getApellidos());
		personaRepo.update(persona);
	}

	public List<Persona> buscarTodos() {
		return personaRepo.buscarTodos();
	}

	public Persona buscarUno(int id) {
		return personaRepo.buscarUno(id);
	}
	
}
