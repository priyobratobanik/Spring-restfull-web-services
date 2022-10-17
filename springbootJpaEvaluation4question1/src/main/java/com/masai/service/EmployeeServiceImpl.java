package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		
		Employee registeremp=dao.save(emp);
		return registeremp;
		
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		
		Optional<Employee> opt=dao.findById(empId);
		return opt.orElseThrow(() -> new EmployeeException("no such employee found"));
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		
		List<Employee> emps=dao.findAll();
		if(emps.size()>0) {
			return emps;
		}
		else {
			throw new EmployeeException("No employee data found");
		}
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		
		Employee deletedEmp=dao.findById(empId).orElseThrow(() ->  new EmployeeException("Employee is not matching"));
		dao.delete(deletedEmp);
		return deletedEmp;
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
		
		List<Employee> emps=dao.findByAddress(address);
		
		if(emps.size()>0) {
			return emps;
		}
		else {
			throw new EmployeeException("Employee is not existed"+address);
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		
		Optional<Employee> opt=dao.findById(emp.getEmpId());
		if(opt.isPresent()) {
			return dao.save(emp);
			
		}
		else {
			throw new EmployeeException("invalid employee details");
		}
	
	}

	@Override
	public String[] getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		
		String[] nameAddress =new String[2];
		
		Employee employee=dao.findById(empId).orElseThrow(() -> new EmployeeException("no such employee found"));
		nameAddress[0]=employee.getAddress();
		nameAddress[1]=employee.getEmpName();
		return nameAddress;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		
		List<EmployeeDTO> dto=dao.getNameAddressSalary();
		
		if(dto.size()>0) {
			return dto;
		}
		else {
		throw new EmployeeException("no record found");
		}
	}

}
