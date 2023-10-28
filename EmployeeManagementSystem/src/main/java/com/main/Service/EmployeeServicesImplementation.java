package com.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Model.Employee;
import com.main.Repository.EmployeeRepository;

@Service
public class EmployeeServicesImplementation implements EmployeeService {
	
		@Autowired
		private EmployeeRepository repository;
	@Override
	public List<Employee> showAllEmployee() {
		
		return repository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.repository.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional= repository.findById(id);
		Employee employee= null;
		
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not found for if:" +id);
		}
		return employee;
	}
	@Override
	public void deleteEmployeeById(long id) {
		this.repository.deleteById(id);
		
	}

}
