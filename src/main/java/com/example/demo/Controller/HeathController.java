package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BaseResponseDto;
import com.example.demo.Dto.HeathCreateDto;
import com.example.demo.Dto.HeathDto;
import com.example.demo.Service.impl.HeathServiceImpl;
import com.example.demo.Utils.Constants;

@RestController
@RequestMapping("/Heath")
public class HeathController {
	@Autowired 
	private HeathServiceImpl heathServiceImpl;
	
	private BaseControll baseControll;
	@PostMapping("")
	public BaseResponseDto<?> createHeath(@RequestBody HeathCreateDto heathCreateDto){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.heathServiceImpl.createHeath(heathCreateDto));
	}
	@GetMapping("/GetAllHeath")
	public BaseResponseDto<?> findAllHeath(){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.heathServiceImpl.getallHeath());
	}
	@GetMapping("/GetById/{id}")
	public BaseResponseDto<?> getHeathById(@PathVariable int id){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.heathServiceImpl.getHeathById(id));
	}
}
