package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Ranjith
 * @see TC3_SelectHotelStep
 *
 */
public class TC3_SelectHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@When("User should select hotel name")
	public void user_should_select_hotel_name() {
		
		pom.getSelectHotelPage().selectHotel();
	   
	}
	

	@When("User should click continue")
	public void user_should_click_continue() {
		
		pom.getSelectHotelPage().clickContinue();
	  
	}
	@Then("User should verify error message after select hotel {string}")
	public void user_should_verify_error_message_after_select_hotel(String expectedErrorClick) {
		
		WebElement errorContinueClick = pom.getSelectHotelPage().getErrorContinueClick();
		String actualErrorClick = elementGetText(errorContinueClick);
		Assert.assertEquals("Verify continue click error message", expectedErrorClick, actualErrorClick);
        
	}





	
	

}
