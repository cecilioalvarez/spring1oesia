package es.oesia.spring1.repositorios.specifications;

import org.springframework.data.jpa.domain.Specification;

import es.oesia.spring1.models.Persona;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PersonaMayorEdadSpecification  implements Specification<Persona>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MAYOR_EDAD=18;
	@Override
	public Predicate toPredicate(Root<Persona> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		
		Predicate p1= criteriaBuilder.greaterThan(root.get("edad"), MAYOR_EDAD);
		
		return p1;
	}

}
