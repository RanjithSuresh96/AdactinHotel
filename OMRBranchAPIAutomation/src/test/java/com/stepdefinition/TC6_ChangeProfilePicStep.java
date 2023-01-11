package com.stepdefinition;

import java.io.File;
 
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.global.GlobalDatas;
import com.pojo.profilepic.ChangeProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC6_ChangeProfilePicStep extends BaseClass{
	Response response;

	
	String logtoken = TC1_LoginStep.globalDatas.getLogtoken();
	@Given("User add Header and Bearer authorization for accessing profile picture endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_profile_picture_endpoint() {
	   
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);
	}
	@When("User add request body to profile picture")
	public void user_add_request_body_to_profile_picture()  {
		addFormData("profile_picture", new File ("C:\\Users\\RANJITH\\eclipse-workspace\\OMRBranchAPIAutomation\\Images\\IMG_20140831_144405657.jpg"));
	}
	@When("User send {string} request for profile picture endpoint")
	public void user_send_request_for_profile_picture_endpoint(String type) {
		response = requestType(type, Endpoints.POSTCHANGEPROFILEPIC);
		 int statusCode = getStatusCode(response);
		 TC1_LoginStep.globalDatas.setStatusCode(statusCode);
		
	}

	@Then("User verify the profile Picture response message matching {string}")
	public void user_verify_the_profile_picture_response_message_matching(String expmessage) {

		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);
		String actmessage = changeProfilePic_Output_Pojo.getMessage();
		Assert.assertEquals(actmessage,expmessage ,"Verify Profile updated Successfully");
	
	}






}
