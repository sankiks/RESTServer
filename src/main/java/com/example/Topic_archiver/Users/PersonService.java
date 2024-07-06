package com.example.Topic_archiver.Users;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// service bean so classes can be autowired??
@Service
public class PersonService {

	private final PersonRepo personRepo;
	private final IdeaRepo ideaRepo;
	
	
	@Autowired
	public PersonService(PersonRepo personRepo, IdeaRepo ideaRepo) {
		this.personRepo = personRepo;
		this.ideaRepo=ideaRepo;
	}

	public List<Person> getUsers() {
		return personRepo.findAll();
	}

	public void addPerson(Person person) {
		Optional<Person> personMail = personRepo.findPersonbyMail(person.getMail());
		// check if mail is taken
		

		personRepo.save(person);
	}
	

	public void addIdea(Idea idea) {
		
			
			ideaRepo.save(idea);
		
			
		

	}

	public Person getPerson(String id) {
		Long userId = Long.decode(id);
		Optional<Person> per = personRepo.findById(userId);
		Person person= per.get();
		if (!per.isPresent()) {
			throw new IllegalStateException("No user with ID: "+id);
		}
		
		return person;
	}

	public void addIdea(String id, Idea idea) {
		Long userId = Long.decode(id);
		Optional<Person> per= personRepo.findById(userId);
		if (!per.isPresent()) {
			throw new IllegalStateException("No user with ID: "+id);
		}
		ideaRepo.save(idea);
	}

	public void changeCredentials(Person per,Long id) {
		Person personOptional = personRepo.findById(id).get();
		personOptional.setDateOFRegistrationDate(per.getDateOFRegistrationDate());
		personOptional.setName(per.getName());
		personOptional.setMail(per.getMail());
		
		personRepo.save(personOptional);
		
		
	}

	public boolean removeUser(Long id) {
		Optional<Person> perOptional= personRepo.findById(id);
		if(perOptional.isPresent()) {
			personRepo.deleteById(id);
			return true;
		}
		
		return false;
	}

	public boolean removeIdea(Long userId, Long ideaId) {
		Optional<Person>perOptional=personRepo.findById(userId);
		Optional<Idea> ideaOptional= ideaRepo.findById(ideaId);
		if (perOptional.isPresent()) {
			if (ideaOptional.isPresent()) {
				ideaRepo.deleteById(ideaId);
				return true;
			}
		}
		
		return false;
	}

}
