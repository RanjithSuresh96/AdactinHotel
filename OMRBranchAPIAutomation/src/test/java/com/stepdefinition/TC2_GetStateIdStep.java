package com.stepdefinition;

import java.util.ArrayList;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;

import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass {
	Response response;

	
	

	@Given("User add Header for StateList")
	public void user_add_header_for_state_list() {
		
		addHeader("accept", "application/json");
	}
	@When("User send {string} request to getStateList endpoint")
	public void user_send_request_to_get_state_list_endpoint(String type) {
	 
		 response = requestType(type, Endpoints.GETSTATEID);
		 int statusCode = getStatusCode(response);
		 TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	
	@Then("User verify the StateList response message matching {string} and saved State Id")
	public void user_verify_the_state_list_response_message_matching_and_saved_state_id(String expeachStateListName) {
	 
		StateList_Output_pojo stateList_Output_pojo = response.as(StateList_Output_pojo.class);
		ArrayList<StateList> data = stateList_Output_pojo.getData();
		for (StateList eachstateList : data) {

			String eachStateListName = eachstateList.getName();
			if (eachStateListName.equals("Tamil Nadu")) {
				Assert.assertEquals(eachStateListName, expeachStateListName, "Verify Statename");
				int stateId = eachstateList.getId();
				String stateid = String.valueOf(stateId);
				TC1_LoginStep.globalDatas.setStateId(stateId);
				TC1_LoginStep.globalDatas.setStateid(stateid);
				System.out.println(stateid);
				break;
			}

		}

	}




}
