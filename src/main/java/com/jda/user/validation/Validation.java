package com.jda.user.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Validation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object user, Errors errors) {
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "required.firstname", "First name is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "required.lastname", "Last name is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "required.mobile", "Mobile is required.");
		  
	}
	

}
