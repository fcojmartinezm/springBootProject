package com.privalia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated address ID")
	private Integer id;
	
	@Version
	@ApiModelProperty(notes = "The address street")
	@NotNull
	private String street;
	
	@Version
	@ApiModelProperty(notes = "The address number")
	@NotNull
	private String number;

	public Address() {
		super();
	}
	
	public Address(Integer id, String street, String number) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
