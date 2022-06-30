package com.example.demo.Service;

import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserDoctorDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.UserJwtDto;
@Service
public interface UserService {
	UserDto userLogin(LoginDto input);
	UserDto userRegister(RegisterDto input);
	boolean isCheckEmail(@Email String email);
	boolean isCheckUserName(String userName);
	UserDto updateUser(UserDto userDto, int idUser);
	List<UserDto> getAllUser();
	UserDto findUserByUserName(String userName);
	List<UserDto> getAllUserByLevel(int level);
	UserDto getUserById(int id);
	UserJwtDto userLogin1(LoginDto input);
	UserJwtDto userRegister1(RegisterDto input);
	UserDoctorDto getDoctorById(int id);
	
}
