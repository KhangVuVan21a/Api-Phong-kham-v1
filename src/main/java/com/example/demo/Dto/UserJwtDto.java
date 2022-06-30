package com.example.demo.Dto;

import lombok.Data;


@Data
public class UserJwtDto extends UserDto {
	private String token;
	private String role;
	public UserJwtDto() {
    }

    public UserJwtDto(String token, String role, UserDto userInfo) {
        this.token = token;
        this.role = role;
        this.setUsername(userInfo.getUsername());
        this.setFullName(userInfo.getFullName());
        this.setEmail(userInfo.getEmail());
        this.setId(userInfo.getId());
        this.setLevel(userInfo.getLevel());
    }
	
}
