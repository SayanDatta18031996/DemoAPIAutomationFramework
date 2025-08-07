package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.responses.LoginResponse;
import com.api.models.responses.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description="Checking update profile working...")
	public void updateProfileInfoTest() {
		AuthService authService = new AuthService();
		Response response= authService.login(new LoginRequest("TestBot", "Test123!"));
		LoginResponse loginResponse= response.as(LoginResponse.class);
		UserProfileManagementService managementService= new UserProfileManagementService();
		System.out.println(loginResponse.getToken());
		System.out.println("-----------------User Response----------------------");
		response=managementService.getProfile(loginResponse.getToken());
		UserProfileResponse profileResponse=response.as(UserProfileResponse.class);
		System.out.println(profileResponse);
		Assert.assertEquals(profileResponse.getUsername(), "TestBot");
		System.out.println("----------------End Of Response-----------------------");
		ProfileRequest profileRequest=new ProfileRequest.Builder()
				.firstName("Testing")
				.lastName("Bot")
				.email("TestBot@gmail.com")
				.mobileNumber("9876543210")
				.build();
		response=managementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
	}
}
