package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileTest {
	@Test(description = "verify update profile api is working")
	public void getProfileTest() {
		AuthService auth = new AuthService();
		Response res = auth.login(new LoginRequest("abc.def", "password"));
		LoginResponse loginres = res.as(LoginResponse.class);

		UserManagementService um = new UserManagementService();
		Response resp = um.updateProfile(loginres.getToken(), new UpdateProfileRequest("abc.def@test.com", "abc", "def", "9876540123"));
		UserProfileResponse userProfileResponse=resp.as(UserProfileResponse.class);
		System.out.println(resp.asPrettyString());
		Assert.assertEquals(userProfileResponse.getUsername(), "abc.def");
	}

}
