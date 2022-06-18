package com.example.demo.Dto;

import java.time.LocalDate;

import com.example.demo.Entity.User;

import lombok.Data;
@Data
public class TimeWorkDto {
	private int id;
	private LocalDate time;
	private User doctor;
	
}
