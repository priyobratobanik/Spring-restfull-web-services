package com.masai.models;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull(message="name field should not be empty")
	//@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please enter a valid name")
	private String name;
	
	@NotNull(message="Email is mandatory")
	@Pattern(regexp = "^(.+)@(\\S+)$",message = "Input a valid email address")
	private String email;
	@NotNull(message="state should not be empty")
	private String state;
	@NotNull(message = "Mobile number field should not be empty")
	@Pattern(regexp = "[7896]{1}[0-9]{9}",message = "Input a valid mobile number")
	private String mobile;
	
	@NotNull(message="designation should not be null")
	private String designation;
	
	

}
