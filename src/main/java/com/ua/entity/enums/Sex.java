package com.ua.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sex {
	MALE("Чоловіча"),FEMALE("Жіноча"), OTER("Інше");
	private String sex;
}
