package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;
import com.api.models.responses.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	@Test(description="Checking get profile resquest is working...")
	public void getProfileInfoTest() {
		AuthService authService = new AuthService();
		Response response= authService.login(new LoginRequest("TestBot", "Test123!"));
		LoginResponse loginResponse= response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println("-----------------User Response----------------------");
		UserProfileManagementService managementService= new UserProfileManagementService();
		response=managementService.getProfile(loginResponse.getToken());
		UserProfileResponse profileResponse=response.as(UserProfileResponse.class);
		System.out.println(profileResponse.getUsername());
		System.out.println("----------------End Of Response-----------------------");
	}

}
