package es.oesia.spring1.repositorios.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.oesia.spring1.Persona;
import es.oesia.spring1.repositorios.PersonaRepository;
import jakarta.persistence.EntityManager;
@Repository
@Qualifier("jpa")
public class PersonaRepositoryJPA implements PersonaRepository {

	
	private final EntityManager em;
	
	public PersonaRepositoryJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Transactional
	public void insertar(Persona persona) {
		em.persist(persona);

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
		return em.createQuery("select p from Persona p",Persona.class).getResultList();
	}

	@Override
	public Persona buscarUno(int id) {
		// TODO Auto-generated method stub
		return em.find(Persona.class, id);
	}

}
