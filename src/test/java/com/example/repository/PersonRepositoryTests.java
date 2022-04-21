/**
 * 
 */
package com.example.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import com.example.model.Person;

/**
 * @author Goutam Sikder
 *
 */
@DataMongoTest
public class PersonRepositoryTests {

	@Autowired
	private PersonRepository personRepository;

	private Person person;

	@BeforeEach
	public void setup() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		
		String firstName = "Goutam" + str.charAt(new Random().nextInt(25 - 0 + 1) + 0);
		String lastName = "Sikder" + str.charAt(new Random().nextInt(25 - 0 + 1) + 0);
		String bloodType[] = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
		Person p = Person.builder().firstName(firstName)
				.lastName(lastName)
				.fullName(firstName + " " + lastName)
				.bloodType(bloodType[new Random().nextInt(7 - 0 + 1) + 0])
				.isDeleted(Boolean.FALSE).build();
		person = personRepository.save(p);
	}

	// Person Object Find By Id
	@DisplayName("Person Object Find By Id")
	@Test
	public void givenPersonObjectWhenFindThenPersonObjectCheck() {
		// given PersonObject

		// when Person Object find from Database
		Optional<Person> personDB = personRepository.findById(this.person.getId());

		// then find Person Object
		assertThat(personDB.get()).isNotNull();

	}

	// Person Object Find By First Name
	@DisplayName("Person Object Find By First Name")
	@Test
	public void givenPersonObjectWhenFindByFirstNameThenPersonObjectCheck() {
		// given PersonObject

		// when Person Object find from Database
		List<Person> personDB = personRepository.findByFirstName(this.person.getFirstName());
		
		// then find Person Object
		assertThat(personDB.size()).isGreaterThan(0);

	}

	// Person Object Find By Last Name
	@DisplayName("Person Object Find By Last Name")
	@Test
	public void givenPersonObjectWhenFindByLastNameThenPersonObjectCheck() {
		// given PersonObject

		// when Person Object find from Database
		List<Person> personDB = personRepository.findByLastName(this.person.getLastName());
		
		// then find Person Object
		assertThat(personDB.size()).isGreaterThan(0);

	}

	// Person Object Find By Query param JSON Object Last Name
	@DisplayName("Person Object Find By Query param JSON Object Last Name")
	@Test
	public void givenPersonObjectWhenQueryParamJSONObjectLastNameThenPersonObjectCheck() {
		// given PersonObject

		// when Person Object find from Database
		List<Person> personDB = personRepository.findPersonByLastName(this.person.getLastName());
		
		// then find Person Object
		assertThat(personDB.size()).isGreaterThan(0);
	}

	// Person Object Find By Query param JSON Object Regex Full Name and input is First Name
	@DisplayName("Person Object Find By Query param JSON Object Regex Full Name and input is First Name")
	@Test
	public void givenPersonObjectWhenQueryParamJSONObjectRegexFullNameThenPersonObjectCheck() {
		// given PersonObject

		// when Person Object find from Database
		List<Person> personDB = personRepository.findPersonByFullName(this.person.getFirstName());
		
		// then find Person Object
		assertThat(personDB.size()).isGreaterThan(0);
	}

}
