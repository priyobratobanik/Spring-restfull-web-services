package com.masai.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> registerEmployeeHandler(@RequestBody Employee emp) throws EmployeeException{
		Employee employee=employeeService.registerEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getemployeeByIdHandler(@PathVariable("id") Integer empId) throws EmployeeException{
		
		Employee employee=employeeService.getEmployeeById(empId);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployeeHandler() throws EmployeeException{
		
		List<Employee> emps=employeeService.getAllEmployeeDetails();
		
		return new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deletebyIdHandler(@PathVariable("id") Integer empId) throws EmployeeException{
		
		Employee delemp=employeeService.deleteEmployeeById(empId);
		
		return new ResponseEntity<Employee>(delemp,HttpStatus.OK);
		
		
	}
	@GetMapping("/getbyaddress/{address}")
	public List<Employee> getEmployeebyAddressHandler(@PathVariable  String address) throws EmployeeException{
		
		return employeeService.getEmployeeDetailsByAddress(address);
	}
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws EmployeeException{
		
		Employee updatedemployee=employeeService.updateEmployee(employee);
		
		return new ResponseEntity<Employee>(updatedemployee,HttpStatus.OK);
	}
	
	@GetMapping("/getempnameaddress/{id}")
	public ResponseEntity<String[]> getEmployeesNameandAddressHandler(@PathVariable("id") Integer empId) throws EmployeeException{
		
		String[] getresult=employeeService.getNameAndAddressOfEmplyeeById(empId);
		return new ResponseEntity<String[]>(getresult,HttpStatus.OK);
		
	}
	
	@GetMapping("/getemployee")
	public List<EmployeeDTO> getdetailsDTOHandler() throws EmployeeException{
		return employeeService.getNameAddressSalaryOfAllEmployee();
	}
	
	
	
}
