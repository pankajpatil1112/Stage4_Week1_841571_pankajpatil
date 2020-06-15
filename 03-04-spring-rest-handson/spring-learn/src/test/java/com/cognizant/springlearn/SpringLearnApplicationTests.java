package com.cognizant.springlearn;
import com.cognizant.springlearn.controller.CountryController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
   @Autowired
   private CountryController countryController;
	@Test
	void contextLoads() {
		Assertions.assertNotNull(countryController);
	}
//   @Autowired
//   private MockMvc mvc;
//   @Test
//   public void testGetCountry() throws Exception {
//	   ResultActions actions = mvc.perform(get("/country"));
//       actions.andExpect(status().isOk());
//       actions.andExpect(jsonPath("$.code").exists());
//       actions.andExpect(jsonPath("$.code").value("IN"));
//   }
//   @Test
//   public void testGetCountryException() throws Exception{
//		
//		ResultActions actions = mvc.perform(get("/country"));
//		actions.andExpect(status().isOk());
//		 actions.andExpect(jsonPath("$.code").exists());
//		 actions.andExpect(jsonPath("$.code").value("az"));
//		 actions.andExpect(status().isBadRequest());
//	     actions.andExpect(status().reason("Country Not found"));
//
//	}

}
