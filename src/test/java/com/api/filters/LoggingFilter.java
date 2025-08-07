package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	private static Logger logger=LogManager.getLogger(LoggingFilter.class);

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response=ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}
public void logRequest(FilterableRequestSpecification requestSpec) {
	logger.info("Base URI: "+requestSpec.getBaseUri());
	logger.info("Request Header: "+requestSpec.getHeaders());
	logger.info("Request Payload: "+ requestSpec.getBody());
}

public void logResponse(Response responseSpec) {
	logger.info("Status Code: "+responseSpec.getStatusCode());
	logger.info("Request Body: "+responseSpec.getBody().prettyPrint());
	logger.info("Response Header: "+ responseSpec.headers());
}
}
