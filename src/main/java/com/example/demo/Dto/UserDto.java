package com.example.demo.Dto;

import java.time.LocalDate;
import java.util.Date;

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
	private Date birth;
	private boolean sex;
	private String email;
	private String address;
	private String phoneNumber;
	private int departmantId;
	private int level;
	private LocalDate updateAt;
}