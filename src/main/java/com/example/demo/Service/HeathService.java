package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.HeathCreateDto;
import com.example.demo.Dto.HeathDto;
import com.example.demo.Entity.Heath;
@Service
public interface HeathService {
	List<HeathDto> getallHeath();
	HeathDto getHeathById(int id);
	List<HeathDto> getAllHeathByIdUser(int idUser);
	HeathDto createHeath(HeathCreateDto heathCreateDto,int timeOderId, int userId,int departmentId);
	HeathDto updateHeath(HeathCreateDto heathCreateDto ,int id);
	
}
