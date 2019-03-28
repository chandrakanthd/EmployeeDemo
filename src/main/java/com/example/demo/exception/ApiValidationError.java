package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError{
	
	private String object;
	private String field;
	private String message;
	private Object rejectedValue;
	
	public ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

}