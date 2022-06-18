package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.HeathDto;

public interface HeathService {
	List<HeathDto> getallHeath();
	HeathDto getHeathById(int id);
	List<HeathDto> getAllHeathByIdUser(int idUser);
	List<HeathDto> getAllHeathByIdDoctor(int idDoctor);
	
}
