package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test(description = "Verify if Login API is working")
	public void createAccTest() {
		SignUpRequest signUpReq=new SignUpRequest.Builder()
				.firstName("Danny")
				.lastName("Daniels")
				.email("wi.xs.to.c.l.e@gmail.com")
				.password("Test123!")
				.mobileNumber("9876543210")
				.username("DannyDaniels")
				.build();
		
		AuthService authService=new AuthService();
		Response response=authService.signUp(signUpReq);
		Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
		System.out.println(response.asPrettyString());
		
	}
}
