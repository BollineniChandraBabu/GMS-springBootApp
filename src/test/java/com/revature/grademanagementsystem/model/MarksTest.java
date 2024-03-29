package com.revature.grademanagementsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarksTest {
	private Marks marks =new Marks();
	private Marks marks1 =new Marks();
	@Test
	public void testGetId() {	
		marks.setId(1);
		assertEquals(1, marks.getId());
	}

	@Test
	public void testGetStudent() {
Students student=new Students();
marks.setStudent(student);
assertEquals(student,marks.getStudent());
	}

	@Test
	public void testGetSubjects() {
Subjects subjects=new Subjects();
marks.setSubjects(subjects);
assertEquals(subjects,marks.getSubjects());
	}

	@Test
	public void testGetMarks() {
marks.setMarks(80);
assertEquals(80,marks.getMarks());
	}

	@Test
	public void testMarks() {
assertNotNull(marks);
	}
	@Test
	public void testHashcode()
	{
		assertTrue( marks.hashCode()==marks1.hashCode() );
	}
	
	@Test
	public void canEqualTest() 
	{
	    assertTrue(marks.canEqual(marks1));
	}
	
	@Test
	public void EqualTest() 
	{
	    assertTrue(marks.equals(marks1));
	}
}
