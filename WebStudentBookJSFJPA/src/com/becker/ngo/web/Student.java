package com.becker.ngo.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@ManagedBean
@RequestScoped

@Entity
//peut etre ajouter @Table(name='student') à cause des majuscules ? 

public class Student {
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto-incrementation
	@Column(name="id")
	private int Id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	public Student() {
		Id = 0;
		firstName = null;
		lastName = null;
		email = null;
	}
	
	public Student(int IdArg, String firstNameArg, String lastNameArg, String emailArg) {
		Id = IdArg;
		firstName = firstNameArg;
		lastName = lastNameArg;
		email = emailArg;		
	}
	
	public Student(String firstNameArg, String lastNameArg, String emailArg) {
		firstName = firstNameArg;
		lastName = lastNameArg;
		email = emailArg;	
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
