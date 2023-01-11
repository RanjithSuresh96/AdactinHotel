package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Ranjith
 * @see To maintain BookHotelPage
 *
 */
public class BookHotelPage extends BaseClass {
	
	//1.By select all fields
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstname; 
	@FindBy(id = "last_name")
	private WebElement lastname;
	@FindBy(id = "address")
	private WebElement address;
	@FindBy(id = "cc_num")
	private WebElement cc;
	@FindBy(id = "cc_type")
	private WebElement cardType;
	@FindBy(id = "cc_exp_month")
	private WebElement month;
	@FindBy(id = "cc_exp_year")
	private WebElement year;
	@FindBy(id = "cc_cvv")
	private WebElement cvv;
	@FindBy(id = "book_now")
	private WebElement book;
	@FindBy(xpath = "//label[contains(text(),'First Name')]")
	private WebElement errFstname;
	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement errLstname;
	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement errAddress;
	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement errCardno;
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement errCardType;
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement errExpiry;
	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement errCvvno;
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement bookHotelSuccessMsg;
	
	
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCc() {
		return cc;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBook() {
		return book;
	}

	public WebElement getErrFstname() {
		return errFstname;
	}

	public WebElement getErrLstname() {
		return errLstname;
	}

	public WebElement getErrAddress() {
		return errAddress;
	}

	public WebElement getErrCardno() {
		return errCardno;
	}

	public WebElement getErrCardType() {
		return errCardType;
	}

	public WebElement getErrExpiry() {
		return errExpiry;
	}

	public WebElement getErrCvvno() {
		return errCvvno;
	}
	
	public WebElement getBookHotelSuccessMsg() {
		return bookHotelSuccessMsg;
	}

	/**
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param BillingAddress
	 * @param CreditCardNo
	 * @param CreditCardType
	 * @param SelectMonth
	 * @param SelectYear
	 * @param CVV
	 * @see bookHotel
	 */
	public void bookHotel(String FirstName, String LastName, String BillingAddress, String CreditCardNo, String CreditCardType, String SelectMonth, String SelectYear, String CVV) {
	
		WebElement firstname = getFirstname();
		elementSendKeys(firstname, FirstName);
		WebElement lastname = getLastname();
		elementSendKeys(lastname, LastName);
		WebElement address = getAddress();
		elementSendKeys(address, BillingAddress);
		WebElement cc = getCc();
		elementSendKeys(cc, CreditCardNo);
		WebElement cardType = getCardType();
		selectOptionByText(cardType, CreditCardType);
		WebElement month = getMonth();
		selectOptionByText(month, SelectMonth);
		WebElement year = getYear();
		selectOptionByText(year, SelectYear);
		WebElement cvv = getCvv();
		elementSendKeys(cvv, CVV);
		WebElement book = getBook();
		elementClick(book);
		
		implicitWait(50);
		
     }
	
   /**
    * @see bookHotel
    */
	public void bookHotel() {
	
		WebElement book = getBook();
		elementClick(book);
	}

}
