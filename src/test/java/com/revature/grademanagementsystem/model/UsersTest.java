package com.revature.grademanagementsystem.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;

public class UsersTest {
	private Users user = new Users();
	@Test
	public void testGetId() {	
		user.setId(1);
		assertEquals(1,user.getId());
	}

	@Test
	public void testGetName() {
		user.setName("chandra");
		assertEquals( "chandra",user.getName());
	}

	@Test
	public void testGetFatherName() {
		user.setFatherName("chandra");
		assertEquals("chandra",user.getFatherName());
	}

	@Test
	public void testGetEmail() {
		user.setEmail("chandra@gmail.com");
		assertEquals( "chandra@gmail.com",user.getEmail());
	}

	@Test
	public void testGetPassword() {
		user.setPassword("password@123");
		assertEquals("password@123",user.getPassword());
	}

	@Test
	public void testIsRoles() {
		user.setRoles(true);
		assertEquals(true,user.isRoles());
	}

	@Test
	public void testGetDateOfJoining() {
		LocalDate d=LocalDate.now();
		user.setDateOfJoining(d);
		assertEquals(user.getDateOfJoining(), d);
	}

	@Test
	public void testGetDepartment() {
		Departments departments=new Departments();
		departments.setId(1);
		user.setDepartment(departments);
		assertEquals(user.getDepartment(), departments);
	}

	@Test
	public void testIsActive() {
		user.setActive(true);
		assertEquals(true,user.isActive());
	}

	@Test
	public void testIsActiveAccount() {
		user.setActiveAccount(true);
		assertEquals(true,user.isActiveAccount());
	}
	@Test
	public void testUsers() {
		assertNotNull(user);
	}
}
