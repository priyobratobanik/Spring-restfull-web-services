package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.EmployeeException;
import com.masai.ServiceLayer.EmployeeService;
import com.masai.models.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService eService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee emp) throws EmployeeException {

		Employee savedemp = eService.CreateEmployees(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
//	@PutMapping("/employee")
//	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)throws EmployeeException{
//		Employee updateemp=eService.CreateEmployees(emp);
//		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
//	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") Integer id) throws EmployeeException {

		Employee emp = eService.findByEmployees(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteByEmployeeID(@PathVariable("id") Integer id) throws EmployeeException {

		Employee delemp = eService.deleteEmployees(id);
		return new ResponseEntity<Employee>(delemp, HttpStatus.OK);

	}

}
