package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginTest {
	@Test(description = "verify login api is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("abc.def", "password");
		AuthService auth = new AuthService();
		Response res = auth.login(loginRequest);
		LoginResponse loginResponse = res.as(LoginResponse.class);
		System.out.println(res.asPrettyString());
		System.out.println(loginResponse.getToken());
	}

}
