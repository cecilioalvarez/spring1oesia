package es.oesia.spring1.repositorios.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.oesia.spring1.models.Persona;

public class PersonaMapper implements RowMapper<Persona>{
	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null ;// new Persona(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellidos"));
	}
}
