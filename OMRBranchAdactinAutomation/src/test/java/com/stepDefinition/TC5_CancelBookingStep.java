package com.stepDefinition;

import com.pagemanager.PageObjectManager;


import io.cucumber.java.en.When;

/**
 * 
 * @author Ranjith
 * @see TC5_CancelBookingStep
 *
 */
public class TC5_CancelBookingStep {
	

	PageObjectManager pom = new PageObjectManager();

	@When("User should cancel existing order id {string}")
	public void user_should_cancel_existing_order_id(String orderid) {
	   
		pom.getCancelBookingPage().cancelOrderId(orderid);
		
	}
	









	
	

}
