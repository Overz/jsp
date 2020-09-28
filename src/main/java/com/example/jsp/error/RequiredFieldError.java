package com.example.jsp.error;

import javax.servlet.jsp.ErrorData;

public class RequiredFieldError extends AppError {

	public RequiredFieldError(String message) {
		super(message);
		System.out.println(getClass().getSimpleName() + " Message: " + message);
	}
}
