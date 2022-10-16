package com.masai.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String title;
	private String description;
	private boolean status;
	private String priority;
	private Integer assigned_employee_id;
	private LocalDate startdate;
	private LocalDate enddate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	Employee employee;
}
