package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	@Test(description = "verify forget password api is working")
	public void forgotPasswordTest() {
		AuthService auth = new AuthService();
		Response res = auth.forgotPassword("abc.def@test.com");
		Assert.assertEquals(res.getBody(), "If your email exists in our system, you will receive reset instructions.");
	}

}
