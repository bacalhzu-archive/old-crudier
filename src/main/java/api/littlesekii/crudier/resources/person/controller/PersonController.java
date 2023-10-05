package api.littlesekii.crudier.resources.person.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.littlesekii.crudier.exception.InvalidRequestParamException;
import api.littlesekii.crudier.resources.person.controller.dto.PersonRequestDTO;
import api.littlesekii.crudier.resources.person.controller.dto.PersonResponseDTO;
import api.littlesekii.crudier.resources.person.model.Person;
import api.littlesekii.crudier.resources.person.service.PersonService;
import api.littlesekii.crudier.util.Utils;
import io.github.littlesekii.aritana.util.Validation;

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
			item -> new PersonResponseDTO(
				item.getId(), 
				item.getName(), 
				item.getRegister()
			)
		).toList();
		
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonResponseDTO> findById(@PathVariable Long id) {
		PersonResponseDTO res = null;
		
		Person data = service.findById(id);
	
		res = new PersonResponseDTO(
			data.getId(), 
			data.getName(), 
			data.getRegister()
		);
		
		return ResponseEntity.ok().body(res);
	}
	
	@PostMapping
	public ResponseEntity<PersonResponseDTO> insert(@RequestBody PersonRequestDTO req) {
		
		if (Validation.notValid(req.name()) || Validation.notValid(req.register()))
			throw new InvalidRequestParamException("Please check informed parameters and try again.");
		
		PersonResponseDTO res = null;		
		
		Person data = service.insert(
			new Person(
				req.name(), 
				req.register()
			)
		);
		
		res = new PersonResponseDTO(
			data.getId(), 
			data.getName(), 
			data.getRegister()
		);
			
		//get the created entity URI location
		URI uri = Utils.getCreatedEntityURILocation(data.getId());
		
		return ResponseEntity.created(uri).body(res);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonResponseDTO> update(@PathVariable Long id, @RequestBody PersonRequestDTO req) {
		
		if (Validation.notValid(req.name()) || Validation.notValid(req.register()))
			throw new InvalidRequestParamException("Please check informed parameters and try again.");
		
		PersonResponseDTO res = null;
		
		Person data = service.update(
			new Person(
				id,
				req.name(), 
				req.register()
			)
		);
		
		res = new PersonResponseDTO(
			data.getId(), 
			data.getName(), 
			data.getRegister()
		);
		
		return ResponseEntity.ok().body(res);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonResponseDTO> delete(@PathVariable Long id) {
		PersonResponseDTO res = null;
		
		Person data = service.delete(id);
		
		res = new PersonResponseDTO(
			data.getId(), 
			data.getName(), 
			data.getRegister()
		);
		
		return ResponseEntity.ok().body(res);
	}	
}
