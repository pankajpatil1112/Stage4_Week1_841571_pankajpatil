package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.debug("pankaj patil 841571");
		displayDate();
		displayCountry();
		displayAllCountry();
	}

	/**
 * 
 */
	public static void displayDate() {
		LOGGER.info("START displayDate method");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat",
				SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			// System.out.println(date);
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END displayDate method");

	}

	public static void displayCountry() {
		LOGGER.info("START displayCountry method");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country: {}", country.toString());
		LOGGER.debug("Country: {}", anotherCountry.toString());
		LOGGER.info("END displayCountry method");
	}

	public static void displayAllCountry() {
		LOGGER.info("START displayAllCountry method");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"country.xml");
		ArrayList<Country> list = (ArrayList<Country>) context.getBean(
				"countryList", ArrayList.class);
		for (Country c : list) {
			LOGGER.debug(c.toString());
		}
		LOGGER.info("END displayAllCountry method");
	}
}
