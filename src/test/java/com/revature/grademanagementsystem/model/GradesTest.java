package com.revature.grademanagementsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GradesTest {
private Grades grades=new Grades();
private Grades grades1=new Grades();
	@Test
	public void testGetGrade() {
		grades.setGrade("A");
		assertEquals("A",grades.getGrade());
	}

	@Test
	public void testGetMinMark() {
		grades.setMinMark(80);
		assertEquals(80,grades.getMinMark());
		}

	@Test
	public void testGetMaxMark() {
		grades.setMaxMark(90);
		assertEquals(90,grades.getMaxMark());
		}


	@Test
	public void testGrades() {
		assertNotNull(grades);
	}
	@Test
	public void testHashcode()
	{
		assertTrue( grades.hashCode()==grades1.hashCode() );
	}
	
	@Test
	public void canEqualTest() 
	{
	    assertTrue(grades.canEqual(grades1));
	}
	
	@Test
	public void EqualTest() 
	{
	    assertTrue(grades.equals(grades1));
	}
}
