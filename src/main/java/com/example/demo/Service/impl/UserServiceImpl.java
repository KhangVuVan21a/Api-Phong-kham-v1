package com.example.demo.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MapperDto mapperDto;
	
	@Override
	public UserDto userLogin(LoginDto input) {
		
		return null;
	}

	@Override
	public UserDto userRegister(RegisterDto input) {
		User user =this.mapperDto.convertUser(input);
		user.setUsername(input.getUserName());
		user.setPassword(this.passwordEncoder.encode(input.getPassword()));
		user.setLevel(input.getLevel());
		this.userRepository.save(user);
		return null;
	}
	
	@Override
	public boolean isCheckEmail(@Email String email) {
		if(Strings.isNotEmpty(email)) {
			return this.userRepository.existsByEmail(email);
		}
		return false;
	}

	@Override
	public boolean isCheckUserName(String userName) {
		if(Strings.isNotEmpty(userName)) {
			return this.userRepository.existsByUserName(userName);
		}
		return false;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user=userRepository.findById(userDto.getId()).orElse(null);
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setBirth(userDto.getBirth());
		user.setFullName(userDto.getFullName());
		user.setSex(userDto.isSex());
		user.setPhoneNumber(userDto.getPhoneNumber());
		return this.mapperDto.convertUserDto(userRepository.save(user));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> list= new ArrayList<>();
		list = userRepository.findAll().stream().map(i->this.mapperDto.convertUserDto(i)).collect(Collectors.toList());
		return list;
	}

	@Override
	public UserDto findUserByUserName(String userName) {
		return this.mapperDto.convertUserDto(userRepository.findAll().stream().filter(i->(i.getUsername().equals(userName))).findFirst().get());
	}

}
