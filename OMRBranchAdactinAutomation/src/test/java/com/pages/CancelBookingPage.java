package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


/**
 * 
 * @author Ranjith
 * @see CancelBookingPage
 *
 */
public class CancelBookingPage extends BaseClass {

	// 1.booking---> orderId--->cancel booking--->The booking has been cancelled
	// 2.existing order id -->cancel booking --->The booking has been cancelled

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

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

	/**
	 * 
	 * @param orderid
	 * @see cancelOrderId
	 */
	public void cancelOrderId(String orderid) {

		WebElement bookedItinerary = getBookedItinerary();
		elementClick(bookedItinerary);

		WebElement searchOrderId = getSearchOrderId();
		elementSendKeys(searchOrderId, orderid);

		WebElement goButton = getGoButton();
		elementClick(goButton);

		WebElement cancelButtonClick = getCancelButtonClick();
		elementClick(cancelButtonClick);

		clickOkInAlert();
	}

}
