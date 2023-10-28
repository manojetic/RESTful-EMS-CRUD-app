package com.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.Model.Employee;
import com.main.Service.EmployeeService;

@org.springframework.stereotype.Controller


public class Controller {

	@Autowired
	private EmployeeService service;
	
	
	//display list of employees
	@GetMapping("/")
	public String getEmployeeList(Model model) {
		model.addAttribute("employees", service.showAllEmployee());
		return "index";
	}
	@GetMapping("/newEmployeeform")
	public String newEmployeeform(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value= "id")long id, Model model) {
		Employee employee= service.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value ="id")long id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
	}
}
