package com.revature.grademanagementsystem.dto;


import lombok.Data;

@Data
public class MarksDTO {
private int registrationNumber;
private String name;
private String fatherName;
private String department;
private String dateOfBirth;
private boolean active;
private SubjectsDTO subjects;
}
