package es.oesia.spring1.repositorios.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.oesia.spring1.Persona;
import es.oesia.spring1.repositorios.jdbc.mappers.PersonaMapper;

@Repository
public class PersonaRepositoryJDBC implements PersonaRepository {
	
	//inyeccion de dependencia basada en el constructor
	
	private final JdbcTemplate plantilla;
	
	public PersonaRepositoryJDBC(JdbcTemplate plantilla) {
	
		this.plantilla = plantilla;
	}

	@Override
	@Transactional
	public void insertar(Persona persona) {
		
		plantilla.update("insert into Personas (nombre,apellidos) values (?,?)", persona.getNombre(),persona.getApellidos());
	}
	
	
	@Override
	@Transactional
	public void update(Persona persona) {
		
		plantilla.update("update Personas set nombre=?,apellidos=? where id=?", persona.getNombre(),persona.getApellidos(),persona.getId());
	}
	
	@Override
	@Transactional
	public void borrar(Persona persona) {
		
		plantilla.update("delete from Personas where id =?", persona.getId());
	}
	
	public List<Persona> buscarTodos() {
		
		return plantilla.query("select * from Personas", new PersonaMapper());
	}

	@Override
	public Persona buscarUno(int id) {
		
		//return plantilla.query("select * from Personas where id=?",new Object[] {id}, new PersonaMapper()).get(0);

		
		return plantilla.queryForObject("select * from Personas where id=?", new PersonaMapper(),id);
	}

}
