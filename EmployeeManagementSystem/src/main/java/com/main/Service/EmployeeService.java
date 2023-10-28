package com.main.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.Model.Employee;
import com.main.Repository.EmployeeRepository;


@Service
public interface EmployeeService{
	
	List<Employee> showAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
