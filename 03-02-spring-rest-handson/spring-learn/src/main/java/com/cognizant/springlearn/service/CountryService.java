package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

public class CountryService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringLearnApplication.class);
    public Country getCountry(String code) {
    	LOGGER.info("START displayAllCountry method");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"country.xml");
		ArrayList<Country> list = (ArrayList<Country>) context.getBean(
				"countryList", ArrayList.class);
		Optional<Country> country = list.stream().filter(l -> l.getCode().equals(code)).findFirst();
		if(country.empty() == null)
			throw new RuntimeException(new CountryNotFoundException());
		return country.get();
    }
}
