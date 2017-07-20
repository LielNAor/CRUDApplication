package io.zipcoder.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Person> create (@RequestBody Person person){
		 repo.save(person);
		return  new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}
	
	// Read
	@RequestMapping(value="/people", method= RequestMethod.GET)
	public ResponseEntity<Iterable<Person>> readList(){
		return new ResponseEntity<Iterable<Person>>(repo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/people/{id}", method= RequestMethod.GET)
	public ResponseEntity<Person>read(@PathVariable Integer id){
		if (id<repo.count()) {
		return new ResponseEntity<Person>(repo.findOne(id), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Person>(new Person(), HttpStatus.NOT_FOUND);
		}
	}
	
	// Update
	@RequestMapping (value="/people/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable int id){
		if (id<repo.count()) {
			person.setId(id);
			return new ResponseEntity<Person>(repo.save(person), HttpStatus.FOUND);
			} else {
				return new ResponseEntity<Person>(repo.save(person), HttpStatus.CREATED);
			}
	}
	
	// Delete
	@RequestMapping(value="/people/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){ //TODO verify variable type
		 repo.delete(id);
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}
}
