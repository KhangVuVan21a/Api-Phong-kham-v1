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
import com.example.demo.Dto.TimeOderCreateDto;
import com.example.demo.Dto.TimeOderDto;
import com.example.demo.Service.impl.TimeOderServiceImpl;
import com.example.demo.Utils.Constants;
@RestController 
@CrossOrigin("http://localhost:3000")
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
	private BaseResponseDto<?> createTimeOder(@RequestBody TimeOderCreateDto timeOderCreateDto) {
		TimeOderDto oderDto = this.timeOderServiceImpl.createTimeOder(timeOderCreateDto);
		if(oderDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, oderDto);
		}
		//return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE,this.timeOderServiceImpl.createTimeOder(timeOderDto));
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE,Constants.ERROR_MESSAGE);
	}
	@GetMapping("/getAllTimeOderByUserId/{id}")
	private BaseResponseDto<?> getAllTimeOderByUserId(@PathVariable int id){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.timeOderServiceImpl.getAllTimeOderByIdUser(id));
	}
	@PutMapping("/Update")
	private BaseResponseDto<?> updateTimeOder(@RequestBody TimeOderDto timeOderDto){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.timeOderServiceImpl.updateTimeOder(timeOderDto));
	}
	@GetMapping("/getById/{id}")
	private BaseResponseDto<?> getTimeOderById(@PathVariable int id){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.timeOderServiceImpl.getTimeOderById(id));
	}
}
