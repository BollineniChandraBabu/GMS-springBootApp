package com.revature.grademanagementsystem.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.grademanagementsystem.dao.impl.UsersRepository;
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Users;
import com.revature.grademanagementsystem.services.impl.UsersServicesImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServicesImplTest {
	@InjectMocks
	private UsersServicesImpl usersServicesImpl;

	@Mock
	private UsersRepository usersRepositoryMock;

	@Before
	public void setUp() {
			
		 MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLogin() throws ServiceException {
		Users users=new Users();
		users.setEmail("chandra@gmail.com");
		users.setPassword("chandra");
		Mockito.when(usersRepositoryMock.login(anyString(),anyString())).thenReturn(users);
		Users user = usersServicesImpl.login("chandra@gmail.com","chandra");
		assertNotNull(user);
	}

	@Test
	public void testInsert() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckByMailId() {
		Users users=new Users();
		users.setEmail("chandra@gmail.com");
		Mockito.when(usersRepositoryMock.checkByMailId(anyString())).thenReturn(users);
		boolean result = usersServicesImpl.checkByMailId("chandra@gmail.com");
		assertTrue(result);
	}

	@Test
	public void testActivateAccount() {
		Users users=new Users();
		users.setEmail("chandra@gmail.com");
		Mockito.when(usersRepositoryMock.activateAccount(anyString(),anyInt(),anyString())).thenReturn(1);
		boolean result = usersServicesImpl.activateAccount(1,"chandra@gmail.com","chandra");
		assertTrue(result);
	}

	@Test
	public void testFindIdByMail() {
		Users users=new Users();
		users.setEmail("chandra@gmail.com");
		users.setId(1);
		Mockito.when(usersRepositoryMock.findIdByMail(anyString())).thenReturn(users);
		int result = usersServicesImpl.findIdByMail("chandra@gmail.com");
		assertEquals(1, result);
		}

	@Test
	public void testViewAllUsers() {
		List<Users> list = new ArrayList<Users>();
		Users users=new Users();
		users.setId(1);
		users.setEmail("chandra@gmail.com");
		list.add(users);
		Mockito.when(usersRepositoryMock.findAll()).thenReturn(list);
		list = usersServicesImpl.viewAllUsers();
		assertNotNull(list);
	}

}
