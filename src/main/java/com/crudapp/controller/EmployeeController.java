package com.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudapp.models.Employee;
import com.crudapp.services.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/")
	public String getAllEmployee(Model model) {
		model.addAttribute("employeeList", this.employeeServiceImpl.getAllEmployee());
		return "index";
	}
	
	@GetMapping("/add-employee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute(employee);
		return "add-employee-form";
	}
	
	@PostMapping("/add-employee-form")
	public String addEmployeeData(@ModelAttribute("employee") Employee employee) {
		this.employeeServiceImpl.addEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("/id") Long id) {
		return this.getEmployeeById(id);
	}
	
	@GetMapping("/show-form-for-update/{id}")
	public String updateEmployee(@PathVariable("id") Long id, Model m) {
		Employee employee = this.employeeServiceImpl.getEmployeeById(id);
		m.addAttribute("employee",employee);
		return "update-form";
	}
	
	@PostMapping("/update-employee-form")
	public String updateEmployeeData(@ModelAttribute("employee") Employee employee) {
		this.employeeServiceImpl.addEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/employee-delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		this.employeeServiceImpl.deleteEmployee(id);
		return "redirect:/";
	}
}
