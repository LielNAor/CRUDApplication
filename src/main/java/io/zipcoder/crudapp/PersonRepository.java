package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

import io.zipcoder.crudapp.components.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
}
