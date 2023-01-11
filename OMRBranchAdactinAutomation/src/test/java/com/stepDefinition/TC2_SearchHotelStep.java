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
 * @see TC2_SearchHotelStep
 *
 */
public class TC2_SearchHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();

	@When("User should select all fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_select_all_fields_and(String Locations, String Hotels, String RoomType, String NoOfRooms, String CheckinDate, String CheckoutDate, String Adultsperroom, String Childrensperroom) {

		pom.getSearchHotelPage().searchHotels(Locations, Hotels, RoomType, NoOfRooms, CheckinDate, CheckoutDate, Adultsperroom, Childrensperroom);
	}
	


	@When("User should select only the mantory fields {string},{string},{string},{string} and {string}")
	public void user_should_select_only_the_mantory_fields_and(String Locations, String NoOfRooms, String CheckinDate, String CheckoutDate, String Adultsperroom) {
	    
		pom.getSearchHotelPage().searchHotels(Locations, NoOfRooms, CheckinDate, CheckoutDate, Adultsperroom);
	}
	
		
	@Then("User should verify the check-in and check-out date error message after search hotel {string},{string}")
	public void user_should_verify_the_check_in_and_check_out_date_error_message_after_search_hotel(String expectedcheckin, String expectedcheckout) {
	   
		WebElement errorcheckin = pom.getSearchHotelPage().getErrorcheckin();
		String actualcheckin = elementGetText(errorcheckin);
		Assert.assertEquals("verify checkin date error message", expectedcheckin, actualcheckin);
		
		WebElement errorcheckout = pom.getSearchHotelPage().getErrorcheckout();
		String actualcheckout = elementGetText(errorcheckout);
		Assert.assertEquals("verify checkout date error message", expectedcheckout, actualcheckout);
		
	}

	@When("User should not enter any data and click search button")
	public void user_should_not_enter_any_data_and_click_search_button() {
	    
		pom.getSearchHotelPage().searchHotels();
	}
	@Then("User should verify the error message after search hotel {string}")
	public void user_should_verify_the_error_message_after_search_hotel(String expectedsearchErrorMsg) {
		
		WebElement errorlocation = pom.getSearchHotelPage().getErrorlocation();
		String actualsearchErrorMsg = elementGetText(errorlocation);
		Assert.assertEquals("Verify error message after search hotel", expectedsearchErrorMsg, actualsearchErrorMsg);
	    
	}






	











	





	

}
