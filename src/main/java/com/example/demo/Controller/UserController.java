package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("User")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	private BaseControll baseControll;
	
	@PostMapping("/register")
	public BaseResponseDto<?> registerUser(@RequestBody RegisterDto dto) {
		return this.baseControll.getInstance().successResponse(Constants.REGISTER_SUCCESS, userServiceImpl.userRegister(dto));
	}
	@PostMapping("/login")
	public BaseResponseDto<?> loginUser(@RequestBody LoginDto dto) {
		return this.baseControll.getInstance().successResponse(Constants.LOGIN_SUCCESS, userServiceImpl.userLogin(dto));
	}
	@PutMapping("/update")
	public BaseResponseDto<?> updateUser(@RequestBody UserDto dto) {
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.userServiceImpl.updateUser(dto));
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
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.userServiceImpl.findUserByUserName(name));
	}
}
