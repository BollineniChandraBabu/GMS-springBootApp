package com.revature.grademanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.grademanagementsystem.configuration.Message;
import com.revature.grademanagementsystem.configuration.MessageConstants;
import com.revature.grademanagementsystem.model.Subjects;
import com.revature.grademanagementsystem.services.impl.SubjectsServicesImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SubjectsController {

	@Autowired
	SubjectsServicesImpl subjectsServices;
	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectsController.class);

	@GetMapping("viewAvailableSubjects")
	@ApiOperation("view Available Subjects")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "viewing Available Subjects", response = Message.class),
			@ApiResponse(code = 400, message = "unable view Available Subjects", response = Message.class) })
	public ResponseEntity<Object> viewSubjects() {
		List<Subjects> subjectsList = new ArrayList<Subjects>();
		try {
			subjectsList = subjectsServices.viewSubjects();
			if (subjectsList.isEmpty()) {
				Message message = new Message(MessageConstants.SUBJECTS_NOT_AVAILABLE);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(subjectsList, HttpStatus.OK);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("checkSubject")
	@ApiOperation("check Subject")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "viewing Available Subjects", response = Message.class),
			@ApiResponse(code = 400, message = "unable view Available Subjects", response = Message.class) })
	public ResponseEntity<Object> getBySubjectCode(@RequestParam("subjectdetails") int subjectid) {
		Subjects subjects = new Subjects();
		try {
			subjects = subjectsServices.getBySubjectCode(subjectid);
			if (subjects == null) {
				Message message = new Message(MessageConstants.SUBJECT_NOT_AVAILABLE);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(subjects, HttpStatus.OK);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

}
