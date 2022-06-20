package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.TimeWorkDto;
import com.example.demo.Entity.TimeWork;
import com.example.demo.Repository.TimeWorkRepository;
import com.example.demo.Service.TimeWorkService;

public class TimeWorkServiceImpl implements TimeWorkService{
	@Autowired
	private TimeWorkRepository timeWorkRepository;
	
	@Autowired 
	private MapperDto mapperDto;
	@Override
	public List<TimeWorkDto> getAllTimeWork() {
		return this.timeWorkRepository.findAll().stream().map(i->this.mapperDto.convertTimeWorkDto(i)).collect(Collectors.toList());
	}

	@Override
	public List<TimeWorkDto> getAllTimeWorkByIdDoctor(int idDoctor) {
		return this.timeWorkRepository.findAll().stream().map(i->(i.getDoctor().getId()==idDoctor?this.mapperDto.convertTimeWorkDto(i):null)).collect(Collectors.toList());
	}

	@Override
	public TimeWorkDto createTimeWork(TimeWork timeWork) {
		return this.mapperDto.convertTimeWorkDto(this.timeWorkRepository.save(timeWork));
	}
	@Override
	public TimeWorkDto updateTimeWork(TimeWorkDto timeWork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeWorkDto getTimeWorkByDate(LocalDate date) {
		return this.mapperDto.convertTimeWorkDto(this.timeWorkRepository.findAll().stream().findFirst().map(i->i.getTime()==date?i:null).get());
	}



}
