package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;

public class BaseService {//this class is a wrapper for rest assured
//Base URI
//Creating the request
//Handling the request
	
	private static final String BASE_URI="http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static{
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService() {
		requestSpecification= given().baseUri(BASE_URI);
	}
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization","Bearer "+token);
	}
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
//When our base URI changes for each service we need to pass base URI too for each service.	
//	protected Response postRequest(String baseUri,Object payload, String endpoint) {
//		return requestSpecification.baseUri(baseURI).contentType(ContentType.JSON).body(payload).post(endpoint);
//	}
	
}
