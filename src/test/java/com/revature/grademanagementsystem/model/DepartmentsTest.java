package com.revature.grademanagementsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class DepartmentsTest {
private Departments departments = new Departments();

	
	@Test
	public void testGetId() {
		departments.setId(1);
		assertEquals(1,departments.getId());
	}

	@Test
	public void testGetName() {
		departments.setName("ENGLISH");
		assertEquals("ENGLISH",departments.getName());
	}

	@Test
	public void testDepartments() {
		departments.setId(1);
		departments.setName("ENGLISH");
		assertNotNull(departments);
	}
	
	@Test
	public void testDepartmentsNull() {
		departments=null;
		assertNull(departments);
	}

	@Test
	public void testHashcode()
	{
		Departments departments1=new Departments();
		assertTrue( departments.hashCode()==departments1.hashCode() );
	}
	
	@Test
	public void canEqualTest() 
	{
		Departments departments1=new Departments();
	    assertTrue(departments.canEqual(departments1));
	}
	
	@Test
	public void EqualTest() 
	{
		Departments departments1=new Departments();
	    assertTrue(departments.equals(departments1));
	}
	
}
