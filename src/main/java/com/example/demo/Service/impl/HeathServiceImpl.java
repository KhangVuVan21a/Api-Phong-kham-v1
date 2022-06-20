package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dto.HeathDto;
import com.example.demo.Dto.MapperDto;
import com.example.demo.Entity.Heath;
import com.example.demo.Repository.HeathRepository;
import com.example.demo.Service.HeathService;

public class HeathServiceImpl implements HeathService{
	@Autowired
	private MapperDto mapperDto;
	@Autowired
	private HeathRepository heathRepository;
	@Override
	public List<HeathDto> getallHeath() {
		return heathRepository.findAll().stream().map(i->this.mapperDto.convertHeathDto(i)).collect(Collectors.toList());
	}
	@Override
	public HeathDto getHeathById(int id) {
		return this.mapperDto.convertHeathDto(this.heathRepository.findById(id).get());
	}

	@Override
	public List<HeathDto> getAllHeathByIdUser(int idUser) {
		return this.heathRepository.findAll().stream().map(i->(i.getUser().getId()==idUser?this.mapperDto.convertHeathDto(i):null)).collect(Collectors.toList());
	}
	@Override
	public HeathDto createHeath(HeathDto heathDto) {
		Heath heath=this.mapperDto.convertHeath(heathDto);
		heath.setCreateAt(LocalDate.now());
		heathRepository.save(heath);
		return heathDto;
	}
	@Override
	public HeathDto updateHeath(HeathDto heathDto) {
		Heath heath = heathRepository.findById(heathDto.getId()).get();
		Heath heathDtos=this.mapperDto.convertHeath(heathDto);
		heathDtos.setCreateAt(heath.getCreateAt());
		return this.mapperDto.convertHeathDto(this.heathRepository.save(heathDtos));
	}

}
