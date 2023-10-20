package es.oesia.spring1.dtos;

import java.io.Serializable;

public class PersonaCategoriaDTO implements Serializable {

	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	
	private int categoriaId;
	private String nombreCategoria;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public PersonaCategoriaDTO(int id, String nombre, String apellidos, int edad, int categoriaId,
			String nombreCategoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.categoriaId = categoriaId;
		this.nombreCategoria = nombreCategoria;
	}
	public PersonaCategoriaDTO() {
		super();
	}
	
	
	
}
