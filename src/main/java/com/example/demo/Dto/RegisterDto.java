package com.example.demo.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RegisterDto extends LoginDto {
	@Email
	//@NotEmpty(message = "Email not empty!")
	private String email;
	@NotEmpty(message = "level not empty!")
	private int level;
}
