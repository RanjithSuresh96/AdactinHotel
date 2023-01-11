package com.stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Ranjith
 * @see TC1_LoginStep
 *
 */
public class TC1_LoginStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin login page")
	public void user_is_on_the_adactin_login_page() throws FileNotFoundException, IOException {

	}
	@When("User should perform login {string},{string}")
	public void user_should_perform_login(String username, String password) {
		
		pom.getLoginpage().login(username, password);
	  
	}
	
	
	@When("User should perform login {string},{string} and perform Enter key")
	public void user_should_perform_login_and_perform_enter_key(String username, String password) {
		
		pom.getLoginpage().loginWithEnterKey(username, password);
	    
	}

	@Then("User should verify the Invalid credentials error message after login which contains {string}")
	public void user_should_verify_the_invalid_credentials_error_message_after_login_which_contains(String expectedLoginErrorMsg) {
	  
		WebElement textErrorLogin = pom.getLoginpage().getTextErrorLogin();
		
		String elementGetText = elementGetText(textErrorLogin);
		boolean contains = elementGetText.contains(expectedLoginErrorMsg);
		Assert.assertTrue(contains);
			
	}



	






	
	

}
