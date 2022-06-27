package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BaseResponseDto;
import com.example.demo.Dto.DepartmentDto;
import com.example.demo.Entity.Department;
import com.example.demo.Service.impl.DepartmentServiceImpl;
import com.example.demo.Utils.Constants;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Department")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	private BaseControll baseControll;
	
	@PostMapping("/create")
	private BaseResponseDto<?> createDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto department= this.departmentServiceImpl.createDepartment(departmentDto);
		if(department!=null) {
			return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, department);
		}
		return this.baseControll.getInstance().errorResponse(Constants.ERROR_CODE,Constants.ERROR_MESSAGE);
	}
	@GetMapping("/getAll")
	private BaseResponseDto<?> getAll(){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.departmentServiceImpl.getAll());
	}
	@GetMapping("/getById/{id}")
	private BaseResponseDto<?> getById(@PathVariable int id){
		return this.baseControll.getInstance().successResponse(Constants.SUCCESS_MESSAGE, this.departmentServiceImpl.getById(id));
	}
}
