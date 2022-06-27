package com.example.demo.ModelMapper;

import org.modelmapper.ModelMapper;

import com.example.demo.Dto.TimeWorkCreateDto;
import com.example.demo.Dto.TimeWorkDto;
import com.example.demo.Entity.TimeWork;

public class TimeWorkMapper {
	private static TimeWorkMapper INSTANCE;
	public static TimeWorkMapper getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new TimeWorkMapper();
		}
		return INSTANCE;	
	}
	public TimeWorkDto toDto(TimeWork timeWork) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(timeWork, TimeWorkDto.class);
	}
	public TimeWork toEntity(TimeWorkDto timeWorkDto) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(timeWorkDto, TimeWork.class);
	}
	public TimeWork toEntityCreate(TimeWorkCreateDto  timeWorkCreateDto) {
		ModelMapper modelMapper= new ModelMapper();
		return modelMapper.map(timeWorkCreateDto, TimeWork.class);
	}
	
}
