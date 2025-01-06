package com.ua.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ua.dto.RegisterDto;

public class CheckPassMatchValidator implements ConstraintValidator<CheckPassMatch, RegisterDto> {

	@Override
	public boolean isValid(RegisterDto value, ConstraintValidatorContext context) {
		if(value.getPassword() == null || value.getPasswordConfirm() == null) {
			return false;
		}
		if(value.getPassword().equals(value.getPasswordConfirm())) {
			return true;
		}
		return false;
	}

	@Override
	public void initialize(CheckPassMatch constraintAnnotation) {}
}
