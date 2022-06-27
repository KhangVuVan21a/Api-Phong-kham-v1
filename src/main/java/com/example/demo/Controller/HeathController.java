package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BaseResponseDto;
import com.example.demo.Dto.HeathCreateDto;
import com.example.demo.Dto.HeathDto;
import com.example.demo.Service.impl.HeathServiceImpl;
import com.example.demo.Utils.Constants;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Heath")
public class HeathController {
	@Autowired 
	private HeathServiceImpl heathServiceImpl;
	
	private BaseControll baseControll;
	@PostMapping("/{timeOderId}/{userId}/{departmentId}")
	public BaseResponseDto<?> createHeath(@RequestBody HeathCreateDto heathCreateDto,@PathVariable int timeOderId,@PathVariable int userId,@PathVariable int departmentId){
		HeathDto heathDto= this.heathServiceImpl.createHeath(heathCreateDto,timeOderId,userId,departmentId);
		if(heathDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_CODE,Constants.SUCCESS_MESSAGE,heathDto);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE, Constants.ERROR_MESSAGE);
		
	}
	@GetMapping("/GetAllHeath")
	public BaseResponseDto<?> findAllHeath(){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.heathServiceImpl.getallHeath());
	}
	@GetMapping("/GetById/{id}")
	public BaseResponseDto<?> getHeathById(@PathVariable int id){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.heathServiceImpl.getHeathById(id));
	}
	@PutMapping("/update/{id}")
	private BaseResponseDto<?> updateHeath(@RequestBody HeathCreateDto createDto,@PathVariable int id){
		HeathDto heathDto =this.heathServiceImpl.updateHeath(createDto, id);
		if(heathDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, heathDto);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE, Constants.ERROR_MESSAGE);
	}
}
