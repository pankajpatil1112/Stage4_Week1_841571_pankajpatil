package com.cognizant.springlearn.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Skills {
	@NotNull
	@Pattern(regexp = "[0-9]+",message = "Should be a number")
	String id;
	@NotNull(message = "should not be null") @NotBlank
	@Pattern(regexp = "[a-zA-Z] {1,30}")
	String name;
   public Skills() {
	// TODO Auto-generated constructor stub
}
public Skills(String id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
