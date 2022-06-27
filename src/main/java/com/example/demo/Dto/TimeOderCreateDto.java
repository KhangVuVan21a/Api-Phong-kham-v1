package com.example.demo.Dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TimeOderCreateDto {
	private LocalDate time;
	private String symptom;
}
