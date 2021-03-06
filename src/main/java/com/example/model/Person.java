/**
 * 
 */
package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Goutam Sikder
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document
public class Person {
	@Id
	private String id;
	
	private Integer age;
	
	private String firstName;
	
	private String lastName;	
	
	private String fullName;

	private String bloodType;
	
	private Boolean isDeleted;

}
