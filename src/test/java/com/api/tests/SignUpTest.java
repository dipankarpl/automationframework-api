package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class SignUpTest {
	@Test(description = "verify signup api is working")
	public void signUpTest() {
		SignUpRequest signUpRequest = new SignUpRequest("disha.patani","password", "disha.patani@test.com", "disha", "patani", "9876543210");
		AuthService auth = new AuthService();
		Response res = auth.signUp(signUpRequest);
		Assert.assertEquals(res.asPrettyString(), "User registered successfully!");
	}

}
