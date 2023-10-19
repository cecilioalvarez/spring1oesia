package es.oesia.spring1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.oesia.spring1.services.PersonaService;

@RestController
@RequestMapping("webapi/personas")
public class PersonaRestController {

	private PersonaService servicioPersona;

	public PersonaRestController(PersonaService servicioPersona) {
		super();
		this.servicioPersona = servicioPersona;
	}
	@GetMapping
	public List<Persona> buscarTodos() {
		
		return servicioPersona.buscarTodos();
	}
	@GetMapping("/{id}")
	public Persona buscarUno(@PathVariable int id) {
		return servicioPersona.buscarUno(id);
	}
	@PostMapping
	public void insertar(@RequestBody Persona persona) {
		servicioPersona.insertar(persona);
	}
	public void borrar(Persona persona) {
		servicioPersona.borrar(persona);
	}
	public void update(Persona persona) {
		servicioPersona.update(persona);
	}
	
	
}
