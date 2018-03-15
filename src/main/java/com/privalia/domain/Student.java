package com.privalia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated student ID")
	private Integer id;
	
	@Version
	@ApiModelProperty(notes = "The student name")
	@NotNull
	private String name;
	
	@Version
	@ApiModelProperty(notes = "The student surname")
	@NotNull
	private String surname;
	
	@ApiModelProperty(notes = "The student Address")
	private Address address;
	
	public Student() {
		super();

	}
	
	public Student(Integer id, String name, String surname, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
