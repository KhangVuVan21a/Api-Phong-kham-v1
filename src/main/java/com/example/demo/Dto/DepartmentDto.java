package com.example.demo.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DepartmentDto {
	private int id;
	private String title;
	private String detail;
}
