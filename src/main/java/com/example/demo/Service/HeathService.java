package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.HeathDto;
import com.example.demo.Entity.Heath;
@Service
public interface HeathService {
	List<HeathDto> getallHeath();
	HeathDto getHeathById(int id);
	List<HeathDto> getAllHeathByIdUser(int idUser);
	HeathDto createHeath(HeathDto heathDto);
	HeathDto updateHeath(HeathDto heathDto);
	
}
