package com.cognizant.springlearn.model;

public class Employee {
	

	private int id;
	private String name;
	private int salary;
	private String permanent;
	private String dateOfBirth;
    private Department department;
    private Skills skills;
    public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, int salary, String permanent,
			String dateOfBirth, Department department, Skills skills) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.skills = skills;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPermanent() {
		return permanent;
	}
	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Skills getSkills() {
		return skills;
	}
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", permanent=" + permanent + ", dateOfBirth=" + dateOfBirth
				+ ", department=" + department + ", skills=" + skills + "]";
	}
	
}
