package com.revature.grademanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Grades;
import com.revature.grademanagementsystem.services.impl.GradesServicesImpl;

@RestController
public class GradesController {
	@Autowired
	GradesServicesImpl gradesServices;
	

	@GetMapping("viewgrade")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Grades> viewGrades() throws ServiceException
	{
		return gradesServices.viewGrades();
	}
	public boolean checkGradeAvailability(char grade) throws ServiceException {
		return gradesServices.checkGradeAvailability(grade);
	}
	
	@GetMapping("updateGrade")
	@ResponseStatus(code=HttpStatus.OK)
	public boolean updateGradeRange(@RequestParam("grade") String grade,@RequestParam("minimummark") int minimummark,@RequestParam("maximummark") int maximummark)  {
		Grades grades=new Grades();
		grades.setGrade(grade);
		grades.setMinMark(minimummark);
		grades.setMaxMark(maximummark);
	return	gradesServices.updateGradeRange(grades);
	}
	
	@GetMapping("getGrade")
	@ResponseStatus(code=HttpStatus.OK)
	public String getGrade(@RequestParam("average")int average)
	{
		return gradesServices.getGrade(average);
	}
		
	}

