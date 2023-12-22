package com.wlopera.query.oracle.service;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.wlopera.query.oracle.DatabaseConfig;
import com.wlopera.query.oracle.connection.Connect;
import com.wlopera.query.oracle.mapper.Mapper;
import com.wlopera.query.oracle.utilities.Utility;

@Service
public class ServiceOracle {
	private final DatabaseConfig dbConfig;

	/**
	 * Inyecta automaticamente el objeto databaseConfig
	 * 
	 * @param databaseConfig
	 */
	@Autowired
	public ServiceOracle(DatabaseConfig dbConfig) {
		this.dbConfig = dbConfig;
	}

	public String getDataByQuery(String query) throws Exception {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = Connect.getConnection(dbConfig);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			List<Map<String, Object>> rows = getData(resultSet);
			return Mapper.genericJsonByObject(rows);

		} catch (Exception e) {
			System.out.println("##=> Error consultando la tabla en oracle ");
			throw e;

		} finally {
			if (resultSet != null && resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && statement.isClosed()) {
				statement.close();
			}
			if (connection != null && connection.isClosed()) {
				connection.close();
			}
		}
	}

	public String getDataByQueryWithParams(String query, DatabaseConfig config) throws Exception {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = Connect.getConnection(config);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			List<Map<String, Object>> rows = getData(resultSet);
			return Mapper.genericJsonByObject(rows);

		} catch (Exception e) {
			System.out.println("##=> Error consultando la tabla en oracle ");
			throw e;

		} finally {
			if (resultSet != null && resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && statement.isClosed()) {
				statement.close();
			}
			if (connection != null && connection.isClosed()) {
				connection.close();
			}
		}
	}

	/**
	 * Recorre la lista de resultados del query y retorna una lista de datos
	 * 
	 * @param resultSet
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> getData(ResultSet resultSet) throws Exception {
		int columnCount = resultSet.getMetaData().getColumnCount();
		String column = "";
		Object value = "";

		List<Map<String, Object>> rows = new ArrayList<>();
		Gson gson = new Gson();

		while (resultSet.next()) {
			Map<String, Object> row = new HashMap<>();
			for (int i = 1; i <= columnCount; i++) {
				column = resultSet.getMetaData().getColumnName(i);
				value = resultSet.getString(resultSet.getMetaData().getColumnName(i));
				if (value instanceof String && Utility.isJson((String) value)) {
					try {
						JsonElement jsonElement = JsonParser.parseString((String) value);
						value = gson.fromJson(jsonElement, Object.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				row.put(column, value);
			}

			rows.add(row);
		}
		return rows;
	}
}
