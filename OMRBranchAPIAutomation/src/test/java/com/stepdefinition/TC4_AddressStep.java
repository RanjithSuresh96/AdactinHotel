package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;


import com.pojo.address.AddAddressStatus_Output_Pojo;
import com.pojo.address.Address_Input_Pojo;
import com.pojo.address.DeleteAddress_Input_Pojo;
import com.pojo.address.DeleteAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateAddres_Input_Pojo;
import com.pojo.address.UpdateAddres_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	Response response;

	String logtoken = TC1_LoginStep.globalDatas.getLogtoken();
	int stateId = TC1_LoginStep.globalDatas.getStateId();
	int cityid = TC1_LoginStep.globalDatas.getCityid();
	int country =101;
	String addressid2 = TC1_LoginStep.globalDatas.getAddressid();
	@Given("User add Header and Bearer authorization for accessing add address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_add_address_endpoint() {

		
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);
		Headers headers = new Headers(listHeaders);
		addHeaders(headers);
	}

	@When("User add request body for add new address {string}, {string}, {string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String firstName, String lastName, String number,
			String apartment,String zipcode, String address,
			String addressType) {
		
		System.out.println(stateId);
		System.out.println(cityid);
		System.out.println(country);
		
		Address_Input_Pojo address_Input_Pojo = new Address_Input_Pojo(firstName, lastName, number,
				apartment, stateId, cityid, country,zipcode , address, addressType);
		addBody(address_Input_Pojo);

	}

	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String type) {

		response = requestType(type, Endpoints.POSTADDADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User verify the addUserAddress response message matching {string}")
	public void user_verify_the_add_user_address_response_message_matching(String expmessage) {

		AddAddressStatus_Output_Pojo addAddressStatus_Output_Pojo = response.as(AddAddressStatus_Output_Pojo.class);
		String actmessage = addAddressStatus_Output_Pojo.getMessage();
		Assert.assertEquals(actmessage, expmessage, "Verify address successfully updated ststus");
		
		int address_id = addAddressStatus_Output_Pojo.getAddress_id();
		String addressid = String.valueOf(address_id);
		TC1_LoginStep.globalDatas.setAddressid(addressid);
		
		
		
		

	}

	@Given("User add Header and Bearer authorization for accessing update address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_update_address_endpoint() {

		String logtoken = TC1_LoginStep.globalDatas.getLogtoken();
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

	}

	@When("User add request body for update new address {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
	public void user_add_request_body_for_update_new_address_and(String addressid,String firstName, String lastName,
			String number, String apartment, String zipcode, String location, String addressType) {

		
		UpdateAddres_Input_Pojo updateAddres_Input_Pojo = new UpdateAddres_Input_Pojo(addressid2, firstName, lastName,
				number, apartment, stateId, cityid, country, zipcode, location, addressType);
		addBody(updateAddres_Input_Pojo);

	}

	@When("User send {string} request for updateUserAddress endpoint")
	public void user_send_request_for_update_user_address_endpoint(String type) {

		response = requestType(type, Endpoints.PUTUPDATEADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the updateUserAddress response message matching {string}")
	public void user_verify_the_update_user_address_response_message_matching(String expmessage) {

		UpdateAddres_Output_Pojo updateAddres_Output_Pojo = response.as(UpdateAddres_Output_Pojo.class);
		String actmessage = updateAddres_Output_Pojo.getMessage();
		
		Assert.assertEquals(actmessage, expmessage, "Verify updated success message");
	}

	@Given("User add Header and Bearer authorization for accessing get address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_get_address_endpoint() {

		String logtoken = TC1_LoginStep.globalDatas.getLogtoken();
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		listHeaders.add(h1);
		listHeaders.add(h2);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

	}

	@When("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String type) {

		response = requestType(type, Endpoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the getUserAddress response message matching {string}")
	public void user_verify_the_get_user_address_response_message_matching(String expmessage) {

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String actmessage = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actmessage,expmessage, "Verify OK message");
	}

	@Given("User add Header and Bearer authorization for accessing delete address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_delete_address_endpoint() {

		String logtoken = TC1_LoginStep.globalDatas.getLogtoken();
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);
	}

	@When("User add request body for delete address {string}")
	public void user_add_request_body_for_delete_address(String addressid) {

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(addressid2);
		addBody(deleteAddress_Input_Pojo);
	}

	@When("User send {string} request for deleteUserAddress endpoint")
	public void user_send_request_for_delete_user_address_endpoint(String type) {

		response = requestType(type, Endpoints.DELETEUSERADDRESS);;
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the deleteUserAddress response message matching {string}")
	public void user_verify_the_delete_user_address_response_message_matching(String expmessage) {

		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		String actmessage = deleteAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actmessage, expmessage, "Verify delete success message");
	}

}
