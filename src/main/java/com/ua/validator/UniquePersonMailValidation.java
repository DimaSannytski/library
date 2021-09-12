package com.ua.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ua.dto.RegisterDto;
import com.ua.service.UserService;

public class UniquePersonMailValidation implements ConstraintValidator<UniquePersonMail, RegisterDto> {

	@Autowired
	UserService userService;
	
	@Override
	public void initialize(UniquePersonMail constraintAnnotation) {	}

	@Override
	public boolean isValid(RegisterDto registerDto, ConstraintValidatorContext context) {
		if (registerDto == null) return false;
		return userService.findByEmail(registerDto.getEmail()) != null;
	}

}
