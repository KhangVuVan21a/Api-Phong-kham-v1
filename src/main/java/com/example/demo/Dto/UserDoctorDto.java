package com.example.demo.Dto;

import java.time.LocalDate;
import java.util.Date;

import com.example.demo.Entity.Department;

import lombok.Data;
@Data
public class UserDoctorDto {
	private int id;
	private String fullName;
	private LocalDate birth;
	private boolean sex;
	private String email;
	private String address;
	private String phoneNumber;
	private DepartmentDto department;
}
