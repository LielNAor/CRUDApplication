package io.zipcoder.crudapp.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.zipcoder.crudapp.PersonRepository;
import io.zipcoder.crudapp.components.Person;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {WebConfig.class})
public class PersonControllerTest {

	Person testPerson;

	@InjectMocks
	private PersonController pC;

	@Autowired
	PersonRepository repo;

	@Before
	public void setup(){
		pC = new PersonController();
	}

	@Test
	public void ableToCreatAPersonAndPersisitToH2(){
		Person p1 = new Person("1", "Daenerys Targaryen");
		Person p2 = new Person("2", "John Snow");
		List<Person> users = Arrays.asList(
				p1,
				p2);

		repo.save(p1);
		repo.save(p2);
		Iterable<Person> expected = (Iterable<Person>) users.iterator();
		Iterable<Person> actual = repo.findAll();

		Assert.assertEquals(expected, actual);
	}

	private boolean compare2Poeple(Person p1, Person p2){
		return (p1.getFirstname().equals(p2.getFirstname()) &&
				p1.getLastname().equals(p2.getLastname()));
	}
}
