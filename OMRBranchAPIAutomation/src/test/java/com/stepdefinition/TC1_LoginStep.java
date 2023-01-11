package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.global.GlobalDatas;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass{

	Response response;
	static GlobalDatas globalDatas = new GlobalDatas();
	
	@Given("User add Header")
	public void user_add_header() {
	  
		addHeader("accept", "application/json");
	}
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() {
	
		addBaseAuth("ranjithjithen007@gmail.com", "Sureshdurga96!");
	}
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String type) {
	   
		response = requestType(type, Endpoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		globalDatas.setStatusCode(statusCode);
	}
	
	@Then("User verify the login response body firstName present as {string} and get the logtoken saved")
	public void user_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken_saved(String expfirst_name) {
	
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String actfirst_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("Verify FirstName success message",expfirst_name ,actfirst_name);		
		
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globalDatas.setLogtoken(logtoken);
		
		
	}




}
