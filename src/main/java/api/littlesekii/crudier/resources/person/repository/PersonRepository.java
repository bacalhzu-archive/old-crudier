package api.littlesekii.crudier.resources.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.littlesekii.crudier.resources.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
