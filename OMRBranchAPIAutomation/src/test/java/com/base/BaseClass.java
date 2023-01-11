package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	RequestSpecification reqSpec;
	Response response;
	
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see getPropertyFileValue
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(getProjectPath()+"\\src\\test\\resources\\Config\\Config.properties"));
		Object object = p.get(key);
		String value = (String)object;
		return value;
	}
	public void addHeader(String key,String value) {
	
		reqSpec= RestAssured.given().header(key,value);
	}
	
	public void addHeaders(Headers headers) {
		reqSpec= RestAssured.given().headers(headers);
	}
	public void addFormData(String key,File value) {
		reqSpec= reqSpec.multiPart(key,value);
	}
	public void addBaseAuth(String username,String password) {
		
		reqSpec=reqSpec.auth().preemptive().basic(username, password);
	}
	
	public void addQueryParam(String key,String value){
		reqSpec=reqSpec.queryParam(key, value);
	}
	
	public void addPathParam(String key,String value){
		reqSpec=reqSpec.pathParam(key, value);
	}
	
	public void addBody(String body) {
		reqSpec= reqSpec.body(body);
	}
	
	public void addBody(Object body) {
		reqSpec= reqSpec.body(body);
	}
	
	public Response requestType(String type,String endpoint) {
		
		switch (type) {
		case "Get":
			response=reqSpec.get(endpoint);
			break;
		case "Post":
			response=reqSpec.post(endpoint);
			break;
		case "Put":
			response=reqSpec.put(endpoint);
			break;
		case "Delete":
			response=reqSpec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
		
	}
	
	public int getStatusCode(Response response) {
		int statusCode= response.getStatusCode();
		return statusCode;
		
	}

	public String getRestBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}
	
	public String getRestBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
}
