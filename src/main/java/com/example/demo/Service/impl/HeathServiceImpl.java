package com.example.demo.Service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return this.heathRepository.findAll().stream().map(i->(i.getUser().getId()==idUser?this.heathMapper.getInstance().toDto(i):null)).collect(Collectors.toList());
	}
	@Override
	public HeathDto createHeath(HeathDto heathDto) {
		Heath heath=this.heathMapper.getInstance().toEntity(heathDto);
		heath.setCreateAt(LocalDate.now());
		heathRepository.save(heath);
		return heathDto;
	}
	@Override
	public HeathDto updateHeath(HeathDto heathDto) {
		Heath heath = heathRepository.findById(heathDto.getId()).get();
		Heath heathDtos=this.heathMapper.getInstance().toEntity(heathDto);
		heathDtos.setCreateAt(heath.getCreateAt());
		return this.heathMapper.getInstance().toDto(this.heathRepository.save(heathDtos));
	}

}
