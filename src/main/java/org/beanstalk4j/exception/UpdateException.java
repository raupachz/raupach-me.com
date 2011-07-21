package org.beanstalk4j.exception;

import org.beanstalk4j.model.Errors;

public class UpdateException extends RuntimeException {
	
	private final Errors errors;
	
	public UpdateException(Errors errors) {
		super(errors.getMessage());
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}
	

}
