package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BaseResponseDto;
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
	public BaseResponseDto<?> createHeath(@RequestBody HeathDto heathDto){
		return baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.heathServiceImpl.createHeath(heathDto));
	}
}
