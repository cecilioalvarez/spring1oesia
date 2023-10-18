package es.oesia.spring1;

import es.oesia.spring1.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="personas")
public class Persona extends BaseEntity {

	private String nombre;
	private String apellidos;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Persona(String nombre, String apellidos) {
		super();
		
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	
	public Persona(int id, String nombre, String apellidos) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Persona() {
		super();
	}
	public Persona(int id) {
		super();
	
	}
	@Override
	public String toString() {
		return "Persona [id=" + getId() + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
}
