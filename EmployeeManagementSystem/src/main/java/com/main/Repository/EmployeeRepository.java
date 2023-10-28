package com.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
