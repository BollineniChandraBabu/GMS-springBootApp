package com.revature.grademanagementsystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.grademanagementsystem.dao.impl.SubjectsRepository;
import com.revature.grademanagementsystem.model.Subjects;



@Service
public class SubjectsServicesImpl {
	@Autowired
	private SubjectsRepository subjectsRepository;
	@Transactional
	public boolean checkSubjectCode(int subjectCode) {
		boolean result = false;
		Subjects subjects= subjectsRepository.checkSubjectCode(subjectCode);
		if(subjects!=null) 
		{
			result=true;
		}
		return result;
	}
	@Transactional
	public List<Subjects> viewSubjects() {
		return subjectsRepository.viewSubjects();
	}
	@Transactional
	public boolean checkSubjectName(String subjectName) {
		boolean result=false;
		Subjects subjects=subjectsRepository.checkSubjectName(subjectName);
		if(subjects!=null)
		{
			result=true;
		}
		return result;
	}
	@Transactional
	public Object getBySubjectCode(int subjectid) {
		return subjectsRepository.getBySubjectCode(subjectid);
	}

}
