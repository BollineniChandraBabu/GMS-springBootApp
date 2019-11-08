package com.revature.grademanagementsystem.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.grademanagementsystem.model.Grades;

@Transactional
@Repository
public interface GradesRepository extends JpaRepository<Grades, String>  {
	@Query(value="select * from grades where :mark between minmark and maxmark",nativeQuery = true)
	Grades getGrade(@Param("mark")int mark);
	
	@Query(value="select * from grades where grade=:grade",nativeQuery = true)
	Grades checkGradeAvailability(@Param("grade")char grade);
}
