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
import com.revature.grademanagementsystem.exception.ServiceException;
import com.revature.grademanagementsystem.model.Grades;
import com.revature.grademanagementsystem.services.impl.GradesServicesImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GradesController {
	@Autowired
	GradesServicesImpl gradesServices;
	private static final Logger LOGGER = LoggerFactory.getLogger(GradesController.class);

	@GetMapping("viewgrade")
	@ApiOperation("view grades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "viewing grades", response = Message.class),
			@ApiResponse(code = 400, message = "unable view grades", response = Message.class) })
	public ResponseEntity<Object> viewGrades() throws ServiceException {
		List<Grades> gradesList = new ArrayList<Grades>();
		try {
			gradesList = gradesServices.viewGrades();
			if (gradesList.isEmpty()) {
				Message message = new Message(MessageConstants.UNABLE_TO_LIST_GRADES);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(gradesList, HttpStatus.OK);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("updateGrade")
	@ApiOperation("update grades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully updated grades", response = Message.class),
			@ApiResponse(code = 400, message = "unable update grades", response = Message.class) })
	public ResponseEntity<Object> updateGradeRange(@RequestParam("grade") String grade,
			@RequestParam("minimummark") int minimummark, @RequestParam("maximummark") int maximummark) {
		try {
			Grades grades = new Grades();
			grades.setGrade(grade);
			grades.setMinMark(minimummark);
			grades.setMaxMark(maximummark);
			boolean status = gradesServices.updateGradeRange(grades);
			return new ResponseEntity<>(status, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("getGrade")
	@ApiOperation("update grades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully updated grades", response = Message.class),
			@ApiResponse(code = 400, message = "unable update grades", response = Message.class) })
	public ResponseEntity<Object> getGrade(@RequestParam("average") int average) {
		try {
			String grade = gradesServices.getGrade(average);
			if (grade != null) {
				return new ResponseEntity<>(grade, HttpStatus.OK);
			} else {
				Message message = new Message(MessageConstants.GRADE_NOT_AVAILABLE);
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			Message message = new Message(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

}
