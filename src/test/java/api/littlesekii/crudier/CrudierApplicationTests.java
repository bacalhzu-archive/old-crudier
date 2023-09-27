package api.littlesekii.crudier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import api.littlesekii.crudier.resources.person.model.Person;
import api.littlesekii.crudier.resources.person.service.PersonService;

@SpringBootTest
class CrudierApplicationTests {

	@Autowired
	private PersonService service;
	
	@Test
	void contextLoads() {
		
		Person data = service.findById(1L);
		
		System.out.println("Testing...");
		
		System.out.println(data);
	}

}
