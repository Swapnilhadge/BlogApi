package com.BikkadIT.BlogApplication.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	static String resourceName;
	String fieldName;
	long fieldvalue;
	
	public ResourceNotFoundException(String resourName, String fieldName,long fieldvalue) {
		super(String.format("%s not found with %s : %l", resourceName, fieldName, fieldvalue));
		this.resourceName = resourName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
		
		
		
	}

}
