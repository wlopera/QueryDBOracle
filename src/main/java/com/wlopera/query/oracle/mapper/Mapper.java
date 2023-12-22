package com.wlopera.query.oracle.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Mapper {

	/**
	 * Conversion de un Json a un objeto
	 *
	 * @param input Json con los datos del objeto
	 * @param clazz Literal de la clase a convertir
	 * @author con_wlopera
	 * @param <T>
	 * @return Objeto de datos
	 */
	public static <T> T genericObjectByJson(String input, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(input, clazz);
	}

	/**
	 * Conversion de Objeto a Json.
	 *
	 * @param input Objecto de datos.
	 * @author con_wlopera
	 * @return json de datos
	 */
	public static String genericJsonByObject(Object input) {
		Gson gson = new Gson();
		return gson.toJson(input);
	}

	/**
	 * Conversion de Objeto a Json formateado.
	 *
	 * @param input Objecto de datos.
	 * @author con_wlopera
	 * @return json de datos
	 */
	public static String genericJsonByObjectPretty(Object obj) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(obj);
	}

	/**
	 * Conversion de Objeto a Json formateado.
	 *
	 * @param input Objecto de datos.
	 * @author con_wlopera
	 * @return json de datos
	 */
	public static String genericJsonByStringPretty(Object obj) {

		String data = genericJsonByObject(obj);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject convertedObject = new Gson().fromJson(data, JsonObject.class);

		return gson.toJson(convertedObject);
	}
}
