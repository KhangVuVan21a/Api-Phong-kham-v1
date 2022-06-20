package com.example.demo.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.TimeOder;
import com.example.demo.Repository.TimeOderRepository;
import com.example.demo.Service.TimeOderService;

public class TimeOderServiceImpl implements TimeOderService{
	@Autowired
	private TimeOderRepository timeOderRepository;
	@Autowired
	private MapperDto mapperDto;
	@Override
	public List<TimeOderDto> getAllTimeOder() {
		return this.timeOderRepository.findAll().stream().map(i->this.mapperDto.convertTimeOderDto(i)).collect(Collectors.toList());
	}

	@Override
	public List<TimeOderDto> getAllTimeOderByIdUser(int idUser) {
		return this.timeOderRepository.findAll().stream().map(i->(i.getUser().getId()==idUser?this.mapperDto.convertTimeOderDto(i):null)).collect(Collectors.toList());
	}

	@Override
	public TimeOderDto getTimeOderById(int id) {
		return this.mapperDto.convertTimeOderDto(this.timeOderRepository.findById(id).get());
	}

	@Override
	public TimeOderDto createTimeOder(TimeOder timeOder) {
		return this.mapperDto.convertTimeOderDto(this.timeOderRepository.save(timeOder));
	}

	@Override
	public TimeOderDto updateTimeOder(TimeOderDto timeOderDto) {
		TimeOder timeOder = this.timeOderRepository.findById(timeOderDto.getId()).get();
		TimeOder timeOderDtos=this.mapperDto.converTimeOder(timeOderDto);
		timeOderDtos.setCreateAt(timeOder.getCreateAt());
		timeOderRepository.save(timeOderDtos);
		return this.mapperDto.convertTimeOderDto(timeOderDtos);
	}

}
