package com.example.demo.Dto;

import java.time.LocalDateTime;

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
	private UserDto user;
	private UserDto doctor;
	private LocalDateTime time;
	private String symptom;
	private HeathDto heath;
}
