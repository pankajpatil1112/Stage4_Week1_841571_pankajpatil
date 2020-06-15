package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
@Component
public class DepartmentDao {
	private ArrayList<Department> list;

	public DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"department.xml");
		ArrayList<Department> list = context.getBean("departmentList",
				ArrayList.class);
		this.list = list;
	}
	public ArrayList<Department> getAllDepartments(){
		return list;
	}
}
