package es.oesia.spring1;

public class Persona {

	private int id;
	private String nombre;
	private String apellidos;
	
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
	public Persona(String nombre, String apellidos) {
		super();
		
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Persona() {
		super();
	}
	
	
}
