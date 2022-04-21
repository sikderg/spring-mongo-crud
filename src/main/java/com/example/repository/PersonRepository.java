/**
 * 
 */
package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Person;

/**
 * @author Goutam Sikder
 *
 */
public interface PersonRepository extends CrudRepository<Person, String> {

	/**
	 * @param id
	 * @return
	 */
	List<Person> findByFirstName(String firstName);

	/**
	 * @param lastName
	 * @return
	 */
	List<Person> findByLastName(String lastName);

	// JSON Query Method by First Name
	/**
	 * @param firstName
	 * @return
	 */
	@Query("{ 'firstName' : ?0 }")
	List<Person> findPersonByFirstName(String firstName);

	// JSON Query Method by Last Name
	/**
	 * @param lastName
	 * @return
	 */
	@Query("{ 'lastName' : ?0 }")
	List<Person> findPersonByLastName(String lastName);

	// JSON Query Method by Full Name - a regex driven query
	/**
	 * @param fullName
	 * @return
	 */
	@Query("{ fullName : { $regex : ?0 } }")
	List<Person> findPersonByFullName(String fullName);

}
