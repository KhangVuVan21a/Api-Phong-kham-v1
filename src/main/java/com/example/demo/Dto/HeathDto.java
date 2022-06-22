package com.example.demo.Dto;

import java.time.LocalDate;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.TimeOder;
import com.example.demo.Entity.User;

import lombok.Data;

@Data
public class HeathDto {
	private int id;
	private String title;
	private String detail;
	private LocalDate updateAt;
}
