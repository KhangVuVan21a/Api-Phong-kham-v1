package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.TimeOderDto;

public interface TimeOderService {
	List<TimeOderDto> getAllTimeOder();
	List<TimeOderDto> getAllTimeOderByIdUser(int idUser);
	TimeOderDto getTimeOderById(int id);
}
