package com.example.demo.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class LoginDto {
	@NotEmpty(message = "User name not empty!")
	private String userName;
	@Size(min = 6,max = 30)
	private String password;
	
}
