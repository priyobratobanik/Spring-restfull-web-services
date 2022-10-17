package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{

	public List<Employee> findByAddress(String address);
	
	
	
	@Query("select new com.masai.model.EmployeeDTO(e.empName,e.address,e.salary) from Employee e")
	public List<EmployeeDTO> getNameAddressSalary();
}
