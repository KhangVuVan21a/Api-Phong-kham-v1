package com.example.demo.Dto;

import java.time.LocalDate;
import java.util.Date;

import com.example.demo.Entity.Department;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class UserDto {
	private int id;
	private String username;
	private String password;
	private String fullName;
	private LocalDate birth;
	private boolean sex;
	private String email;
	private String address;
	private String phoneNumber;
	//private DepartmentDto department;
	private int level;
}
