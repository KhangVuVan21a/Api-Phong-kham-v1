package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BaseResponseDto;
import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;
import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.Utils.Constants;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	private BaseControll baseControll;
	
	@PostMapping("/register")
	public BaseResponseDto<?> registerUser(@RequestBody RegisterDto dto) {
		UserDto userDto =this.userServiceImpl.userRegister(dto);
		if(userDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.REGISTER_SUCCESS, userDto);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE, null);
	}
	@PostMapping("/login")
	public BaseResponseDto<?> loginUser(@RequestBody LoginDto dto) {
		UserDto userDto = this.userServiceImpl.userLogin(dto);
		if(userDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.LOGIN_SUCCESS, userServiceImpl.userLogin(dto));
		}
		return this.baseControll.getInstance().errorResponse(Constants.SERVER_ERROR_CODE, Constants.LOGIN_ERROR);
	}
	@PutMapping("/update/{idUser}")
	public BaseResponseDto<?> updateUser(@RequestBody UserDto dto,@PathVariable int idUser) {
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.userServiceImpl.updateUser(dto,idUser));
	}
	@GetMapping("/getall")
	public BaseResponseDto<?> getAllUser()
	{
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.userServiceImpl.getAllUser());
	}
	@GetMapping("/GetAllByLevel/{level}")
	public BaseResponseDto<?> getAllUserBylevel(@PathVariable int level)
	{
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.userServiceImpl.getAllUserByLevel(level));
	}
	@GetMapping("GetAllUserByName/{name}")
	public BaseResponseDto<?> getAllUserByName(@PathVariable String name){
		UserDto user = this.userServiceImpl.findUserByUserName(name);
		if(user!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, user);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE, Constants.SERVER_ERROR_MESSAGE);
	}
	@GetMapping("/getUserById/{id}")
	private BaseResponseDto<?> getUserById(@PathVariable int id){
		UserDto userDto=this.userServiceImpl.getUserById(id);
		if(userDto!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE,userDto);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE, Constants.ERROR_MESSAGE);
	}
}
