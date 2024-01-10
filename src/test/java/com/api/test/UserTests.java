package com.api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.endpoints.UserEndPoints;
import com.api.payload.User;

import io.restassured.response.Response;

public class UserTests {

	User userPayload;
	
	@BeforeClass
	public void setupData() {
		userPayload = new User();
		userPayload.setId(123);
		userPayload.setUsername("Itest");
		userPayload.setFirstName("Test");
		userPayload.setLastName("User");
		userPayload.setEmail("abctest@gmail.com");
		userPayload.setPassword("password@123");
		userPayload.setPhone("2091843922");
	}
	
	@Test(priority=1)
	public void testPostUser() {
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void getUserByName() {
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void updateUserByUserName() {
		userPayload.setEmail("abcdtest@gmail.com");
		userPayload.setPhone("2091123922");
		Response response = UserEndPoints.updateUser(userPayload, this.userPayload.getUsername());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void deleteUserByUserName() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
