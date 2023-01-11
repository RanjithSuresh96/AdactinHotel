package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;


import io.cucumber.java.en.Then;

/**
 * 
 * @author Ranjith
 * @see CommonStep
 *
 */
public class CommonStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify the success message after login {string}")
	public void user_should_verify_the_success_message_after_login(String expLoginSuccessMessage) {
		
		 WebElement textLoginMsg = pom.getSearchHotelPage().getTextLoginMsg();
		 
		 String actualLoginSuccessMessage = elementGetAttribute(textLoginMsg);
		 
		 Assert.assertEquals("Verify after Login Success Message", expLoginSuccessMessage, actualLoginSuccessMessage);
		 }
	
	@Then("User should verify the success message after search hotel {string}")
	public void user_should_verify_the_success_message_after_search_hotel(String expectedSelectHotelSuccessMsg) {
		
		WebElement selectHotelTitle = pom.getSelectHotelPage().getSelectHotelTitle();
		String actualSelectHotelSuccessMsg = elementGetText(selectHotelTitle);
		Assert.assertEquals("Verify after search hotel success message", expectedSelectHotelSuccessMsg, actualSelectHotelSuccessMsg);

	}
	
	@Then("User should verify success message after select hotel {string}")
	public void user_should_verify_success_message_after_select_hotel(String expectedbookhotelMsg) {
		
		WebElement bookHotelSuccessMsg = pom.getBookHotelPage().getBookHotelSuccessMsg();
		String actualbookhotelMsg = elementGetText(bookHotelSuccessMsg);
		Assert.assertEquals("Verify after select hotel success message", expectedbookhotelMsg, actualbookhotelMsg);
	    
	}
	
	@Then("User should verify success message after book hotel {string} and save the generated order id")
	public void user_should_verify_success_message_after_book_hotel_and_save_the_generated_order_id(String expectedBookingSuccessMsg) {
	  
		WebElement bookingConfirmSuccessMsg = pom.getBookingConfirmationPage().getBookingConfirmSuccessMsg();
		String actualBookingSuccessMsg = elementGetText(bookingConfirmSuccessMsg);
		Assert.assertEquals("Verify after book hotel Success message", expectedBookingSuccessMsg, actualBookingSuccessMsg);
	}
	
	@Then("User should verify success message after cancel generated order id {string}")
	public void user_should_verify_success_message_after_cancel_generated_order_id(String expectedCancelSuccessMsg) {
	  
		pom.getBookingConfirmationPage().getOrderId();
		WebElement cancelledSuccessMsg = pom.getCancelBookingPage().getCancelledSuccessMsg();
		String actualCancelSuccessMsg = elementGetText(cancelledSuccessMsg);
		Assert.assertEquals("Verify after generated orderid cancel Success Message", expectedCancelSuccessMsg, actualCancelSuccessMsg);
	}
	
	@Then("User should verify success message after cancel existing order id {string}")
	public void user_should_verify_success_message_after_cancel_existing_order_id(String expectedCancelSuccessMsg) {
		
		WebElement cancelledSuccessMsg = pom.getCancelBookingPage().getCancelledSuccessMsg();
		String actualCancelSuccessMsg = elementGetText(cancelledSuccessMsg);
		Assert.assertEquals("Verify after existing orderid cancel Success Message", expectedCancelSuccessMsg, actualCancelSuccessMsg);
	    
	}
	
	
	
	
	
	
	
	
	
	
	

}
