package es.oesia.spring1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.oesia.spring1.dtos.PersonaCategoriaDTO;
import es.oesia.spring1.excepciones.RecursoNotFoundException;
import es.oesia.spring1.models.Persona;
import es.oesia.spring1.services.PersonaService;
import es.oesia.spring1.transformers.PersonaCategoriaTransformer;

@RestController
@RequestMapping("webapi/personas")
public class PersonaRestController {

	private PersonaService servicioPersona;

	public PersonaRestController(PersonaService servicioPersona) {
		super();
		this.servicioPersona = servicioPersona;
	}
	@GetMapping
	public Iterable<PersonaCategoriaDTO> buscarTodos() {
	
		return 
				servicioPersona
				.buscarTodosConCategorias()
				.stream()
				.map(PersonaCategoriaTransformer::toDto)
				.toList();
		
	}
	
	
	@GetMapping("/{id}")
	public PersonaCategoriaDTO buscarUno(@PathVariable int id) {
		
		//return  servicioPersona.buscarUno(id).map(o->o).orElseThrow(()-> new RecursoNotFoundException("no existe la persona"));
		return  servicioPersona.buscarUno(id).map(PersonaCategoriaTransformer::toDto).orElseThrow(RecursoNotFoundException::new);
				
	}
	@PostMapping
	@ResponseStatus(value=HttpStatus.CREATED)
	public PersonaCategoriaDTO insertar(@RequestBody PersonaCategoriaDTO persona) {
		
		return servicioPersona.insertar(persona);
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable int id) {
		servicioPersona.borrar(new Persona (id));
	}
	@PutMapping("/{id}")
	public PersonaCategoriaDTO actualizar(@PathVariable int id,@RequestBody PersonaCategoriaDTO persona) {
	
		return servicioPersona.update(id,persona);
	}
	
	@GetMapping("/queries")
	public List<Persona> buscarPorEjemplo(Persona persona ,@RequestParam (defaultValue="0") int pagina, @RequestParam (defaultValue="0") int items) {
		System.out.println(pagina);
		System.out.println(items);
		return servicioPersona.buscarPorEjemplo(persona,pagina,items);
	}
	
	@GetMapping("/mayoredad")
	public List<Persona> buscarMayorEdad() {
	
		return servicioPersona.buscarMayorEdad();
	}
	
	
}
