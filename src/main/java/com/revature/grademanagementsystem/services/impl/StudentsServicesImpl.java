package com.revature.grademanagementsystem.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.grademanagementsystem.dao.impl.StudentsRepository;
import com.revature.grademanagementsystem.exception.DBException;
import com.revature.grademanagementsystem.model.Students;

@Service
public class StudentsServicesImpl {
	@Autowired
	private StudentsRepository studentsRepository;

	@Transactional
	public List<Students> getStudents() {
		return studentsRepository.findAll();
	}

	@Transactional
	public Students checkStudentById(int studentId) {
		return studentsRepository.checkStudentById(studentId);
	}

	@Transactional
	public int insert(Students students) {
		try {
			students = studentsRepository.save(students);
		} catch (Exception e) {
			throw new DBException("Unable to Save");
		}
		return students.getRegistrationNumber();
	}
}
