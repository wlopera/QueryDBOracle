package com.wlopera.query.oracle.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QueryRequest implements Serializable {
	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryRequest [sql=");
		builder.append(sql);
		builder.append("]");
		return builder.toString();
	}
}
