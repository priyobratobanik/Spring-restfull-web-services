package com.masai.ServiceLayerImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.EmployeeException;
import com.masai.Repository.EmployeeDao;
import com.masai.ServiceLayer.EmployeeService;
import com.masai.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao eDao;
	

	@Override
	public Employee CreateEmployees(Employee employees) throws EmployeeException {
		if(employees!=null) {
			Employee existingEmployee=eDao.save(employees);	
		}
		else {
			throw new EmployeeException("No employee saved");
		}
		
		
		return null;
	}

	@Override
	public Employee findByEmployees(Integer id) throws EmployeeException {
		return eDao.findById(id).orElseThrow(() ->  new EmployeeException("employee not found by id"));
		
		
	}

	@Override
	public Employee deleteEmployees(Integer id) throws EmployeeException {
		
		Employee emp = eDao.findById(id).orElseThrow(() -> new EmployeeException("employee noy found by id"));
		eDao.delete(emp);
		return emp;
	}

}
