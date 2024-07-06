package com.example.Topic_archiver.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IdeaRepo extends JpaRepository<Idea, Long> {

	// Select * from person WHERE mail =? without the query below the code will run
	// like this statement

	 // this will force the code below to run like the query is written
	// the person in the query refers to the Person class in the program and can
	// fetch all the other parameters
	
	@Query("SELECT s FROM Idea s WHERE s.title=?1")
	Optional<Idea> findIdeaByTitle(String title) ;

}
