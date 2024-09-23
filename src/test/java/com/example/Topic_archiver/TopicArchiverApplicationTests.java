package com.example.Topic_archiver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Topic_archiver.Users.PersonController;

@SpringBootTest
class TopicArchiverApplicationTests {
	
	@Autowired
	private PersonController controller;

	
	@Test
	void contextLoads() {
		// assert that the controller is created
		// sanity check
		assertThat(controller).isNotNull();
	}

}
