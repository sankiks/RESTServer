package com.example.Topic_archiver.Users;

import java.time.LocalDate;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

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

	@Size(min = 5, max = 20, message = "The username must be from 5 to 20 characters.")
	private String name;

	@Column(unique = true, nullable = false)
	private String mail;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@JsonManagedReference
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Idea> ideas;

	public Person(String name, String mail, LocalDate date) {

		this.name = name;
		this.mail = mail;
		this.date = date;

	}

	public Person() {

	}

	public Person(Long iD, String name, String mail, LocalDate date) {

		this.ID = iD;
		this.name = name;
		this.mail = mail;
		this.date = date;

	}

	public Person(Long iD, String name, String mail, LocalDate date, List<Idea> idea) {

		this.ID = iD;
		this.name = name;
		this.mail = mail;
		this.date = date;
		this.ideas = idea;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
		return "Person [ID=" + ID + ", name=" + name + ", mail=" + mail + ", dateOFRegistrationDate=" + date + "]";
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
