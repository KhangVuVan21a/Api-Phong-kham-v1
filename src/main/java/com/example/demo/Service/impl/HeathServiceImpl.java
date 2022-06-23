package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.HeathCreateDto;
import com.example.demo.Dto.HeathDto;
import com.example.demo.Dto.MapperDto;
import com.example.demo.Entity.Heath;
import com.example.demo.ModelMapper.HeathMapper;
import com.example.demo.Repository.HeathRepository;
import com.example.demo.Service.HeathService;

@Service
public class HeathServiceImpl implements HeathService{
//	@Autowired
//	private MapperDto mapperDto;
	@Autowired
	private HeathRepository heathRepository;
	
	private HeathMapper heathMapper;
	
	@Override
	public List<HeathDto> getallHeath() {
		return heathRepository.findAll().stream().map(i->this.heathMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}
	@Override
	public HeathDto getHeathById(int id) {
		return this.heathMapper.getInstance().toDto(this.heathRepository.findById(id).get());
	}
	@Override
	public List<HeathDto> getAllHeathByIdUser(int idUser) {
		return this.heathRepository.findAll().stream().filter(i->i.getUser().getId()==idUser).map(i->this.heathMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}
	@Override
	public HeathDto createHeath(HeathCreateDto heathCreateDto) {
		Heath heath =this.heathMapper.getInstance().toEntitycreateHeath(heathCreateDto);
		heath.setCreateAt(LocalDate.now());
		heath.setUpdateAt(LocalDate.now());
		return  this.heathMapper.getInstance().toDto(this.heathRepository.save(heath));
	}
	@Override
	public HeathDto updateHeath(HeathCreateDto heathCreateDto) {
		return null;
	}



}
