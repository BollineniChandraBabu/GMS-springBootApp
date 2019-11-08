package com.revature.grademanagementsystem.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.revature.grademanagementsystem.model.Marks;

@Transactional
@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

	@Query(value="select * from marks as m, subjects as s,students as st where st.regno=m.sid and m.subid=s.id and st.regno=:id order by m.subid asc",nativeQuery=true)
	List<Marks> getMarksById(@Param("id")int id);
	
	
	@Query(value="select avg(marks) as average from marks where sid=:id",nativeQuery = true)
	int getAverage(@Param("id")int id);
	
	
	@Query(value="select sid from marks group by sid order by avg(marks) desc",nativeQuery = true)
	List<?> getMaxAverage() ;
	
	@Query(value="select * from marks as m, subjects as s,students as st where s.id=:subjectCode and st.regno=m.sid and m.subid=s.id group by m.sid,s.name",nativeQuery = true)
	List<Marks> viewBySubjectCode(@Param("subjectCode")int subjectCode);
	
	
	@Query(value="select * from marks as m, subjects as s,students as st where s.name like :subjectName% and st.regno=m.sid and m.subid=s.id group by m.sid,s.name",nativeQuery=true)
	List<Marks> viewBySubjectName(@Param("subjectName")String subjectName);
	
	
	@Query(value="select * from marks as m,students as st,subjects as s where m.id=st.regno and m.subid=s.id and st.regno=:studentId and m.subid=:subjectId",nativeQuery = true)
	Marks checkAvailability(@Param("studentId")int studentId,@Param("subjectId")int subjectId);


	@Query(value="from Marks m where m.id=:subjectId")
	List<Marks> checkSubjectById(@Param("subjectId") int subjectId);
	
}
