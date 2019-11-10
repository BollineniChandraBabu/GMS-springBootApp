package com.revature.grademanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import com.revature.grademanagementsystem.model.Marks;
import com.revature.grademanagementsystem.model.Students;
import com.revature.grademanagementsystem.model.Subjects;
import com.revature.grademanagementsystem.services.impl.MarksServicesImpl;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class MarksControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MarksServicesImpl marksServiceMock;
	@InjectMocks
	MarksControllerTest marksControllerTest;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testFindMaxMarks() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.findMaxMarks()).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksList);
		mockMvc.perform(get("/viewtop").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testViewAllMarks() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.findMaxMarks()).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksList);
		mockMvc.perform(get("/viewallmarks").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testInsertOrUpdate() throws Exception {
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		when(marksServiceMock.insertOrUpdate(marksObj)).thenReturn(true);
		String userJson = new ObjectMapper().writeValueAsString(marksObj);
		mockMvc.perform(get("/viewallmarks").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testViewBySubjectCode() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.viewBySubjectCode(anyInt())).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksObj);
		mockMvc.perform(get("/viewBySubjectCode?subjectdetails=1").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testViewBySubjectName() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.viewBySubjectCode(anyInt())).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksObj);
		mockMvc.perform(get("/viewBySubjectName?subjectdetails=eng").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testGetMarksByGrade() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.viewMarksByGrade("A")).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksObj);
		mockMvc.perform(get("/viewByGrade?grade=A").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testViewStudentMarks() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.viewStudentMarks(anyInt())).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksObj);
		mockMvc.perform(get("/viewStudentMarks?studentid=1").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testViewBySubject() throws Exception {
		List<Marks> marksList=new ArrayList<Marks>();
		Marks marksObj = new Marks();
		marksObj.setId(1);
		marksObj.setMarks(85);
		Students student=new Students();
		student.setRegistrationNumber(1);
		student.setName("tester");
		marksObj.setStudent(student);
		Subjects subjects=new Subjects();
		subjects.setName("english");
		marksObj.setSubjects(subjects);
		marksList.add(marksObj);
		when(marksServiceMock.viewStudentMarks(anyInt())).thenReturn(marksList);
		String userJson = new ObjectMapper().writeValueAsString(marksObj);
		mockMvc.perform(get("/viewBySubject?subjectdetails=1").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

}
