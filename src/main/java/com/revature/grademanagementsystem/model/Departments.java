package com.revature.grademanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="departments")
public class Departments {
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	 	private int id;
	 	@Column(name="name")
	 	private String name;
}
