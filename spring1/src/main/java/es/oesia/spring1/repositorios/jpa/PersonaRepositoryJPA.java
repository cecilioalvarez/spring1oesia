package es.oesia.spring1.repositorios.jpa;

import java.util.List;

import es.oesia.spring1.Persona;
import es.oesia.spring1.repositorios.PersonaRepository;
import jakarta.persistence.EntityManager;

public class PersonaRepositoryJPA implements PersonaRepository {

	
	private final EntityManager em;
	
	public PersonaRepositoryJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona buscarUno(int id) {
		// TODO Auto-generated method stub
		return em.find(Persona.class, id);
	}

}
