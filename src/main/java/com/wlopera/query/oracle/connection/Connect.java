package com.wlopera.query.oracle.connection;

import java.sql.Connection;

import com.wlopera.query.oracle.DatabaseConfig;

import oracle.jdbc.pool.OracleDataSource;

public class Connect {
	/**
	 * Conexion a la DB
	 * 
	 * @author con_wlopera
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection(DatabaseConfig dbConfig) throws Exception {
		String connectionUrl = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = %ID%)(PORT = %PORT%)))(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = %DB_NAME%)))";

		connectionUrl = connectionUrl.replaceAll("%ID%", dbConfig.getHost());
		connectionUrl = connectionUrl.replaceAll("%PORT%", dbConfig.getPort());
		connectionUrl = connectionUrl.replaceAll("%DB_NAME%", dbConfig.getDbName());

		System.out.println("##=> connectionUrl: " + connectionUrl);

		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connectionUrl);
		ods.setUser(dbConfig.getUser());
		ods.setPassword(dbConfig.getPassword());

		return ods.getConnection();

	}
}
