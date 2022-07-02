package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.TimeOderCreateDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.TimeOder;
import com.example.demo.Entity.User;
@Service
public interface TimeOderService {
	List<TimeOderDto> getAllTimeOder();
	List<TimeOderDto> getAllTimeOderByUser(User user);
	List<TimeOderDto> getAllTimeOderByDoctor(User doctor);
	TimeOderDto getTimeOderById(int id);
	TimeOderDto createTimeOder(TimeOderCreateDto timeOderCreateDto,User user ,User doctor);
	TimeOderDto updateTimeOder(TimeOderDto timeOderDto);
}
