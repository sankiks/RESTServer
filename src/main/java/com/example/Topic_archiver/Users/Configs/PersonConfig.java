package com.example.Topic_archiver.Users.Configs;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Topic_archiver.Users.Person;
import com.example.Topic_archiver.Users.PersonRepo;



@Configuration

public class PersonConfig {
  @Bean
	CommandLineRunner commandLineRunner(PersonRepo repo) {
		return ArgsAnnotationPointcut -> {
			Person yahya= new Person("Yahya", "YahyaOm@live.se",LocalDate.of(2024, 02,29));
			Person gilgamesh = new Person( "Gilgamesh","Gilgamesg1@live.se",LocalDate.of(2024, 02,29));
			repo.saveAll(List.of(yahya,gilgamesh));
		
		};
	}
	
	
	

}
