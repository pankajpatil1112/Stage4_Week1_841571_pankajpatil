package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
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
  public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		boolean flag=false;
		System.out.println(employee);
		for(int i=0;i<list.size();i++) {
			if(employee.getId().equals(list.get(i).getId())) {
				flag=true;
				list.set(i, employee);
				
			}
		}
		if(flag==false) {
			throw new EmployeeNotFoundException();
		}
	}
	
	public void deleteEmployee(String id) throws EmployeeNotFoundException{
		boolean flag=false;
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				flag=true;
				list.remove(i);
				
			}
		}
		if(flag==false) {
			throw new EmployeeNotFoundException();
		}
	}
}
