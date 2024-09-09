package com.ltp.gradesubmission;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import com.ltp.gradesubmission.controller.GradeController;

@SpringBootTest
@AutoConfigureMockMvc
class GradeSubmissionApplicationTests {

	//@Autowired 
	//private GradeController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	//	assertNotNull(controller);
		assertNotNull(mockMvc);
	}

	@Test 
	public void testShowForm() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/?id=123");
		mockMvc.perform(request)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("form"))
			.andExpect(model().attributeExists("grade"));
	}

}
