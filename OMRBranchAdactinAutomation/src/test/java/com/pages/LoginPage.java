package com.pages;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Ranjith
 * @see LoginPage
 *
 */
public class LoginPage extends BaseClass{
	
	//1.Valid
	//2.Verifying with Invalid Credentials
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="login")
	private WebElement loginButton;
	
	@FindBy(xpath="//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement textErrorLogin;
    
    
	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getTextErrorLogin() {
		return textErrorLogin;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @see login
	 */
	public void login(String username,String password) {
		
		WebElement txtUsername =getTxtUsername();
		elementSendKeys(txtUsername, username);
		
		WebElement txtPassword = getTxtPassword();
		elementSendKeys(txtPassword, password);
		
		WebElement loginButton = getLoginButton();
		elementClick(loginButton);
	
		}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @see loginWithEnterKey
	 */
	//2.Verifying login fun with Enter Key
	public void loginWithEnterKey(String username,String password) {
	
		WebElement txtUsername = findElementById("username");
		elementSendKeys(txtUsername, username);
		
		WebElement txtPassword = findElementById("password");
		elementSendKeysUsingKeys(txtPassword, password,Keys.ENTER);
		
	}

}
