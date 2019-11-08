package com.revature.grademanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.grademanagementsystem.model.Departments;
import com.revature.grademanagementsystem.services.impl.DepartmentsServicesImpl;



@RestController
public class DepartmentsController {
	@Autowired
	DepartmentsServicesImpl departmentsServices;
	
	@GetMapping("viewDepartments")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Departments> viewDepartments()
	{
	return	departmentsServices.viewDepartments();
	}
	@GetMapping("checkDepartment")
	@ResponseStatus(code=HttpStatus.OK)
	public boolean checkDepartment(@RequestParam("department") int department)
	{
		return departmentsServices.checkDepartment(department);
	}
}
