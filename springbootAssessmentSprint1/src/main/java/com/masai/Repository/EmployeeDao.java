package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	
	
	

}
