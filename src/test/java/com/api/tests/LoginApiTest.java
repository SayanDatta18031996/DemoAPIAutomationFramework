package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //All the methods are static in rest assured and readability will improves if use as static import.
import io.restassured.response.Response;

public class LoginApiTest {
	
	@Test(description ="Verify if login API working.")
	public void loginTest() {
// Complex coding
//		RestAssured.baseURI="http://64.227.160.186:8080";
//		RequestSpecification x=RestAssured.given();
//		RequestSpecification y=x.header("Content-Type", "application/json");
//		RequestSpecification z=y.body("{\"username\": \"TestBot\", \"password\": \"Test123!\"}");
//		Response response=z.post("/api/auth/login");
//		System.out.println(response.asPrettyString());
//		Assert.assertEquals(response.statusCode(), 2000);
// simplified coding
		Response response=given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json").body("{\"username\": \"TestBot\", \"password\": \"Test123!\"}").post("/api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
}
