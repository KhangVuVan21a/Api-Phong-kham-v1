package com.example.demo.ModelMapper;

import org.modelmapper.ModelMapper;

import com.example.demo.Dto.TimeOderCreateDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.TimeOder;

public class TimeOderMapper {
	private static TimeOderMapper INSTANCE;
	public static TimeOderMapper getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new TimeOderMapper();
		}
		return INSTANCE;	
	}
	public TimeOderDto toDto(TimeOder timeOder) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(timeOder, TimeOderDto.class);
	}
	public TimeOder toEntity(TimeOderDto timeOderDto) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(timeOderDto, TimeOder.class);
	}
	public TimeOder createtoEntity(TimeOderCreateDto timeOderCreateDto) {
		ModelMapper molMapper =new ModelMapper();
		return molMapper.map(timeOderCreateDto, TimeOder.class);
	}
}
