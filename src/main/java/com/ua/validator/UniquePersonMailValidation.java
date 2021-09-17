package com.ua.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ua.service.UserService;

public class UniquePersonMailValidation implements ConstraintValidator<UniquePersonMail, String> {

	@Autowired
	UserService userService;
	
	@Override
	public void initialize(UniquePersonMail constraintAnnotation) {	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) return false;
		return userService.findByEmail(value.toLowerCase()) == null;
	}



}
