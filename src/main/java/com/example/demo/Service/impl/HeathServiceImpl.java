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
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.Heath;
import com.example.demo.Entity.User;
import com.example.demo.ModelMapper.DepartmentMapper;
import com.example.demo.ModelMapper.HeathMapper;
import com.example.demo.ModelMapper.TimeOderMapper;
import com.example.demo.ModelMapper.UserMapper;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.HeathRepository;
import com.example.demo.Repository.TimeOderRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.HeathService;

import net.bytebuddy.asm.Advice.This;

@Service
public class HeathServiceImpl implements HeathService{
//	@Autowired
//	private MapperDto mapperDto;
	@Autowired
	private HeathRepository heathRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired TimeOderRepository timeOderRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private HeathMapper heathMapper;
	private TimeOderMapper timeOderMapper;
	private UserMapper userMapper;
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<HeathDto> getallHeath() {
		List<HeathDto> listHeathDto= this.heathRepository.findAll().stream().map(i->(this.heathMapper.getInstance().toDto(i))).collect(Collectors.toList());
		listHeathDto.forEach(i->i.setTimeOderDto(this.timeOderMapper.getInstance().toDto(this.heathRepository.findById(i.getId()).get().getTimeOder())));
		return listHeathDto;
	}
	@Override
	public HeathDto getHeathById(int id) {
		HeathDto heathDto =this.heathMapper.getInstance().toDto(this.heathRepository.findById(id).get());
		heathDto.setTimeOderDto(this.timeOderMapper.getInstance().toDto(this.heathRepository.findById(id).get().getTimeOder()));
		return heathDto;
	}
	@Override
	public List<HeathDto> getAllHeathByIdUser(int idUser) {
		return this.heathRepository.findAll().stream().filter(i->i.getUser().getId()==idUser).map(i->this.heathMapper.getInstance().toDto(i)).collect(Collectors.toList());
	}
	@Override
	public HeathDto createHeath(HeathCreateDto heathCreateDto,int timeOderId,int userId, int departmentId) {
		Heath heath =this.heathMapper.getInstance().toEntitycreateHeath(heathCreateDto);
		heath.setCreateAt(LocalDate.now());
		heath.setUpdateAt(LocalDate.now());
		if(this.userRepository.existsById(userId) && this.timeOderRepository.existsById(timeOderId) && this.departmentRepository.existsById(departmentId)) {
			return this.heathMapper.getInstance().toDto(this.heathRepository.save(heath));
		}
		return  null;
	}
	@Override
	public HeathDto updateHeath(HeathCreateDto heathCreateDto,int id) {
		Heath heath= this.heathRepository.findById(id).get();
		if(heath!=null) {
			heath.setUpdateAt(LocalDate.now());
			heath.setTitle(heathCreateDto.getTitle());
			heath.setDetail(heathCreateDto.getDetail());
			return this.heathMapper.getInstance().toDto(this.heathRepository.save(heath));
		}
		return null;
	}



}
