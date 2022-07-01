package com.example.demo.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.DepartmentDto;
import com.example.demo.Entity.Department;
import com.example.demo.ModelMapper.DepartmentMapper;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private DepartmentMapper departmentMapper;

	@Override
	public List<DepartmentDto> getAll() {
		return this.departmentRepository.findAll().stream().map(i->this.departmentMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}

	@Override
	public DepartmentDto getById(int id) {
		return this.departmentMapper.getInstance().toDto(this.departmentRepository.findById(id).get());
	}
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		return this.departmentMapper.getInstance().toDto(this.departmentRepository.save(this.departmentMapper.getInstance().toEntity(departmentDto)));
	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
		Department department=this.departmentRepository.findById(departmentDto.getId()).get();
		if(department==null)
			return null;
		department.setDetail(departmentDto.getDetail());
		department.setTitle(departmentDto.getTitle());
		return this.departmentMapper.getInstance().toDto(this.departmentRepository.save(department));
	}
	

}
