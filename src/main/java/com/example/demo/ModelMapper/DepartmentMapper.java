package com.example.demo.ModelMapper;

import org.modelmapper.ModelMapper;

import com.example.demo.Dto.DepartmentDto;
import com.example.demo.Entity.Department;

public class DepartmentMapper {
	private static DepartmentMapper INSTANCE;
	public static DepartmentMapper getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new DepartmentMapper();
		}
		return INSTANCE;	
	}
	public DepartmentDto toDto(Department department) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(department, DepartmentDto.class);
	}
	public Department toEntity(DepartmentDto departmentDto) {
		ModelMapper modelMapper =new ModelMapper();
		return modelMapper.map(departmentDto, Department.class);
	}
}
