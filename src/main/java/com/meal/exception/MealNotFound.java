package com.meal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 *return an exception when the requested meal is not found
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MealNotFound extends RuntimeException {

	public MealNotFound() {
		super();
	}

	public MealNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public MealNotFound(String message) {
		super(message);
	}

	public MealNotFound(Throwable cause) {
		super(cause);
	}
}
