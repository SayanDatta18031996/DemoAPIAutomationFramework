package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	@Test(description = "verify if forgot password working....")
	public void forgotpwdTest() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("vae2dnk@femailtor.com");
		System.out.println(response.asPrettyString());
		//Assert.assertEquals(response, "If your email exists in our system, you will receive reset instructions.");
	}
}
