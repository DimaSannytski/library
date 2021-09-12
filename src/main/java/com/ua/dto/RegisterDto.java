package com.ua.dto;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.ua.entity.enums.Sex;
import com.ua.validator.CheckPassMatch;
import com.ua.validator.UniquePersonMail;

import lombok.Data;

@Data
@CheckPassMatch
public class RegisterDto {
	@Email(message = "invalid email")
	@NotEmpty(message = "Please Enter your email")
	@UniquePersonMail
	private String email;
	private String firstName;
	private String lastName;
	@NotBlank
	private String password;
	private String passwordConfirm;
	private Sex sex;
	private Date birthdate;
}
