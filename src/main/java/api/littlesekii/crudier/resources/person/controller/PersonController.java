package api.littlesekii.crudier.resources.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.littlesekii.crudier.resources.person.controller.dto.PersonResponseDTO;
import api.littlesekii.crudier.resources.person.model.Person;
import api.littlesekii.crudier.resources.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<PersonResponseDTO>> findAll() {
		List<PersonResponseDTO> res = null;
		
		List<Person> data = service.findAll();
		
		res = data.stream().map(
			item -> new PersonResponseDTO(item.getId(), item.getName(), item.getRegister())
		).toList();
		
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonResponseDTO> findById(@PathVariable Long id) {
		PersonResponseDTO res = null;
		
		Person data = service.findById(id);
		
		if (data != null)
			res = new PersonResponseDTO(data.getId(), data.getName(), data.getRegister());
		
		return ResponseEntity.ok().body(res);
	}
	
}