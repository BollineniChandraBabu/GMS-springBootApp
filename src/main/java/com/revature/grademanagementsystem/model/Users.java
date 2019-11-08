package com.revature.grademanagementsystem.model;

import java.time.LocalDate;
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
@Table(name="users")
public class Users {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
private int id;
	 @Column(name="name")
private String name;
	 @Column(name="fatherName")
private String fatherName;
	 @Column(name="email")
private String email;
	 @Column(name="password")
private String password;
	 @Column(name="roles")
private boolean roles;
	 @Column(name="dateOfJoining")
private LocalDate dateOfJoining;
	 
	 @OneToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "department")
private Departments department;
@Column(name="active")
private boolean active;
@Column(name="activeAccount")
private boolean activeAccount;
}
