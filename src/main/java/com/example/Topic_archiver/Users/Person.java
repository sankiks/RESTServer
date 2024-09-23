package com.example.Topic_archiver.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

//import jakarta.validation.constraints.Size;

@Entity
@Table
public class Person {

	@Id
	@SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1

	)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")

	private Long ID;

	@Size(min = 3, max = 20, message = "The username must be from 5 to 20 characters.")
	private String firstname;
	
	@Size(min = 3, max = 20, message = "The surname must be from 5 to 20 characters.")
	private String surname;
	
	

	@Column(unique = true, nullable = false)
	private String mail;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@JsonManagedReference
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Idea> ideas= new ArrayList<Idea>();

	public Person(String name, String mail, LocalDate date) {

		this.firstname = name;
		this.mail = mail;
		this.date = date;

	}

	public Person() {

	}

	public Person(Long iD, String firstname,String surname, String mail, LocalDate date) {

		this.ID = iD;
		this.firstname = firstname;
		this.surname = surname;
		this.mail = mail;
		this.date = date;

	}

	public Person(Long iD, String name, String surname, String mail, LocalDate date, List<Idea> idea) {

		this.ID = iD;
		this.firstname = name;
		this.surname = surname;
		this.mail = mail;
		this.date = date;
		this.ideas = idea;

	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the name
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param name the name to set
	 */
	public void setFirstname(String name) {
		this.firstname = name;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the iD
	 */
	public Long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Long iD) {
		ID = iD;
	}

	/**
	 * @return the dateOFRegistrationDate
	 */
	public LocalDate getDateOFRegistrationDate() {
		return date;
	}

	public void setDateOFRegistrationDate(LocalDate date) {
		this.date = date;
	}

	

	@Override
	public String toString() {
		return "Person [ID=" + ID + ", firstname=" + firstname + ", surname=" + surname + ", mail=" + mail + ", date="
				+ date + ", ideas=" + ideas + "]";
	}

	/**
	 * @return the ideas
	 */
	public List<Idea> getIdeas() {
		return ideas;
	}

	/**
	 * @param ideas the ideas to set
	 */
	public void setIdeas(List<Idea> ideas) {

		this.ideas = ideas;
	}

	public void setIdea(Idea idea) {
		
		this.ideas.add(idea);
	}

}
