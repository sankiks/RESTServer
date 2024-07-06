package com.example.Topic_archiver.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//data access layer
@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
	
	
	//Select * from person WHERE mail =? without the query below the code will run like this statement
	
	@Query("SELECT s FROM Person s WHERE s.mail=?1")//this will force the code below to run like the query is written
	// the person in the query refers to the Person class in the program and can fetch all the other parameters
	Optional<Person>findPersonbyMail(String mail);
	

}
