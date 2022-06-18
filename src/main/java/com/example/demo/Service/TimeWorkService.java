package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import com.example.demo.Dto.TimeWorkDto;
import com.example.demo.Entity.TimeWork;

public interface TimeWorkService {
	List<TimeWorkDto> getAllTimeWork();
	List<TimeWorkDto> getAllTimeWorkByIdDoctor(int idDoctor);
	TimeWorkDto createTimeWork(TimeWork timeWork);
	TimeWorkDto updateTimeWork(TimeWorkDto timeWork);
	TimeWorkDto getTimeWorkByDate(Date date);
}
