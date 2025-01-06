package com.ua.mapper;

import com.ua.dto.RegisterDto;
import com.ua.entity.User;
import com.ua.entity.enums.Role;

public interface UserMapper {

	public static User userRegister(RegisterDto registerDto) {
		User user = new User();
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setEmail(registerDto.getEmail().toLowerCase());
		user.setBirthday(registerDto.getBirthdate());
		user.setSex(registerDto.getSex());
		user.setPassword(registerDto.getPassword());
		user.setActivated(true);
		user.setRole(Role.ROLE_USER);
		return user;
	}
}
