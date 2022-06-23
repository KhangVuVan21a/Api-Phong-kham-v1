package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.DepartmentDto;

@Service
public interface DepartmentService {
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	List<DepartmentDto> getAll();
	DepartmentDto getById(int id);
}
