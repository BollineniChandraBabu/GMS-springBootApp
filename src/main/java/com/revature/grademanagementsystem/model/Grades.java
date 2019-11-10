package com.revature.grademanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "grades")
public class Grades {
	@Id
	@Column(name = "grade")
	private String grade;
	@Column(name = "minMark")
	private int minMark;
	@Column(name = "maxMark")
	private int maxMark;

}
