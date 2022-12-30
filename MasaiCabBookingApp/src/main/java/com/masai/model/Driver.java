package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Driver {

	@Min(value=1, message="id should be more than 1")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	@Min(value=1, message="id should be more than 1")
	private Integer licenseNo;
	
	@Min(value=1, message="id should be more than 1")
	private Double rating;
	
	private Boolean available;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="cabId")
	private Cab cab;

}
