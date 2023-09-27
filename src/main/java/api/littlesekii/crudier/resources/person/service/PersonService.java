package api.littlesekii.crudier.resources.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.littlesekii.crudier.resources.person.model.Person;
import api.littlesekii.crudier.resources.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll() {
		List<Person> data = repository.findAll();
		return data;
	}
	
	public Person findById(Long id) {
		Person data = repository.findById(id).orElse(null);
		return data;
	}
	
}
