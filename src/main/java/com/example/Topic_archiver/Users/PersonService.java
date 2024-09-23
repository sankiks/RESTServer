package com.example.Topic_archiver.Users;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

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
		
		Optional<Person> personObj = personRepo.findPersonbyMail(person.getMail());
		
		
		if(!personObj.isPresent()) {
			personRepo.save(person);
			
		}else {
			throw new IllegalStateException("there is already an existing user with this mail");
		}
				
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
		Person existPerson= per.get();
		existPerson.getIdeas().add(idea);
		personRepo.save(existPerson);
	
	}
	
	
	public void addIdea( Idea idea) {
		
		Optional<Person> per= personRepo.findPersonbyMail(idea.getPerson().getMail());
		Person existPerson;
		if (!per.isPresent()) {
			//List <Idea> ideas= new ArrayList<Idea>();
			existPerson= idea.getPerson();
			
			existPerson.setIdea(idea);
			
		}else {
			existPerson= per.get();// try remove this line ndnfbsjkdfjksdhfjksdnfkjsdh
			//here where need to make sure the relationship between ideas and person are consistent. If not hibernate 
			idea.setPerson(existPerson);
			existPerson.setIdea(idea);
		}
		
		personRepo.save(existPerson);
	}


	public void changeCredentials(Person per,Long id) {
		Person personOptional = personRepo.findById(id).get();
		personOptional.setDateOFRegistrationDate(per.getDateOFRegistrationDate());
		personOptional.setFirstname(per.getFirstname());
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

	public List<Idea> getIdeas() {
		// TODO Auto-generated method stub
		return ideaRepo.findAll();
	}

}
