//package es.oesia.spring1.repositorios.jpa;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import es.oesia.spring1.Persona;
//import es.oesia.spring1.repositorios.PersonaRepository;
//import jakarta.persistence.EntityManager;
//@Repository
//@Qualifier("jpa")
//public class PersonaRepositoryJPA implements PersonaRepository {
//
//	
//	private final EntityManager em;
//	
//	public PersonaRepositoryJPA(EntityManager em) {
//		super();
//		this.em = em;
//	}
//
//	@Transactional
//	public Persona insertar(Persona persona) {
//		em.persist(persona);
//		return persona;
//
//	}
//
//	@Transactional
//	public void borrar(Persona persona) {
//		em.remove(em.merge(persona));
//
//	}
//
//	@Override
//	@Transactional
//	public Persona update(Persona persona) {
//		
//		em.merge(persona);
//		return persona;
//
//	}
//
//	@Transactional(readOnly = true)
//	public List<Persona> buscarTodos() {
//		// TODO Auto-generated method stub
//		return em.createQuery("select p from Persona p",Persona.class).getResultList();
//	}
//
//	@Transactional(readOnly = true)
//	public Persona buscarUno(int id) {
//		// TODO Auto-generated method stub
//		return em.find(Persona.class, id);
//	}
//
//}
