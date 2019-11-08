package com.revature.grademanagementsystem.services.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.grademanagementsystem.dao.impl.UsersRepository;
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Users;

@Service
public class UsersServicesImpl  {
	@Autowired
	private UsersRepository usersRepository;
	@Transactional
	public Users login(String email, String password) throws ServiceException {
		Users users= null;
		try {
			users = usersRepository.login(email,password);
		} catch (Exception e) {
			System.out.println("error"+e.getMessage());
			throw new ServiceException("Unable to login");	
		}
		return users;
	}
	@Transactional
	public int insert(Users users) {
		int id = 0;
		   LocalDate now = LocalDate.now();  
		users.setDateOfJoining(now);
		users.setPassword("NA");
		 users = usersRepository.save(users);
	        if(users!=null) {
	        id= users.getId();
	}
	        return id;
	        }
	
	@Transactional
	public boolean checkByMailId(String mailId)
	{boolean result=false;
			Users users = usersRepository.checkByMailId(mailId);
			if(users!=null) 
			{
				result=true;
			}
		
		return result;
	}
	
	@Transactional
	public boolean activateAccount(int id, String mail, String password) {
		boolean result=false;
		int rows= usersRepository.activateAccount(mail,id,password);
		if(rows!=0) 
		{
			result=true;
		}
		return result;
	}
	@Transactional
	public int findIdByMail(String string) {
		Users users =usersRepository.findIdByMail(string);
		return users.getId();
	}
	@Transactional
	public  List<Users> viewAllUsers() {
		return usersRepository.findAll();
	}
	
}
