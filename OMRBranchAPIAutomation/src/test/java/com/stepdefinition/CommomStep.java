package com.stepdefinition;



import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommomStep {
	
	
	
	@Then("User verify the status code is {int}")
	public void user_verify_the_status_code_is(int expStatusCode) {
	   
		
		int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals("Verify Status Code", expStatusCode,actStatusCode);
		
		
				
	}
	

}
