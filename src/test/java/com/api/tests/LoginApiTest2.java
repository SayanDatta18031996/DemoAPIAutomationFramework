package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginApiTest2 {

	@Test(description = "Verify if login API working.")
	public void loginTest() {
		//we an get the individual values by using models.
		LoginRequest loginRequest=new LoginRequest("TestBot", "Test123!");
		AuthService authService = new AuthService();
		Response response= authService.login(loginRequest);
		Assert.assertEquals(response.statusCode(), 200);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getType()!= null);
		Assert.assertEquals(loginResponse.getEmail(),"TestBot@gmail.com");
		Assert.assertEquals(loginResponse.getId(),997);
	}

}
