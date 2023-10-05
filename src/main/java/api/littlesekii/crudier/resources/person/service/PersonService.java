package api.littlesekii.crudier.resources.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.littlesekii.crudier.exception.DatabaseEntityNotFoundException;
import api.littlesekii.crudier.exception.DatabaseIntegrityViolationException;
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
		Person data = repository.findById(id).orElseThrow(
			() -> new DatabaseEntityNotFoundException(
				String.format("Could not find any data by id '%d'", id)
			)
		);
		return data;
	}
	
	public Person insert(Person person) {
				
		Person existingData = repository.findByRegister(person.getRegister());
		
		if (existingData != null)
			throw new DatabaseIntegrityViolationException(
				String.format(						
					"Could not insert any data with register '%s'. "
					+ "There is already a entity with this register in database.",
					person.getRegister()				
				)
			);
		
		Person data = repository.save(person);		
		return data;
	}
	
	public Person update(Person person) {
		
		Person existingData = repository.findById(person.getId()).orElseThrow(
			() -> new DatabaseEntityNotFoundException(
				String.format("Could not find any data by id '%d'", person.getId())
			)
		);
		
		existingData = repository.findByRegister(person.getRegister());
		
		if (existingData != null && existingData.getId() != person.getId())
			throw new DatabaseIntegrityViolationException(
				String.format(						
					"Could not insert any data with register '%s'. "
					+ "There is already a entity with this register in database.",
					person.getRegister()				
				)
			);
				
		Person data = repository.save(person);;		
		return data;		
	}
	
	public Person delete(Long id) {
		
		Person existingData = repository.findById(id).orElseThrow(
			() -> new DatabaseEntityNotFoundException(
				String.format("Could not find any data by id '%d'", id)
			)
		);
		
		repository.deleteById(id);
		
		Person data = existingData;		
		return data;		
	}
	
}
