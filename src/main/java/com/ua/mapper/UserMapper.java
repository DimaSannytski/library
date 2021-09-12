package com.ua.mapper;

import com.ua.dto.RegisterDto;
import com.ua.entity.User;

public interface UserMapper {

	public static User UserRegister(RegisterDto registerDto) {
		
		User user = new User();
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setEmail(registerDto.getEmail());
		user.setBirthday(registerDto.getBirthdate());
		user.setEmail(registerDto.getEmail());
		user.setPassword(registerDto.getPassword());
		return user;
		
	}
}
