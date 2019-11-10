package com.revature.grademanagementsystem.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.grademanagementsystem.model.Students;
import com.revature.grademanagementsystem.services.impl.StudentsServicesImpl;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class StudentsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentsServicesImpl studentsServiceMock;
	@InjectMocks
	StudentsControllerTest StudentsControllerTest;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testInsert() throws Exception {
		Students studentsObj = new Students();
		studentsObj.setRegistrationNumber(1);
		studentsObj.setName("testing");
		studentsObj.setFatherName("Tester");
		when(studentsServiceMock.insert(any())).thenReturn(1);
		String userJson = new ObjectMapper().writeValueAsString(studentsObj);
		mockMvc.perform(get("/addStudent?name=testing&fathername=test&address=location&dob=12/10/2010&department=1").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testViewStudents() throws Exception {
		List<Students> studentsList=new ArrayList<Students>();
		Students studentsObj = new Students();
		studentsObj.setRegistrationNumber(1);
		studentsObj.setName("testing");
		studentsObj.setFatherName("Tester");
		studentsList.add(studentsObj);
		when(studentsServiceMock.getStudents()).thenReturn(studentsList);
		String userJson = new ObjectMapper().writeValueAsString(studentsObj);
		mockMvc.perform(get("/viewStudents").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

}
