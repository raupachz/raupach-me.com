package org.beanstalk4j;

public class ApiException extends RuntimeException {
	
	private final int responseCode;
	
	public ApiException(int responseCode, String message) {
		super(responseCode + (message.isEmpty() ? "" : " - " + message));
		this.responseCode = responseCode;
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	
}
