package com.example.Topic_archiver.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Idea")
public class Idea {
	@Id
	@SequenceGenerator(name = "idea_sequence", sequenceName = "idea_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	//private LocalDateTime dateCreated;
	private LocalDate date;

	@Column(columnDefinition = "text",nullable = false)
	private String docContent;
	
	@Size(min = 5, message = "Idea must have a title, min 30 character  ")
	@Column(nullable = false)
	private String title;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	public Idea(LocalDate dateCreated, String docContent, String title, Person person) {

		this.date = dateCreated;
		this.docContent = docContent;
		this.title = title;
		this.person = person;
	}

	public Idea(LocalDate dateCreated, String docContent, String title) {

		this.date = dateCreated;
		this.docContent = docContent;
		this.title = title;
		
	}

	public Idea() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateCreated
	 */
	public LocalDate getDateCreated() {
		return date;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(LocalDate dateCreated) {
		this.date = dateCreated;
	}

	/**
	 * @return the docContent
	 */
	public String getDocContent() {
		return docContent;
	}

	/**
	 * @param docContent the docContent to set
	 */
	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	/**
	 * @return the ideaName
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param ideaName the ideaName to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Idea [id=" + id + ", dateCreated=" + date + ", docContent=" + docContent + ", title="
				+ title + ", personID=" + person.getID() + "]";
	}

	
	
}
