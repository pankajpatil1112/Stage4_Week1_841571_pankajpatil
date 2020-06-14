package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
@Component
public class EmployeeDao {
  private ArrayList<Employee> list;
  public EmployeeDao(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"employee.xml");
		ArrayList<Employee> list =  context.getBean("employeeList", ArrayList.class);
		this.list = list;
  }
  public ArrayList<Employee> getAllEmployees(){
	  return list;
  }
}
