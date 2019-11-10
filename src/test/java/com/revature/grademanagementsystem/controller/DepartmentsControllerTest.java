package com.revature.grademanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.anyInt;
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
import com.revature.grademanagementsystem.model.Departments;
import com.revature.grademanagementsystem.services.impl.DepartmentsServicesImpl;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class DepartmentsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentsServicesImpl departmentsServiceMock;
	@InjectMocks
	DepartmentsControllerTest DepartmentsControllerTest;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testViewDepartments() throws Exception {
		List<Departments> departmentsList=new ArrayList<Departments>();
		Departments departmentsObj = new Departments();
		departmentsObj.setId(1);
		departmentsObj.setName("Telugu");
		departmentsList.add(departmentsObj);
		Departments departmentsObj1 = new Departments();
		departmentsObj1.setId(2);
		departmentsObj1.setName("Tamil");
		departmentsList.add(departmentsObj1);
		when(departmentsServiceMock.viewDepartments()).thenReturn(departmentsList);
		String departmentsJson = new ObjectMapper().writeValueAsString(departmentsList);
		mockMvc.perform(get("/viewEmployees").contentType(MediaType.APPLICATION_JSON).content(departmentsJson))
				.andExpect(status().isOk());
	}

	@Test
	void testCheckDepartment() throws Exception {
		Departments departmentsObj = new Departments();
		departmentsObj.setId(1);
		departmentsObj.setName("Telugu");
		when(departmentsServiceMock.checkDepartment(anyInt())).thenReturn(true);
		String departmentsJson = new ObjectMapper().writeValueAsString(true);
		mockMvc.perform(get("/checkDepartment?department=1").contentType(MediaType.APPLICATION_JSON).content(departmentsJson))
				.andExpect(status().isOk());
	}

}
