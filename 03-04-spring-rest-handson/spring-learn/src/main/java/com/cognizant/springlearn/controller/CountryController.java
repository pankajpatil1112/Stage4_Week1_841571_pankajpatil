package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;


@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringLearnApplication.class);

  @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public String sayHello(){
	  LOGGER.info("START sayHello method");
//	  Name name = new Name("pankaj");
//	  return name;
	  String msg = new String("Hello world");
	  LOGGER.info("End sayHello method");
	  return msg;
  }
  @RequestMapping(value = "/country", method = RequestMethod.GET)
  public Country getCountryIndia(){
	  LOGGER.info("START getCountry method");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"country.xml");
		Country country = context.getBean("country", Country.class);
		 LOGGER.info("End getCountry method");
		return country;
  }
  @GetMapping("/countries")
  public List<Country> getAllCounties()
  {
	  LOGGER.info("START getAllCountries method");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"country.xml");
		ArrayList<Country> list = (ArrayList<Country>) context.getBean(
				"countryList", ArrayList.class);
		 LOGGER.info("End getAllCountries method");
		return list;
  }
  @GetMapping("/countries/{code}")
  
  public Country getCountry(@PathVariable("code") String code) {
	  LOGGER.info("START getCountry method");
	  CountryService cs = new CountryService();
	  Country c = cs.getCountry(code);
	  LOGGER.info("End getCountry method");
	  return c;
  }
  @PostMapping("/countries")
  public Country addCountry(@RequestBody @Valid Country country){
	  LOGGER.info("START addCountry method");
      // Create validator factory
   /*   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      Validator validator = factory.getValidator();

      // Validation is done against the annotations defined in country bean
      Set<ConstraintViolation<Country>> violations = validator.validate(country);
      List<String> errors = new ArrayList<String>();

      // Accumulate all errors in an ArrayList of type String
      for (ConstraintViolation<Country> violation : violations) {
          errors.add(violation.getMessage());
      }

      // Throw exception so that the user of this web service receives appropriate error message
      if (violations.size() > 0) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
      }
*/
	  LOGGER.debug(country.toString());
	  LOGGER.info("END addCountry method");
	  return country;
  }
}
