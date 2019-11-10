package com.revature.grademanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.grademanagementsystem.model.Departments;
import com.revature.grademanagementsystem.model.Students;
import com.revature.grademanagementsystem.services.impl.StudentsServicesImpl;

@RestController

public class StudentsController {
	@Autowired
	StudentsServicesImpl studentServices;

	@GetMapping("addStudent")
	@ResponseStatus(code = HttpStatus.OK)
	public int insert(@RequestParam("name") String name, @RequestParam("fathername") String fathername,
			@RequestParam("address") String address, @RequestParam("dob") String dob,
			@RequestParam("department") Integer department) {
		Students students = new Students();
		students.setName(name);
		students.setFatherName(fathername);
		students.setAddress(address);
		students.setDateOfBirth(dob);
		Departments departments = new Departments();
		departments.setId(department);
		students.setDepartment(departments);
		return studentServices.insert(students);
	}

	@GetMapping("viewStudents")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Students> viewStudents() {
		return studentServices.getStudents();
	}

}
