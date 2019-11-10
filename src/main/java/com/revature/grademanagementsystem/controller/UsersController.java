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
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Departments;
import com.revature.grademanagementsystem.model.Users;
import com.revature.grademanagementsystem.services.impl.UsersServicesImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
public class UsersController {
	@Autowired
	UsersServicesImpl userServices;
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

	@GetMapping("login")
	@ApiOperation("login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Login success", response = Message.class),
			@ApiResponse(code = 400, message = "unable to login", response = Message.class) })
	public ResponseEntity<Object> loginController(@RequestParam("email") String email,
			@RequestParam("password") String password) throws ServiceException {
		Users users = null;
		try {
			users = userServices.login(email, password);
			if (users != null) {
				return new ResponseEntity<>(users, HttpStatus.OK);
			} else {
				Message message = new Message(MessageConstants.INVALID_EMAIL_OR_PASSWORD);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("addEmployee")
	@ApiOperation("Add Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully added", response = Message.class),
			@ApiResponse(code = 400, message = "unable to add employee", response = Message.class) })
	public ResponseEntity<Object> insertController(@RequestParam("name") String name,
			@RequestParam("fathername") String fathername, @RequestParam("email") String email,
			@RequestParam("department") String department) {
		try {
			int id = 0;
			Users users = new Users();
			users.setName(name);
			users.setFatherName(fathername);
			users.setEmail(email);
			Departments departments = new Departments();
			departments.setId(Integer.parseInt(department));
			users.setDepartment(departments);
			id = userServices.insert(users);
			if (id != 0) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("activateEmployee")
	@ApiOperation("Activate Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully activated", response = Message.class),
			@ApiResponse(code = 400, message = "unable to activate", response = Message.class) })
	public ResponseEntity<Object> activateAccount(@RequestParam("email") String email, @RequestParam("eid") int eid,
			@RequestParam("password") String password) {
		try {
			boolean status = userServices.activateAccount(eid, email, password);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("checkEmail")
	@ApiOperation("check Email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "email id exist", response = Message.class),
			@ApiResponse(code = 400, message = "unable to search", response = Message.class) })
	public ResponseEntity<Object> checkByMailId(@RequestParam("email") String mail) {
		try {
			boolean status = userServices.checkByMailId(mail);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("checkdetails")
	@ApiOperation("check details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "employee details available", response = Message.class),
			@ApiResponse(code = 400, message = "unable to search employees details", response = Message.class) })
	public ResponseEntity<Object> findIdByMail(@RequestParam("eid") int eid, @RequestParam("email") String email) {
		try {
			int id = userServices.findIdByMail(email);
			if (id == eid) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * viewEmployees
	 * 
	 * @return employees if exist or else employee details not available.
	 **/
	@GetMapping("viewEmployees")
	@ApiOperation("View Employees")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully viewed employees details", response = Message.class),
			@ApiResponse(code = 400, message = "unable to view employees details", response = Message.class) })
	public ResponseEntity<Object> viewAllUsers() {
		List<Users> usersList = null;
		try {
			usersList = userServices.viewAllUsers();
			if (usersList.isEmpty()) {
				Message message = new Message(MessageConstants.UNABLE_TO_LIST_EMPLOYEES);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(usersList, HttpStatus.OK);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

}
