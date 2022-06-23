package com.example.demo.Dto;

import java.time.LocalDate;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.TimeOder;
import com.example.demo.Entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HeathDto {
	private int id;
	private String title;
	private String detail;
	private LocalDate updateAt;
	private UserDto user;
	private TimeOderDto timeOderDto;
	private DepartmentDto department;
}
