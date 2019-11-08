package com.revature.grademanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.revature.grademanagementsystem.model.Subjects;
import com.revature.grademanagementsystem.services.impl.SubjectsServicesImpl;




@RestController
public class SubjectsController {

@Autowired
SubjectsServicesImpl subjectsServices;

	public boolean checkSubjectCode(int subjectCode) {
		return subjectsServices.checkSubjectCode(subjectCode);
		
	}
	@GetMapping("viewAvailableSubjects")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Subjects> viewSubjects() {
		return subjectsServices.viewSubjects();	
	}
	public boolean checkSubjectName(String subjectName) {
		
		return subjectsServices.checkSubjectName(subjectName);
		
	}
	
	
	@GetMapping("checkSubject")
	@ResponseStatus(code=HttpStatus.OK)
	public Object getBySubjectCode(@RequestParam("subjectdetails")int subjectid) {
		return subjectsServices.getBySubjectCode(subjectid);
	}
	

}
