package com.example.demo.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dto.MapperDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.TimeOder;
import com.example.demo.ModelMapper.TimeOderMapper;
import com.example.demo.Repository.TimeOderRepository;
import com.example.demo.Service.TimeOderService;

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
	public List<TimeOderDto> getAllTimeOderByIdUser(int idUser) {
		return this.timeOderRepository.findAll().stream().map(i->(i.getUser().getId()==idUser?this.timeOderMapper.toDto(i):null)).collect(Collectors.toList());
	}

	@Override
	public TimeOderDto getTimeOderById(int id) {
		return this.timeOderMapper.getInstance().toDto(this.timeOderRepository.findById(id).get());
	}

	@Override
	public TimeOderDto createTimeOder(TimeOder timeOder) {
		return this.timeOderMapper.getInstance().toDto(this.timeOderRepository.save(timeOder));
	}

	@Override
	public TimeOderDto updateTimeOder(TimeOderDto timeOderDto) {
		TimeOder timeOder = this.timeOderRepository.findById(timeOderDto.getId()).get();
		TimeOder timeOderDtos=this.timeOderMapper.getInstance().toEntity(timeOderDto);
		timeOderDtos.setCreateAt(timeOder.getCreateAt());
		timeOderRepository.save(timeOderDtos);
		return this.timeOderMapper.getInstance().toDto(timeOderDtos);
	}

}
