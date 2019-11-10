package com.revature.grademanagementsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentsTest {
	private Students students=new Students();
	private Students students1=new Students();

	@Test
	public void testGetRegistrationNumber() {
		students.setRegistrationNumber(1);
		assertEquals(1,students.getRegistrationNumber());
	}

	@Test
	public void testGetName() {
students.setName("test");
assertEquals("test", students.getName());
	}

	@Test
	public void testGetFatherName() {
students.setFatherName("testing");
assertEquals("testing", students.getFatherName());
	}

	@Test
	public void testGetDepartment() {
		Departments departments=new Departments();
		departments.setId(1);
		departments.setName("ENGLISH");
		students.setDepartment(departments);
		assertEquals(students.getDepartment(),departments);
	}

	@Test
	public void testGetDateOfBirth() {
students.setDateOfBirth("12/10/2014");
assertEquals("12/10/2014", students.getDateOfBirth());
	}

	@Test
	public void testGetAddress() {
students.setAddress("location");
assertEquals("location",students.getAddress());
	}

	@Test
	public void testIsActive() {
students.setActive(true);
assertEquals(true, students.isActive());
	}

	@Test
	public void testStudents() {
		assertNotNull(students);
	}
	@Test
	public void testHashcode()
	{
		assertTrue( students.hashCode()==students1.hashCode() );
	}
	
	@Test
	public void canEqualTest() 
	{
	    assertTrue(students.canEqual(students1));
	}
	
	@Test
	public void EqualTest() 
	{
	    assertTrue(students.equals(students1));
	}
}
