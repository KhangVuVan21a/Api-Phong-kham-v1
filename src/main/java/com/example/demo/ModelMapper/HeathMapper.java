package com.example.demo.ModelMapper;

import org.modelmapper.ModelMapper;

import com.example.demo.Dto.HeathCreateDto;
import com.example.demo.Dto.HeathDto;
import com.example.demo.Entity.Heath;

public class HeathMapper {
	private static HeathMapper INSTANCE;
	public static HeathMapper getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new HeathMapper();
		}
		return INSTANCE;	
	}
	public HeathDto toDto(Heath heath) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(heath, HeathDto.class);
	}
	public Heath toEntity(HeathDto heathDto) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(heathDto, Heath.class);
	}
	public HeathDto toHeathDto(HeathCreateDto createDto) {
		ModelMapper modelMapper =new  ModelMapper();
		return modelMapper.map(createDto, HeathDto.class);
	}
	public Heath toEntitycreateHeath(HeathCreateDto createDto) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(createDto, Heath.class);
	}
}
