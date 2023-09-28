package api.littlesekii.crudier.resources.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.littlesekii.crudier.resources.person.model.Person;
import api.littlesekii.crudier.resources.person.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll() {
		List<Person> data = repository.findAll();
		return data;
	}
	
	public Person findById(Long id) {
		Person data = repository.findById(id).orElseThrow(
			() -> new EntityNotFoundException(String.format("Could not fetch any data by id %d", id))
		);
		return data;
	}
	
}
