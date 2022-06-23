package com.example.demo.Dto;

import java.time.LocalDate;

import com.example.demo.Entity.Heath;
import com.example.demo.Entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TimeOderDto {
	private int id;
	//private UserDto user;
	//private UserDto doctor;
	private LocalDate time;
	private String symptom;
	private LocalDate updateAt;
	//private HeathDto heath;
}
