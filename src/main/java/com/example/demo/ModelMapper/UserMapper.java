package com.example.demo.ModelMapper;

import org.modelmapper.ModelMapper;

import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserAdminDto;
import com.example.demo.Dto.UserDoctorDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;
public class UserMapper {
	private static UserMapper INSTANCE;
	public static UserMapper getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new UserMapper();
		}
		return INSTANCE;
		
	}
	public User toEntity(UserDto dto) {
		ModelMapper modelMapper=new ModelMapper();
		User user = modelMapper.map(dto,User.class);
		return user;
	}
	public UserDto toDto(User user) {
		ModelMapper modelMapper = new ModelMapper();
		UserDto dto = modelMapper.map(user,UserDto.class);
		return dto;
	}
	public UserDto registertoDto(RegisterDto user) {
		ModelMapper modelMapper = new ModelMapper();
		UserDto dto = modelMapper.map(user,UserDto.class);
		return dto;
	}
	public User registertoEntity(RegisterDto registerDto) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(registerDto,User.class);
		return user;
	}
	public UserAdminDto toUserAdmin(User user) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(user, UserAdminDto.class);
	}
	public UserDoctorDto toUserDoctorDto(User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserDoctorDto.class);
	}
}
