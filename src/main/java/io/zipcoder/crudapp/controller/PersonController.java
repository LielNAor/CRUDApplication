package io.zipcoder.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.zipcoder.crudapp.PersonRepository;
import io.zipcoder.crudapp.components.Person;

@RestController
public class PersonController {

	@Autowired
	PersonRepository repo;

	// Create
	@RequestMapping(value="/people/create", method= RequestMethod.POST)
	public Person create (@RequestParam Person person){
		 repo.save(person);
		return person;
	}
	
	// Read
	@RequestMapping(value="/people", method= RequestMethod.GET)
	public Iterable<Person> readList(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/people/{id}", method= RequestMethod.GET)
	public Person read(@PathVariable Integer id){
		return repo.findOne(id);
	}
	
	// Update
	@RequestMapping (value="/people/{id}", method= RequestMethod.PUT)
	public Person update(@RequestBody Person person){
		return repo.save(person);
	}
	
	// Delete
	@RequestMapping(value="/people/{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){ //TODO verify variable type
		repo.delete(id);
	}
}
