/**
 * 
 */
package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.repository.PersonRepository;

/**
 * @author Goutam Sikder
 *
 */
@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private PersonRepository personRepository;
}
