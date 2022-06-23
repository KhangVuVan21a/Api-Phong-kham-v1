package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BaseResponseDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Service.impl.TimeOderServiceImpl;
import com.example.demo.Utils.Constants;
@RestController 
@RequestMapping("/TimeOder")
public class TimeOderController {
	@Autowired
	private TimeOderServiceImpl timeOderServiceImpl;
	
	private BaseControll baseControll;
	@GetMapping("/FindAll")
	private BaseResponseDto<?> findAllTimeOder(){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.timeOderServiceImpl.getAllTimeOder());
	}
	@PostMapping("/createTimeOder")
	private BaseResponseDto<?> createTimeOder(@RequestBody TimeOderDto timeOderDto) {
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE,this.timeOderServiceImpl.createTimeOder(timeOderDto));
	}
}
