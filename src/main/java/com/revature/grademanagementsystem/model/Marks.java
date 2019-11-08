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
@Table(name = "marks")
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sid")
	private Students student;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subid")
	private Subjects subjects;
	@Column(name = "marks")
	private int marks;
}
