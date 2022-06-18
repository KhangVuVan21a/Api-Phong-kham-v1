package com.example.demo.Dto;

import java.time.LocalDate;

import com.example.demo.Entity.Heath;
import com.example.demo.Entity.User;

import lombok.Data;

@Data
public class TimeOderDto {
	private int id;
	private User user;
	private User doctor;
	private LocalDate time;
	private String symptom;
	private LocalDate updateAt;
	private Heath heath;
}
