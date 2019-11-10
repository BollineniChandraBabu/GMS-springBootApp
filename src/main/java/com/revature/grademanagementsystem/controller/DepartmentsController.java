package com.revature.grademanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.grademanagementsystem.configuration.Message;
import com.revature.grademanagementsystem.configuration.MessageConstants;
import com.revature.grademanagementsystem.model.Departments;
import com.revature.grademanagementsystem.services.impl.DepartmentsServicesImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DepartmentsController {
	@Autowired
	DepartmentsServicesImpl departmentsServices;
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentsController.class);

	@GetMapping("viewDepartments")
	@ApiOperation("View Departments")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "employee details available", response = Message.class),
			@ApiResponse(code = 400, message = "unable to view employees details", response = Message.class) })
	public ResponseEntity<Object> viewDepartments() {
		List<Departments> departmentsList = null;
		try {
			departmentsList = departmentsServices.viewDepartments();
			if (departmentsList.isEmpty()) {
				Message message = new Message(MessageConstants.UNABLE_TO_VIEW_DEPARTMENTS);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(departmentsList, HttpStatus.OK);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("checkDepartment")
	@ApiOperation("View Departments")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "employee details available", response = Message.class),
			@ApiResponse(code = 400, message = "unable to view employees details", response = Message.class) })
	public ResponseEntity<Object> checkDepartment(@RequestParam("department") int department) {
		try {
			boolean status = departmentsServices.checkDepartment(department);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
