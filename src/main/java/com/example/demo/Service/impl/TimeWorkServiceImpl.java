package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.TimeWorkCreateDto;
import com.example.demo.Dto.TimeWorkDto;
import com.example.demo.Entity.TimeWork;
import com.example.demo.ModelMapper.TimeWorkMapper;
import com.example.demo.Repository.TimeWorkRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.TimeWorkService;
@Service
public class TimeWorkServiceImpl implements TimeWorkService{
	@Autowired
	private TimeWorkRepository timeWorkRepository;
	
	@Autowired
	private UserRepository userRepository;
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
	public TimeWorkDto createTimeWork(TimeWorkCreateDto timeWorkCreateDto,int idDoctor) {
		TimeWork timeWork= this.timeWorkMapper.getInstance().toEntityCreate(timeWorkCreateDto);
		if(this.userRepository.findById(idDoctor)!=null) {
			timeWork.setDoctor(this.userRepository.findById(idDoctor).get());
			return this.timeWorkMapper.getInstance().toDto(this.timeWorkRepository.save(timeWork));
		}
		return null;
	}
	@Override
	public TimeWorkDto updateTimeWork(TimeWorkCreateDto timeWorkCreateDto,int id) {
		TimeWork timeWork=this.timeWorkRepository.findById(id).get();
		if(timeWork!=null) {
			timeWork.setTime(timeWorkCreateDto.getTime());
			return this.timeWorkMapper.getInstance().toDto(timeWork);
		}
		return null;
	}

	@Override
	public List<TimeWorkDto> getTimeWorkByDate(LocalDate date, int idDoctor) {
		return this.timeWorkRepository.findAll().stream().filter(i->(i.getDoctor().getId()==idDoctor&&i.getTime().getDayOfYear()==date.getDayOfYear())).map(i->this.timeWorkMapper.getInstance().toDto(i)).collect(Collectors.toList());

	}




}
