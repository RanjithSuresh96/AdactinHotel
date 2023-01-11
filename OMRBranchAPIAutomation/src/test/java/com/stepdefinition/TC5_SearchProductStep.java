package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.global.GlobalDatas;

import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass {
	Response response;

	
	
	@Given("User add Header and Bearer authorization for accessing search product endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_search_product_endpoint() {
	   
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

	}
	@When("User add request body to search product {string}")
	public void user_add_request_body_to_search_product(String nuts) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(nuts);
		addBody(searchProduct_Input_Pojo);
		
	}
	@When("User send {string} request for search product endpoint")
	public void user_send_request_for_search_product_endpoint(String type) {
		response = requestType(type, Endpoints.POSTSEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the search product response message matching {string}")
	public void user_verify_the_search_product_response_message_matching(String expmessage) {
	   
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String actmessage = searchProduct_Output_Pojo.getMessage();
		Assert.assertEquals(actmessage, expmessage,"Verify search product success");
		
	}









	
	







}
