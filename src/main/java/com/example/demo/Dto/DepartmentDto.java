package com.example.demo.Dto;

import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DepartmentDto {
	private int id;
	private String title;
	private String detail;
}
