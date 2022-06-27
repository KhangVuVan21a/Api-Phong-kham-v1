package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.TimeOderCreateDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Entity.TimeOder;
@Service
public interface TimeOderService {
	List<TimeOderDto> getAllTimeOder();
	List<TimeOderDto> getAllTimeOderByIdUser(int idUser);
	TimeOderDto getTimeOderById(int id);
	TimeOderDto createTimeOder(TimeOderCreateDto timeOderCreateDto);
	TimeOderDto updateTimeOder(TimeOderDto timeOderDto);
}
