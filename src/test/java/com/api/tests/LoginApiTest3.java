package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;

import io.restassured.response.Response;

public class LoginApiTest3 {

	@Test(description = "Verify if login API working.")
	public void loginTest() {
//		AuthService authService = new AuthService();
//		Response response= authService.login("{\"username\": \"TestBot\", \"password\": \"Test123!\"}");
//		System.out.println(response.asPrettyString());
	}

}
