package com.cognizant.springlearn.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	public ArrayList<Employee> getAllEmployee(){
		return employeeDao.getAllEmployees();
	}
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		employeeDao.updateEmployee(employee);
	}
	public void deleteEmployee(String id) throws EmployeeNotFoundException{
		employeeDao.deleteEmployee(id);
		}
}
