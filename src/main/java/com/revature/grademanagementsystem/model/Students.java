package com.revature.grademanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "regno")
	private int registrationNumber;
	@Column(name = "name")
	private String name;
	@Column(name = "fatherName")
	private String fatherName;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department")
	private Departments department;
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	@Column(name = "Address")
	private String Address;
	@Column(name = "active")
	private boolean active;
}
