package es.oesia.spring1.repositorios.jdbc;

import java.util.List;

import es.oesia.spring1.Persona;

public interface PersonaRepository {

	void insertar(Persona persona);
	void borrar(Persona persona);
	void update(Persona persona);
	List<Persona> buscarTodos();
	Persona buscarUno(int id);

}