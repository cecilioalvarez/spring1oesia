package es.oesia.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonaRepository {
	
	@Autowired
	private  JdbcTemplate plantilla;
	
	@Transactional
	public void insertar(Persona persona) {
		
		plantilla.update("insert into Personas (nombre,apellidos) values (?,?)", persona.getNombre(),persona.getApellidos());
	}
	

}
