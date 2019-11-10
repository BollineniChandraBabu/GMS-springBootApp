package com.revature.grademanagementsystem.controller;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
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
import com.revature.grademanagementsystem.model.Users;
import com.revature.grademanagementsystem.services.impl.UsersServicesImpl;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UsersControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UsersServicesImpl usersServiceMock;
	@InjectMocks
	UsersControllerTest usersControllerTest;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLoginController() throws Exception {
		Users userObj = new Users();
		userObj.setEmail("chandra@gmail.com.com");
		userObj.setPassword("chandra");
		userObj.setId(1);
		when(usersServiceMock.login(anyString(),anyString())).thenReturn(userObj);
		String userJson = new ObjectMapper().writeValueAsString(userObj);
		mockMvc.perform(get("/login?email=chandra@gmail.com&password=chandra").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1));
	}

	@Test
	public void testInsertController() throws Exception {
		Users userObj = new Users();
		userObj.setEmail("chandra@gmail.com.com");
		userObj.setPassword("chandra");
		userObj.setId(1);
		when(usersServiceMock.insert(any(Users.class))).thenReturn(1);
		String userJson = new ObjectMapper().writeValueAsString(userObj);
		mockMvc.perform(get("/addEmployee?name=chandra&fathername=srinivasulu&email=chandra@gmail.com&department=1").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	public void testActivateAccount() throws Exception {
		Users userObj = new Users();
		userObj.setEmail("chandra@gmail.com.com");
		userObj.setPassword("chandra");
		userObj.setId(1);
		when(usersServiceMock.activateAccount(anyInt(),anyString(),anyString())).thenReturn(true);
		String userJson = new ObjectMapper().writeValueAsString(userObj);
		System.out.println("result:"+userJson);
		mockMvc.perform(get("/activateEmployee?email=chandra@gmail.com&eid=1&password=chandra").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());

	}

	@Test
	public void testCheckByMailId() throws Exception {
		Users userObj = new Users();
		userObj.setEmail("chandra@gmail.com.com");
		userObj.setPassword("chandra");
		userObj.setId(1);
		when(usersServiceMock.checkByMailId(anyString())).thenReturn(true);
		String userJson = new ObjectMapper().writeValueAsString(userObj);
		mockMvc.perform(get("/checkEmail?email=chandra@gmail.com").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindIdByMail() throws Exception {
		Users userObj = new Users();
		userObj.setEmail("chandra@gmail.com.com");
		userObj.setPassword("chandra");
		userObj.setId(1);
		when(usersServiceMock.findIdByMail(anyString())).thenReturn(1);
		String userJson = new ObjectMapper().writeValueAsString(userObj);
		mockMvc.perform(get("/checkdetails?eid=1&email=chandra@gmail.com").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	public void testViewAllUsers() throws Exception {
		List<Users> usersList=new ArrayList<Users>();
		Users userObj = new Users();
		userObj.setEmail("chandra@gmail.com.com");
		userObj.setPassword("chandra");
		userObj.setId(1);
		usersList.add(userObj);
		Users userObj1 = new Users();
		userObj1.setEmail("cs@gmail.com.com");
		userObj1.setPassword("cs");
		userObj1.setId(2);
		usersList.add(userObj1);
		when(usersServiceMock.viewAllUsers()).thenReturn(usersList);
		String userJson = new ObjectMapper().writeValueAsString(usersList);
		mockMvc.perform(get("/viewEmployees").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());	
	}

}
