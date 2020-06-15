package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	@Autowired
  private EmployeeService employeeService;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringLearnApplication.class);
  @GetMapping("/employees")
  public ArrayList<Employee> getAllEmployees()
  {
	  LOGGER.info("START getAllEmployees method");
	  LOGGER.info("END getAllEmployees method");
	  return employeeService.getAllEmployee();
  }
  @PutMapping("updateEmployee")
  public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
	  LOGGER.info("START updateEmployee method");
  		employeeService.updateEmployee(employee);
  		 LOGGER.info("END updateEmployee method");
  	}
  	
  	@DeleteMapping("/deleteEmployee/{id}")
  	public void deleteEmployee(@PathVariable String id) throws EmployeeNotFoundException{
  		 LOGGER.info("START deleteEmployee method");
  	employeeService.deleteEmployee(id);
  	 LOGGER.info("END deleteEmployee method");
  	}
}
