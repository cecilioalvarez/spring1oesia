package es.oesia.spring1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.oesia.spring1.models.Persona;
import es.oesia.spring1.repositorios.PersonaRepository;

@Service
public class PersonaService {

	private final PersonaRepository personaRepo;
	
	public PersonaService( PersonaRepository personaRepo) {
		super();
		this.personaRepo = personaRepo;
	}
	public List<Persona> buscarTodosConCategorias() {
		return personaRepo.findAllWithCategories();
	}
	@Transactional
	public Persona insertar(Persona persona) {
		return personaRepo.save(persona);
		
	}
	@Transactional
	public void borrar(Persona persona) {
		personaRepo.delete(persona);
	}
	@Transactional
	public Persona update(int id,Persona persona) {
		//hemos hecho dos operativas una buscar
		//abriendo la transcion y otra salver
		Optional<Persona> oPersona= buscarUno(id);
		if (oPersona.isPresent()) {
			Persona personaActualizar=oPersona.get();
			personaActualizar.setNombre(persona.getNombre());
			personaActualizar.setApellidos(persona.getApellidos());
			return personaRepo.save(persona);
		}else {
			return null;
		}
	}
	public Iterable<Persona> buscarTodos() {
		return personaRepo.findAll();
	}
	public Optional<Persona> buscarUno(int id) {
		return personaRepo.findById(id);
	}
	
}
