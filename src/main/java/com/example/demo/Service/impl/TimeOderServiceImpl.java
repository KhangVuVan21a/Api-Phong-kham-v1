package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.TimeOderCreateDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.TimeOder;
import com.example.demo.Entity.User;
import com.example.demo.ModelMapper.TimeOderMapper;
import com.example.demo.Repository.TimeOderRepository;
import com.example.demo.Service.TimeOderService;
@Service
public class TimeOderServiceImpl implements TimeOderService{
	@Autowired
	private TimeOderRepository timeOderRepository;
//	@Autowired
//	private MapperDto mapperDto;
	private TimeOderMapper timeOderMapper;
	@Override
	public List<TimeOderDto> getAllTimeOder() {
		return this.timeOderRepository.findAll().stream().map(i->this.timeOderMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}

	@Override
	public List<TimeOderDto> getAllTimeOderByUser(User user) {
		return this.timeOderRepository.findAllTimeOderByUser(user).stream().map(i->this.timeOderMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}

	@Override
	public TimeOderDto getTimeOderById(int id) {
		return this.timeOderMapper.getInstance().toDto(this.timeOderRepository.findById(id).get());
	}

	@Override
	public TimeOderDto createTimeOder(TimeOderCreateDto timeOderCreateDto, User user ,User doctor) {
		TimeOder timeOder = this.timeOderMapper.getInstance().createtoEntity(timeOderCreateDto);
		timeOder.setUser(user);
		timeOder.setDoctor(doctor);
		timeOder.setCreateAt(LocalDate.now());
		return this.timeOderMapper.getInstance().toDto(this.timeOderRepository.save(timeOder));
		//return this.timeOderRepository.save(this.timeOderMapper.getInstance().toEntity(timeOderDto));
	}
	
	@Override
	public TimeOderDto updateTimeOder(TimeOderDto timeOderDto) {
		TimeOder timeOder = this.timeOderRepository.findById(timeOderDto.getId()).get();
		TimeOder timeOderDtos=this.timeOderMapper.getInstance().toEntity(timeOderDto);
		timeOderDtos.setCreateAt(timeOder.getCreateAt());
		timeOderDtos.setUpdateAt(LocalDate.now());
		timeOderRepository.save(timeOderDtos);
		return this.timeOderMapper.getInstance().toDto(timeOderDtos);
	}

	@Override
	public List<TimeOderDto> getAllTimeOderByDoctor(User doctor) {
		return this.timeOderRepository.findAllTimeOderByDoctor(doctor).stream().map(i->this.timeOderMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}

}
