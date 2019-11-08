package com.revature.grademanagementsystem.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.grademanagementsystem.model.Departments;

@Transactional
@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
	@Query(value="select * from departments order by id", nativeQuery = true)
	List<Departments> viewDepartments();
	@Query(value="select id,name from departments where id=:id",nativeQuery = true)
	Departments checkDepartment(@Param("id")int id);
}
