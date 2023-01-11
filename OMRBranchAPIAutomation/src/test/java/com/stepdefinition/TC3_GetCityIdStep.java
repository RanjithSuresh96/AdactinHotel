package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.global.GlobalDatas;
import com.pojo.address.CityList;
import com.pojo.address.CityList_Input_Pojo;
import com.pojo.address.CityList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_GetCityIdStep extends BaseClass {
	Response response;

	
	
	@Given("User add Header for CityList")
	public void user_add_header_for_city_list() {

		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

	}

	@When("User add request body to get CityList {string}")
	public void user_add_request_body_to_get_city_list(String stateid) {

		
		
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(TC1_LoginStep.globalDatas.getStateid());
		addBody(cityList_Input_Pojo);
	}

	@When("User send {string} request for getCityList endpoint")
	public void user_send_request_for_get_city_list_endpoint(String type) {

		response = requestType(type, Endpoints.POSTCITYID);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the CityList response message matching {string} and saved City Id")
	public void user_verify_the_city_list_response_message_matching_and_saved_city_id(String expcityname) {

		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> data = cityList_Output_Pojo.getData();
		for (CityList eachcityList : data) {
			String actcityname = eachcityList.getName();
			if (actcityname.equals("Thanjavur")) {
				Assert.assertEquals(actcityname, expcityname, "Verify cityname");
				int cityid = eachcityList.getId();
				TC1_LoginStep.globalDatas.setCityid(cityid);
				break;

			}

		}

	}

}
