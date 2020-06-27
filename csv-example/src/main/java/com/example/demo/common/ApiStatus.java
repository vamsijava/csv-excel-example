package com.example.demo.common;

import org.springframework.http.HttpStatus;

public class ApiStatus<T> {
	
	private HttpStatus status;
	private String requestStatus;
	private String statusMessage;
	private T data;
	private String statusCode;
	
	public ApiStatus() {
		super();
	}
	
	public ApiStatus(HttpStatus status, String requestStatus) {
		super();
		this.status = status;
		this.requestStatus = requestStatus;
	}

	public ApiStatus(HttpStatus status, String requestStatus, String statusMessage) {
		super();
		this.status = status;
		this.requestStatus = requestStatus;
		this.statusMessage = statusMessage;
	}
	
	public ApiStatus(HttpStatus status, String requestStatus, String statusMessage, T data) {
		super();
		this.status = status;
		this.requestStatus = requestStatus;
		this.statusMessage = statusMessage;
		this.data = data;
	}

	public ApiStatus(HttpStatus status, String requestStatus, String statusMessage, T data, String statusCode) {
		super();
		this.status = status;
		this.requestStatus = requestStatus;
		this.statusMessage = statusMessage;
		this.data = data;
		this.statusCode = statusCode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
		
}
