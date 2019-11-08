package com.revature.grademanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Departments;
import com.revature.grademanagementsystem.model.Users;
import com.revature.grademanagementsystem.services.impl.UsersServicesImpl;


@RestController
public class UsersController {
	
	@Autowired
	UsersServicesImpl userServices;

	@GetMapping("login")
	@ResponseStatus(code=HttpStatus.OK)
	public Users loginController(@RequestParam("email")String email, @RequestParam("password")String password) throws ServiceException {
		Users users=null;
			users = userServices.login(email, password);
		return users;
	}
	@GetMapping("addEmployee")
	@ResponseStatus(code=HttpStatus.OK)
	public int insertController(@RequestParam("name")String name, @RequestParam("fathername")String fathername, @RequestParam("email")String email, @RequestParam("department")String department) {
		int id = 0;
		 Users users=new Users();
		users.setName(name);
		users.setFatherName(fathername);
		users.setEmail(email);
		Departments departments = new Departments();
		departments.setId(Integer.parseInt(department));
		users.setDepartment(departments);
		id = userServices.insert(users);
		return id;
	}

	
	@GetMapping("activateEmployee")
	@ResponseStatus(code=HttpStatus.OK)
	public boolean activateAccount(@RequestParam("email") String email,@RequestParam("eid") int eid,@RequestParam("password") String password)  {
		return userServices.activateAccount(eid,email,password);
	}
	@GetMapping("checkEmail")
	@ResponseStatus(code=HttpStatus.OK)
		public boolean checkByMailId(@RequestParam("email")String mail) {
			return userServices.checkByMailId(mail);
			
		}
	@GetMapping("checkdetails")
	@ResponseStatus(code=HttpStatus.OK)
		public boolean findIdByMail(@RequestParam("eid") int eid,@RequestParam("email")String email) {
		boolean status = false;
			int id= userServices.findIdByMail(email);
			if(id==eid)
			{
				status= true;
			}
			return status;
		}
		@GetMapping("viewEmployees")
		@ResponseStatus(code=HttpStatus.OK)
		public  List<Users> viewAllUsers() {
			return userServices.viewAllUsers();
		}
}
