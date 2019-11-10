package com.revature.grademanagementsystem.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.grademanagementsystem.model.Subjects;

@Transactional
@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
	@Query(value = "select * from subjects where id=:id", nativeQuery = true)
	Subjects checkSubjectCode(@Param("id") int id);

	@Query(value = "select * from subjects order by id", nativeQuery = true)
	List<Subjects> viewSubjects();

	@Query(value = "select id,name from subjects where name like :subjectName", nativeQuery = true)
	Subjects checkSubjectName(@Param("subjectName") String subjectName);

	@Query(value = "select id,name from subjects where id=? order by id", nativeQuery = true)
	Subjects getBySubjectCode(@Param("subjectid") int subjectid);
}
