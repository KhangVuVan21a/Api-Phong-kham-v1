package com.example.demo.Service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;
import com.example.demo.ModelMapper.UserMapper;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private MapperDto mapperDto;
	
	//@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDto userLogin(LoginDto input) {
		User user =this.userRepository.findAllByUserName(input.getUserName()).stream().findFirst().orElse(null);
		return this.passwordEncoder.matches(input.getPassword(),user.getPassword())?this.userMapper.getInstance().toDto(user):null;
	}

	@Override
	public UserDto userRegister(RegisterDto input) {
		User user =this.userMapper.getInstance().registertoEntity(input);
		user.setUserName(input.getUserName());
		user.setPassword(this.passwordEncoder.encode(input.getPassword()));
		user.setLevel(input.getLevel());
		user.setCreateAt(LocalDateTime.now());
		return this.userMapper.getInstance().toDto(this.userRepository.save(user));
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
		user.setUpdateAt(LocalDateTime.now());
		return this.userMapper.getInstance().toDto(userRepository.save(user));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> list= new ArrayList<>();
		list = userRepository.findAll().stream().map(i->this.userMapper.getInstance().toDto(i)).collect(Collectors.toList());
		return list;
	}

	@Override
	public UserDto findUserByUserName(String userName) {
		return this.userMapper.getInstance().toDto(userRepository.findAllByUserName(userName).get(0));
	}

	@Override
	public List<UserDto> getAllUserByLevel(int level) {
		return this.getAllUser().stream().filter(i->i.getLevel()==level).collect(Collectors.toList());
	}

}
