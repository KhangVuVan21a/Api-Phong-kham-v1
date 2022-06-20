package com.example.demo.Dto;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.example.demo.Entity.Heath;
import com.example.demo.Entity.TimeOder;
import com.example.demo.Entity.TimeWork;
import com.example.demo.Entity.User;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapperDto {

	UserDto convertUserDto(User user);
	
	User convertUser(LoginDto userLogin);
	
	User convertUser(RegisterDto userRegister);
	
	HeathDto convertHeathDto(Heath heath);
	
	Heath convertHeath(HeathDto heathDto);
	
	TimeOderDto convertTimeOderDto(TimeOder timeOder);
	
	TimeOder converTimeOder(TimeOderDto timeOderDto);
	
	TimeWorkDto convertTimeWorkDto(TimeWork timeWork);
	
	TimeWork convertTimeWork(TimeOderDto  timeOderDto);
	
}
