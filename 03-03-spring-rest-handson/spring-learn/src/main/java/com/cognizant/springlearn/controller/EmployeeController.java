package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

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
}
