package com.wlopera.query.oracle.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Response implements Serializable {
	private String code;
	private String message;
	private String error;
	private String data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append(", error=");
		builder.append(error);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
}
