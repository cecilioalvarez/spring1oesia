package es.oesia.spring1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.oesia.spring1.Persona;
import es.oesia.spring1.repositorios.jdbc.PersonaRepository;

@Service
public class PersonaService {

	private final PersonaRepository personaRepo;

	public PersonaService(PersonaRepository personaRepo) {
		super();
		this.personaRepo = personaRepo;
	}

	public void insertar(Persona persona) {
		personaRepo.insertar(persona);
	}

	public void borrar(Persona persona) {
		personaRepo.borrar(persona);
	}

	public void update(Persona persona) {
		personaRepo.update(persona);
	}

	public List<Persona> buscarTodos() {
		return personaRepo.buscarTodos();
	}

	public Persona buscarUno(int id) {
		return personaRepo.buscarUno(id);
	}
	
}
