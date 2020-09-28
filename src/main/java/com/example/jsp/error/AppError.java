package com.example.jsp.error;


public abstract class AppError extends Exception {

	public AppError(String message) {
		super(message);
		System.out.println(getClass().getSimpleName() + " Message: " + message);
	}
}
