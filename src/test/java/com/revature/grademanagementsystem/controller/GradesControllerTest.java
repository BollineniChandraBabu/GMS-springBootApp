package com.revature.grademanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.grademanagementsystem.model.Grades;
import com.revature.grademanagementsystem.services.impl.GradesServicesImpl;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class GradesControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private GradesServicesImpl gradesServicesMock;
	@InjectMocks
	GradesControllerTest GradesControllerTest;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testViewGrades() throws Exception {
		List<Grades> gradesList=new ArrayList<Grades>();
		Grades gradesObj = new Grades();
		gradesObj.setGrade("A");
		gradesObj.setMinMark(85);
		gradesObj.setMaxMark(100);
		gradesList.add(gradesObj);
		Grades gradesObj1 = new Grades();
		gradesObj1.setGrade("B");
		gradesObj1.setMinMark(65);
		gradesObj1.setMaxMark(84);
		gradesList.add(gradesObj1);;
		when(gradesServicesMock.viewGrades()).thenReturn(gradesList);
		String gradesJson = new ObjectMapper().writeValueAsString(gradesList);
		mockMvc.perform(get("/viewgrade").contentType(MediaType.APPLICATION_JSON).content(gradesJson))
				.andExpect(status().isOk());	
	}

	@Test
	void testUpdateGradeRange() throws Exception {
		Grades gradesObj = new Grades();
		gradesObj.setGrade("A");
		gradesObj.setMinMark(85);
		gradesObj.setMaxMark(100);
		when(gradesServicesMock.updateGradeRange(any())).thenReturn(true);
		String gradesJson = new ObjectMapper().writeValueAsString(gradesObj);
		mockMvc.perform(get("/updateGrade?grade=A&minimummark=85&maximummark=100").contentType(MediaType.APPLICATION_JSON).content(gradesJson))
				.andExpect(status().isOk());	
	}

	@Test
	void testGetGrade() throws Exception {
		Grades gradesObj = new Grades();
		gradesObj.setGrade("A");
		gradesObj.setMinMark(85);
		gradesObj.setMaxMark(100);
		when(gradesServicesMock.getGrade(anyInt())).thenReturn("A");
		String gradesJson = new ObjectMapper().writeValueAsString(gradesObj);
		mockMvc.perform(get("/getGrade?average=85").contentType(MediaType.APPLICATION_JSON).content(gradesJson))
				.andExpect(status().isOk());
	}

}
