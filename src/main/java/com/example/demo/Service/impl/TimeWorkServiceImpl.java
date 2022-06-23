package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.TimeWorkDto;
import com.example.demo.Entity.TimeWork;
import com.example.demo.ModelMapper.TimeWorkMapper;
import com.example.demo.Repository.TimeWorkRepository;
import com.example.demo.Service.TimeWorkService;
@Service
public class TimeWorkServiceImpl implements TimeWorkService{
	@Autowired
	private TimeWorkRepository timeWorkRepository;
	
//	@Autowired 
//	private MapperDto mapperDto;
	
	private TimeWorkMapper timeWorkMapper;
	@Override
	public List<TimeWorkDto> getAllTimeWork() {
		return this.timeWorkRepository.findAll().stream().map(i->this.timeWorkMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}

	@Override
	public List<TimeWorkDto> getAllTimeWorkByIdDoctor(int idDoctor) {
		return this.timeWorkRepository.findAll().stream().map(i->(i.getDoctor().getId()==idDoctor?this.timeWorkMapper.getInstance().toDto(i):null)).collect(Collectors.toList());
	}

	@Override
	public TimeWorkDto createTimeWork(TimeWork timeWork) {
		return this.timeWorkMapper.getInstance().toDto(this.timeWorkRepository.save(timeWork));
	}
	@Override
	public TimeWorkDto updateTimeWork(TimeWorkDto timeWorkDto) {
		TimeWork timeWork=this.timeWorkRepository.findById(timeWorkDto.getId()).get();
		if(timeWork!=null) {
			TimeWork work=this.timeWorkMapper.getInstance().toEntity(timeWorkDto);
			return timeWorkDto;
		}
		return null;
	}
	@Override
	public TimeWorkDto getTimeWorkByDate(LocalDate date) {
		return this.timeWorkMapper.getInstance().toDto(this.timeWorkRepository.findAll().stream().findFirst().map(i->i.getTime()==date?i:null).get());
	}



}
