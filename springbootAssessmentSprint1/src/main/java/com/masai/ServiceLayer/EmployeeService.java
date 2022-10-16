package com.masai.ServiceLayer;



import com.masai.Exceptions.EmployeeException;
import com.masai.models.Employee;

public interface EmployeeService {

    public Employee CreateEmployees(Employee employees)throws EmployeeException;
    
    public Employee findByEmployees(Integer id)throws EmployeeException;
    
    public Employee deleteEmployees(Integer id)throws EmployeeException;
}
