package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import com.example.demo.Dto.BaseResponseDto;
import com.example.demo.ModelMapper.UserMapper;
import com.example.demo.Utils.Constants;


public class BaseControll {
		private static BaseControll INSTANCE;
		
		public static BaseControll getInstance() {
			if(INSTANCE==null) {
				INSTANCE=new BaseControll();
			}
			return INSTANCE;
			
		}
	 	public  ResponseEntity<?> serverError(){
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.serverErrorResponse());
	    }

	    public BaseResponseDto<?> successResponse(String message) {
	        return this.successResponse(message, null);
	    }

	    public <T> BaseResponseDto<T> successResponse(T data) {
	        return this.successResponse(Constants.SUCCESS_MESSAGE, data);
	    }

	    public <T> BaseResponseDto<T> successResponse(String message, T data) {
	        return this.successResponse(Constants.SUCCESS_CODE, message, data);
	    }

	    public <T> BaseResponseDto<T> successResponse(int code, String message, T data) {
	        return this.response(Constants.SUCCESS_STATUS, code, message, data);
	    }

	    public BaseResponseDto<?> serverErrorResponse() {
	        return this.errorResponse(Constants.SERVER_ERROR_CODE,Constants.SERVER_ERROR_MESSAGE);
	    }

	    public BaseResponseDto<?> errorResponse() {
	        return this.errorResponse(Constants.ERROR_MESSAGE);
	    }

	    public BaseResponseDto<?> errorResponse(Errors errors){
	        return this.errorResponse(errors.getAllErrors().get(0).getDefaultMessage());
	    }

	    public BaseResponseDto<?> errorResponse(String message) {
	        return this.errorResponse(Constants.ERROR_CODE, message);
	    }

	    public BaseResponseDto<?> errorResponse(int code, String message) {
	        return this.response(Constants.ERROR_STATUS, code, message, null);
	    }

	    public <T> BaseResponseDto<T> response(boolean status,int code, String message, T data) {
	        BaseResponseDto<T> response = new BaseResponseDto<>();
	        response.setStatus(status);
	        response.setCode(code);
	        response.setMessage(message);
	        response.setData(data);

	        return response;
	    }
}
