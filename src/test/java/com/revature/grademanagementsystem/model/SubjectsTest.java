package com.revature.grademanagementsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubjectsTest {
	private Subjects subjects=new Subjects();
	private Subjects subjects1=new Subjects();

	@Test
	public void testGetId() {
subjects.setId(1);
assertEquals(1, subjects.getId());
	}

	@Test
	public void testGetName() {
subjects.setName("test");
assertEquals("test",subjects.getName());
	}

	@Test
	public void testSubjects() {
		assertNotNull(subjects);
	}
	@Test
	public void testHashcode()
	{
		assertTrue( subjects.hashCode()==subjects1.hashCode() );
	}
	
	@Test
	public void canEqualTest() 
	{
	    assertTrue(subjects.canEqual(subjects1));
	}
	
	@Test
	public void EqualTest() 
	{
	    assertTrue(subjects.equals(subjects1));
	}
}
