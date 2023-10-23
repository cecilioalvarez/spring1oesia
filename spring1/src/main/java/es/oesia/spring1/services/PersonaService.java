package es.oesia.spring1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.oesia.spring1.dtos.PersonaCategoriaDTO;
import es.oesia.spring1.excepciones.RecursoNotFoundException;
import es.oesia.spring1.models.Categoria;
import es.oesia.spring1.models.Persona;
import es.oesia.spring1.repositorios.CategoriaRepository;
import es.oesia.spring1.repositorios.PersonaRepository;
import es.oesia.spring1.transformers.PersonaCategoriaTransformer;

@Service
public class PersonaService {

	private final PersonaRepository personaRepo;
	private final CategoriaRepository categoriaRepo;
	
	
	public PersonaService(PersonaRepository personaRepo, CategoriaRepository categoriaRepo) {
		super();
		this.personaRepo = personaRepo;
		this.categoriaRepo = categoriaRepo;
	}
	public List<Persona> buscarTodosConCategorias() {
		
		return personaRepo.findAllWithCategories();
	}
	public List<PersonaCategoriaDTO> buscarTodosConCategoriasdDTO() {
		return personaRepo.findAllWithCategoriesDTO();
	}
	@Transactional
	public PersonaCategoriaDTO insertar(PersonaCategoriaDTO personaDTO) {
		// nosotros tenemos personas que no tienen id por que
		//es autonumerico
		// es probable que la categoria la recibamos con id
		
		Persona p= new Persona();
		BeanUtils.copyProperties(personaDTO, p);
		Optional<Categoria> categoria=categoriaRepo.findById(personaDTO.getCategoriaId());
		if (categoria.isPresent()) {
			
			p.setCategoria(categoria.get());
		}
		return PersonaCategoriaTransformer.toDto(personaRepo.save(p));
		
	}
	@Transactional
	public void borrar(Persona persona) {
		personaRepo.delete(persona);
	}
	@Transactional
	public PersonaCategoriaDTO update(int id,PersonaCategoriaDTO personaDTO) {
		//hemos hecho dos operativas una buscar
		//abriendo la transcion y otra salver
		Optional<Persona> oPersona= buscarUno(id);
		if (oPersona.isPresent()) {
			
			// esta son los datos de la persona managed
			Persona personaActualizar=oPersona.get();
			
			BeanUtils.copyProperties(personaDTO, personaActualizar);
			
			
			Optional<Categoria> oCategoria= categoriaRepo.findById(personaDTO.getCategoriaId());
			if (oCategoria.isPresent()) {
				
				personaActualizar.setCategoria(oCategoria.get());
				
				
			}
			Persona personaSalvada=personaRepo.save(personaActualizar);
			
			return  PersonaCategoriaTransformer.toDto(personaSalvada);
			
		}else {
			
		 throw new RecursoNotFoundException("no existe la persona");
		}
		
	}
	public Iterable<Persona> buscarTodos() {
		return personaRepo.findAll();
	}
	public Optional<Persona> buscarUno(int id) {
		return personaRepo.findById(id);
	}
	public List<Persona> buscarPorEjemplo( Persona persona) {
		
	
		ExampleMatcher macherBasico=
				ExampleMatcher
				.matching()
				.withIgnorePaths("id");
		if (persona.getEdad()==0) {
			macherBasico=macherBasico.withIgnorePaths("edad");
		}
		Example<Persona> pEjemplo=Example.of(persona,macherBasico);
		return personaRepo.findAll(pEjemplo);
		
	}
	
}
