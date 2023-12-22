package com.wlopera.query.oracle.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PasswordRequest implements Serializable {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PasswordRequest [text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}
}
