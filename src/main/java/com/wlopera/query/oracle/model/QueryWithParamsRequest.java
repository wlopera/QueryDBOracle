package com.wlopera.query.oracle.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QueryWithParamsRequest implements Serializable {
	private String sql;
	private String host;
	private String port;
	private String dbName;
	private String user;
	private String password;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryWithParamsRequest [sql=");
		builder.append(sql);
		builder.append(", host=");
		builder.append(host);
		builder.append(", port=");
		builder.append(port);
		builder.append(", dbName=");
		builder.append(dbName);
		builder.append(", user=");
		builder.append(user);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
}
