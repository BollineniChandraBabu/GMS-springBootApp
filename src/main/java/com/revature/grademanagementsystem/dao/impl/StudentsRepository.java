package com.revature.grademanagementsystem.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.grademanagementsystem.model.Students;
@Transactional
@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer>{
	
	
	@Query(value="select s.regno,s.name,s.fathername,d.id,d.name,s.dateofbirth,s.address,s.active from students as s, departments as d where s.regno=? and s.department=d.id order by s.regno",nativeQuery=true)
	Students checkStudentById(int studentId);
	
}
