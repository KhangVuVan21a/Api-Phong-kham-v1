package com.example.demo.Dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TimeOderCreateDto {
	private LocalDateTime time;
	private String symptom;
}
