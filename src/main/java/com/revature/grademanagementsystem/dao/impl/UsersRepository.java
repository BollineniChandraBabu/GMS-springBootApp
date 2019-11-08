package com.revature.grademanagementsystem.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.revature.grademanagementsystem.model.Users;

@Transactional
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>
{
	@Query(value="select * from users as u, departments as d where u.department=d.id and email=:email and password=:password and active=1 and activeaccount=1", nativeQuery = true)
	Users login(@Param("email")String email,@Param("password") String password);

	
	@Query(value="select * from users where email=:email", nativeQuery = true)
	Users checkByMailId(@Param("email")String email);
	
	@Modifying
	@Query("update Users set password=:password ,activeaccount=1,active=1 where id=:id and email=:email")
	int activateAccount(@Param("email")String email,@Param("id") int id,@Param("password") String password);

	@Query(value="select * from users where email=:email", nativeQuery = true)
	Users findIdByMail(@Param("email")String email);
}


