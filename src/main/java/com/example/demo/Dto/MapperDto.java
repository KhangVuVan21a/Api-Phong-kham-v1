package com.example.demo.Dto;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.example.demo.Entity.User;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapperDto {

	UserDto convertUserDto(User user);
	
	User convertUser(LoginDto userLogin);
	
	User convertUser(RegisterDto userRegister);
}
