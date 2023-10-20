package es.oesia.spring1.repositorios;

import org.springframework.data.repository.CrudRepository;

import es.oesia.spring1.models.Categoria;

public interface CategoriaRepository  extends CrudRepository<Categoria, Integer> {

}
