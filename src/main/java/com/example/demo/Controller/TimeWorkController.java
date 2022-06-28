package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
import com.example.demo.Dto.TimeWorkCreateDto;
import com.example.demo.Dto.TimeWorkDto;
import com.example.demo.Repository.TimeWorkRepository;
import com.example.demo.Service.impl.TimeWorkServiceImpl;
import com.example.demo.Utils.Constants;

import net.bytebuddy.asm.Advice.This;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/TimeWork")
public class TimeWorkController {
	@Autowired
	private TimeWorkServiceImpl timeWorkServiceImpl;
	
	private BaseControll baseControll;
	
	@PostMapping("/creaete/{idDoctor}")
	private BaseResponseDto<?> createTimeWork(@RequestBody TimeWorkCreateDto timeWorkCreateDto,@PathVariable int idDoctor){
		TimeWorkDto workDto = this.timeWorkServiceImpl.createTimeWork(timeWorkCreateDto,idDoctor);
		if(workDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, workDto);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE,"Not Created!");	
	}
	@PutMapping("/update/{id}")
	private BaseResponseDto<?> updateTimeWork(@RequestBody TimeWorkCreateDto timeWorkCreateDto,@PathVariable int id){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.timeWorkServiceImpl.updateTimeWork(timeWorkCreateDto,id));
	}
	@GetMapping("/getAll")
	private BaseResponseDto<?> getAllTimeWork(){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE,this.timeWorkServiceImpl.getAllTimeWork());
	}
	@GetMapping("/getAllByIdDoctor/{idDoctor}")
	private BaseResponseDto<?> getAllTimeWorkByDoctorId(@PathVariable int idDoctor){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.timeWorkServiceImpl.getAllTimeWorkByIdDoctor(idDoctor));
	}
	@GetMapping("/getTimeWorkByDateIdDoctor/{idDoctor}/{date}")
	private BaseResponseDto<?> getAllTimeWorkByDateIddoctor(@PathVariable java.sql.Date date,@PathVariable int idDoctor){
		List<TimeWorkDto> list= this.timeWorkServiceImpl.getTimeWorkByDate(date.toLocalDate(),idDoctor);
		if(list!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, list);
		}
		return this.baseControll.getInstance().errorResponse(Constants.SERVER_ERROR_CODE,Constants.ERROR_MESSAGE);
	}
	
}
