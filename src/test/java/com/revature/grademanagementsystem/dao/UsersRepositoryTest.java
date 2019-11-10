package com.revature.grademanagementsystem.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.grademanagementsystem.dao.impl.UsersRepository;
import com.revature.grademanagementsystem.model.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {
	@Autowired
	private UsersRepository usersRepository;

	@Test
	public void loginValidTest() {
		Users users = usersRepository.login("cs@gmail.com", "95cc64dd2825f9df13ec4ad683ecf339");
		assertNotNull(users);
	}

	@Test
	public void loginInValidTest() {
		Users users = usersRepository.login("chandra@gmail.com", "CHandra");
		assertNull(users);
	}

	@Test
	public void checkByMailIdValidTest() {
		Users users = usersRepository.checkByMailId("cs@gmail.com");
		assertNotNull(users);
	}

	@Test
	public void checkByMailIdInValidTest() {
		Users users = usersRepository.checkByMailId("fgfgfg@gmail.com");
		assertNull(users);
	}

	@Test
	public void activateAccountValidTest() {
		int result = usersRepository.activateAccount("cs@gmail.com", 1, "95cc64dd2825f9df13ec4ad683ecf339");
		assertEquals(1, result);
	}

	@Test
	public void activateAccountInValidTest() {
		int result = usersRepository.activateAccount("fgfdgg@gmail.com", 1, "chandra");
		assertEquals(0, result);
	}

}
