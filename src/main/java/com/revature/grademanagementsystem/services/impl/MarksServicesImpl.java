package com.revature.grademanagementsystem.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.grademanagementsystem.dao.impl.MarksRepository;
import com.revature.grademanagementsystem.exception.DBException;
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Marks;
import com.revature.grademanagementsystem.model.Students;

@Service
public class MarksServicesImpl {
	@Autowired
	private MarksRepository marksRepository;
	@Autowired
	private GradesServicesImpl gradesServices;

	@Transactional
	public List<Marks> viewStudentMarks(int studentId) {
		return marksRepository.getMarksById(studentId);
	}

	@Transactional
	public List<Marks> findMaxMarks() {
		List<?> list = marksRepository.getMaxAverage();
		int studentId = (Integer) list.get(0);
		return marksRepository.getMarksById(studentId);
	}

	@Transactional
	public List<Marks> viewAllMarks() {
		return marksRepository.findAll();
	}

	@Transactional
	public List<Marks> viewMarksByGrade(String grade) throws ServiceException {
		List<Marks> marksList = null;
		StudentsServicesImpl studentServices = new StudentsServicesImpl();
		try {
			List<Students> studentsList = studentServices.getStudents();
			for (Students students : studentsList) {
				int average = marksRepository.getAverage(students.getRegistrationNumber());
				String grade1 = gradesServices.getGrade(average);
				if (grade1.equals(grade)) {
					marksList = marksRepository.getMarksById(students.getRegistrationNumber());

				}
			}
		} catch (DBException e) {
			throw new ServiceException("Unable to View" + e);

		}
		return marksList;
	}

	@Transactional
	public Marks checkAvailability(int studentId, int subjectId) {
		return marksRepository.checkAvailability(studentId, subjectId);
	}

	@Transactional
	public boolean insertOrUpdate(Marks marks) {
		boolean result = false;
		Marks mark = null;
		try {
			mark = marksRepository.save(marks);
		} catch (Exception e) {
			mark = null;
		}
		if (mark != null) {
			result = true;
		}

		return result;
	}

	@Transactional
	public List<Marks> viewBySubjectCode(int subjectCode) {
		return marksRepository.viewBySubjectCode(subjectCode);
	}

	@Transactional
	public List<Marks> viewBySubjectName(String subjectName) {
		return marksRepository.viewBySubjectName(subjectName);
	}

	@Transactional
	public boolean checkSubjectById(int subjectId) {
		boolean result = false;
		List<Marks> marks = marksRepository.checkSubjectById(subjectId);
		if (!marks.isEmpty()) {
			result = true;
		}
		return result;
	}

}
