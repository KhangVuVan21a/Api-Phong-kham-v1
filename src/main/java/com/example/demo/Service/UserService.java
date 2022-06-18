package com.example.demo.Service;

import java.util.List;

import javax.validation.constraints.Email;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserDto;

public interface UserService {
	UserDto userLogin(LoginDto input);
	UserDto userRegister(RegisterDto input);
	boolean isCheckEmail(@Email String email);
	boolean isCheckUserName(String userName);
	UserDto updateUser(UserDto userDto);
	List<UserDto> getAllUser();
	
}
