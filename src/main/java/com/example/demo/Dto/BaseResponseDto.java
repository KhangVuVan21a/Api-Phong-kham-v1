package com.example.demo.Dto;

import lombok.Data;

@Data
public class BaseResponseDto<T> {
	private boolean status;
	private int code;
	private String message;
	private T data;
}
