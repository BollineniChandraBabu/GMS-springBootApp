package com.revature.grademanagementsystem.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.grademanagementsystem.dao.impl.GradesRepository;
import com.revature.grademanagementsystem.exception.DBException;
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Grades;

@Service
public class GradesServicesImpl {
	@Autowired
	private GradesRepository gradesRepository;

	@Transactional
	public List<Grades> viewGrades() throws ServiceException {
		List<Grades> gradesList = null;
		try {
			gradesList = gradesRepository.findAll(Sort.by(Sort.Direction.ASC, "grade"));
		} catch (DBException e) {
			throw new ServiceException("Unable to view");
		}
		return gradesList;
	}

	public boolean checkGradeAvailability(char grade) throws ServiceException {
		boolean result = false;
		try {
			Grades grades = gradesRepository.checkGradeAvailability(grade);
			if (grades != null) {
				result = true;
			}
		} catch (DBException e) {
			throw new ServiceException("Unable to view");
		}
		return result;
	}

	public boolean updateGradeRange(Grades grades) {
		boolean result = false;
		Grades rows = null;
		rows = gradesRepository.save(grades);
		if (rows != null) {
			result = true;
		}
		return result;
	}

	public String getGrade(int mark) {
		Grades grade = gradesRepository.getGrade(mark);
		return grade.getGrade();
	}

}
