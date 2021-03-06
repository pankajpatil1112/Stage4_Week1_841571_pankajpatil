package com.cognizant.springlearn.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;

public class Country {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringLearnApplication.class);
	public String code;

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

	Country() {
		LOGGER.debug("inside constructor");
	};

	public String getCode() {
		LOGGER.debug("inside code getter");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("inside code setter");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("inside name getter");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("inside name setter");
		this.name = name;
	}

	public String name;

	public Country(String code, String name) {
		super();
		LOGGER.debug("inside country constructor");
		this.code = code;
		this.name = name;
	}

}
