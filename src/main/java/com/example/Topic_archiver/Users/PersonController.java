package com.example.Topic_archiver.Users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




// restcontroller control the http requests like get and post
@RestController
//requestmapping path define the path of the rest api
@RequestMapping  (path = "api/v1/Archive") 
public class PersonController {
	
	
	private final PersonService service;
	
	//dependency incejtion so when the service class runs as bean it can be autowired
	@Autowired
	public PersonController(PersonService service) {
		this.service= service;
	}
	
	
	@GetMapping (path ="getUsers" )
	public List<Person> getPersons()
	{
		return service.getUsers();
	}
	
	@GetMapping (path ="getUser/{id}" )
	public Person getPerson(@PathVariable String id)
	{
		return service.getPerson(id);
	}
	
	@PostMapping (path ="addUser" )
	public void setPerson(@RequestBody Person person) {
		service.addPerson (person);
		
	}
	
	@PostMapping(path = "addIdea")
	public void addIdea(@RequestBody Idea idea) {
		System.out.println(idea.toString()+"/n");
		service.addIdea(idea);
		
	}
	
	@PostMapping(path = "addIdea/{id}")
	public void addIdea(@PathVariable String id,@RequestBody Idea idea) {
		
		service.addIdea(id,idea);
		
	}
	
	@PutMapping(path = "userCredentials/{id}")
	public void changeCredentials(@RequestBody Person per, @PathVariable Long id) {
		
		service.changeCredentials(per,id);
	}
	
	@DeleteMapping(path = "removeUser/{id}")
	public boolean removeUser(@PathVariable Long id) {
		return service.removeUser(id);
	}
	
	@DeleteMapping(path = "removeIdea/{userId}/{ideaId}")
	public boolean removeIdea(@PathVariable Long userId, @PathVariable long ideaId) {
		
		return service.removeIdea(userId,ideaId);
	}

}
