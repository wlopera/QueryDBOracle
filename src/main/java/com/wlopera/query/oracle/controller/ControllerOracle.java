package com.wlopera.query.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.query.oracle.DatabaseConfig;
import com.wlopera.query.oracle.mapper.Mapper;
import com.wlopera.query.oracle.model.QueryRequest;
import com.wlopera.query.oracle.model.QueryWithParamsRequest;
import com.wlopera.query.oracle.model.Response;
import com.wlopera.query.oracle.service.ServiceOracle;
import com.wlopera.query.oracle.service.ServicePassword;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ControllerOracle {

	private final ServiceOracle serviceOracle;
	private final ServicePassword servicePassword;

	/**
	 * Inyecta automaticamente la clase ServiceOracle
	 * 
	 * @param service
	 */
	@Autowired
	public ControllerOracle(ServiceOracle serviceOracle, ServicePassword servicePassword) {
		this.serviceOracle = serviceOracle;
		this.servicePassword = servicePassword;
	}

	/**
	 * Permite realizar un procesamiento local.
	 * 
	 * @author con_wlopera
	 */
	@PostMapping("/query")
	public String getQueryDB(@RequestBody QueryRequest queryRequest) {
		System.out.println("Request -query: " + queryRequest);
		Response response = new Response();

		try {
			String sql = queryRequest.getSql();
			return serviceOracle.getDataByQuery(sql);

		} catch (Exception e) {
			System.out.println("Proceso terminado con Error");
			e.printStackTrace();
			response.setCode("500");
			response.setMessage("Proceso terminado con error");
			response.setError(e.getMessage());
			return Mapper.genericJsonByObject(response);
		}

	}

	/**
	 * Permite realizar un procesamiento local.
	 * 
	 * @author con_wlopera
	 */
	@PostMapping("/queryParams")
	public String getQueryDBWithParams(@RequestBody QueryWithParamsRequest request) {
		System.out.println("Request -queryParams: " + request);
		Response response = new Response();

		try {

			String sql = request.getSql();
			DatabaseConfig config = new DatabaseConfig();
			config.setHost(request.getHost());
			config.setPort(request.getPort());
			config.setDbName(request.getDbName());
			config.setUser(request.getUser());
			config.setPassword(servicePassword.decrypt(request.getPassword()));

			return serviceOracle.getDataByQueryWithParams(sql, config);

		} catch (Exception e) {
			System.out.println("Proceso terminado con Error");
			e.printStackTrace();
			response.setCode("500");
			response.setMessage("Proceso terminado con error");
			response.setError(e.getMessage());
			return Mapper.genericJsonByObject(response);
		}

	}
}
