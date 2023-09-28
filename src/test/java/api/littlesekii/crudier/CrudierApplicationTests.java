package api.littlesekii.crudier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import api.littlesekii.crudier.resources.person.model.Person;
import api.littlesekii.crudier.resources.person.repository.PersonRepository;
import api.littlesekii.crudier.resources.person.service.PersonService;

@SpringBootTest
class CrudierApplicationTests {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonService service;
	
	@Test
	void contextLoads() {
		
		Person data = repository.findByRegister("123456784t9");
		
		System.out.println("Testing...");
		
		System.out.println(data);
	}

}
