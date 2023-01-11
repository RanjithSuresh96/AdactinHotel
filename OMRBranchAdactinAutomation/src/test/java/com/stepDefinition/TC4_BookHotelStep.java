package com.stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Ranjith
 * @see TC4_BookHotelStep
 *
 */
public class TC4_BookHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@When("User should book hotel {string},{string} and {string}")
	public void user_should_book_hotel_and(String FirstName, String LastName, String BillingAddress, io.cucumber.datatable.DataTable dataTable) {
	 
		List<Map<String,String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String CreditCardNo = map.get("CreditCardNo");
		String CreditCardType = map.get("CreditCardType");
		String SelectMonth = map.get("SelectMonth");
		String SelectYear = map.get("SelectYear");
		String CVV = map.get("CVV");
		pom.getBookHotelPage().bookHotel(FirstName, LastName, BillingAddress, CreditCardNo, CreditCardType, SelectMonth, SelectYear, CVV);;
		
	}
	
	
	@When("User should not enter any fields and click book now button")
	public void user_should_not_enter_any_fields_and_click_book_now_button() {
		
		pom.getBookHotelPage().bookHotel();
	   
	}
	@Then("User should verify error message after book hotel {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_error_message_after_book_hotel_and(String expectedfstname, String expectedlstname, String expectedErrAddress, String expectedErrCardno, String expectedErrCardType, String expectedErrExpiry, String expectedErrCvvno) {
	    
		WebElement errFstname = pom.getBookHotelPage().getErrFstname();
		String actualfstname = elementGetText(errFstname);
		Assert.assertEquals("Verify firstname error message", expectedfstname, actualfstname);
		
		WebElement errLstname = pom.getBookHotelPage().getErrLstname();
		String actuallstname = elementGetText(errLstname);
		Assert.assertEquals("Verify lastname error message", expectedlstname, actuallstname);
		
		WebElement ErrAddress = pom.getBookHotelPage().getErrAddress();
		String actualErrAddress = elementGetText(ErrAddress);
		Assert.assertEquals("Verify address error message", expectedErrAddress, actualErrAddress);
		
		WebElement ErrCardno = pom.getBookHotelPage().getErrCardno();
		String actualErrCardno = elementGetText(ErrCardno);
		Assert.assertEquals("Verify cardNo error message", expectedErrCardno, actualErrCardno);
		
		WebElement ErrCardType = pom.getBookHotelPage().getErrCardType();
		String actualErrCardType = elementGetText(ErrCardType);
		Assert.assertEquals("Verify cardtype error message", expectedErrCardType, actualErrCardType);
		
		WebElement ErrExpiry = pom.getBookHotelPage().getErrExpiry();
		String actualErrExpiry = elementGetText(ErrExpiry);
		Assert.assertEquals("Verify expiry error message", expectedErrExpiry, actualErrExpiry);
		
		WebElement ErrCvvno = pom.getBookHotelPage().getErrCvvno();
		String actualErrCvvno = elementGetText(ErrCvvno);
		Assert.assertEquals("Verify cvvno error message", expectedErrCvvno, actualErrCvvno);
	}






	
	

}
