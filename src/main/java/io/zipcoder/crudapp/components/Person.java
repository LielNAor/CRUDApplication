package io.zipcoder.crudapp.components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceConstructor;



@Entity
public class Person {

	private String firstname;
	private String lastname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Person(){
	}
	
	@PersistenceConstructor
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
