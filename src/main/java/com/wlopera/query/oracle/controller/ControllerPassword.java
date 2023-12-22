package com.wlopera.query.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.query.oracle.mapper.Mapper;
import com.wlopera.query.oracle.model.PasswordRequest;
import com.wlopera.query.oracle.model.Response;
import com.wlopera.query.oracle.service.ServicePassword;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ControllerPassword {

	private final ServicePassword service;

	/**
	 * Inyecta automaticamente la clase ServiceOracle
	 * 
	 * @param service
	 */
	@Autowired
	public ControllerPassword(ServicePassword service) {
		this.service = service;
	}

	/**
	 * Permite realizar un procesamiento local.
	 * 
	 * @author con_wlopera
	 */
	@PostMapping("/encript")
	public String encriptText(@RequestBody PasswordRequest request) {
		System.out.println("Encriptar: "+ request.getText());
		Response response = new Response();

		try {
			String text = request.getText();

			String encryptedText = service.encrypt(text);
			System.out.println("Texto cifrado: " + encryptedText);

			return encryptedText;

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
	@PostMapping("/decrypt")
	public String decryptText(@RequestBody PasswordRequest request) {
		Response response = new Response();
		
		try {
			String text = request.getText();
			
			String decryptedText = service.decrypt(text);
			System.out.println("Texto descifrado: " + decryptedText);
			
			return decryptedText;
			
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
