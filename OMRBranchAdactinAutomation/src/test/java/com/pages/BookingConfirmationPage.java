package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Ranjith
 * @see BookingConfirmationPage
 *
 */
public class BookingConfirmationPage extends BaseClass {
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="order_no")
	private WebElement getOrderId;
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	@FindBy(id = "order_id_text")
	private WebElement searchOrderId;
	@FindBy(id = "search_hotel_id")
	private WebElement goButton;
	@FindBy(xpath = "//input[@type='button']")
	private WebElement cancelButtonClick;
	@FindBy(id="search_result_error")
	private WebElement cancelledSuccessMsg;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement bookingConfirmSuccessMsg;
	

	public WebElement getGetOrderId() {
		return getOrderId;
	}
	

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}


	public WebElement getSearchOrderId() {
		return searchOrderId;
	}


	public WebElement getGoButton() {
		return goButton;
	}


	public WebElement getCancelButtonClick() {
		return cancelButtonClick;
	}


	public WebElement getCancelledSuccessMsg() {
		return cancelledSuccessMsg;
	}


	public WebElement getBookingConfirmSuccessMsg() {
		return bookingConfirmSuccessMsg;
	}

	/**
	 * @see getOrderId
	 */
	public void getOrderId() {
		WebElement orderId = getGetOrderId();
		String text = elementGetAttribute(orderId);
		System.out.println(text);
		WebElement bookedItinerary = getBookedItinerary();
		elementClick(bookedItinerary);

		WebElement searchOrderId = getSearchOrderId();
		elementSendKeys(searchOrderId, text);

		WebElement goButton = getGoButton();
		elementClick(goButton);

		WebElement cancelButtonClick = getCancelButtonClick();
		elementClick(cancelButtonClick);

		clickOkInAlert();

	}

}
