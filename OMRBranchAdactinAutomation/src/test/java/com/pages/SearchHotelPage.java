package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Ranjith
 * @see SearchHotelPage
 *
 */
public class SearchHotelPage extends BaseClass {

	// 1.By select all fields
	// 3.Date checking
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
		}

			
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement roomno;
	
	@FindBy(id="datepick_in")
	private WebElement pickDate;
	
	@FindBy(id="datepick_out")  
	private WebElement outDate;
	
	@FindBy(name="adult_room")            
	private WebElement adult;
	
	@FindBy(name="child_room")
	private WebElement child;
	
	@FindBy(id="Submit")
	private WebElement submit;
	
	@FindBy(id="username_show")
	private WebElement textLoginMsg;
	
	@FindBy(id="checkin_span")
	private WebElement errorcheckin;
	
	@FindBy(id="checkout_span")
	private WebElement errorcheckout;
	
	@FindBy(id="location_span")
	private WebElement errorlocation;
	
	@FindBy(xpath="//span[text()='Please Select a Location']")
	private WebElement adactin;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomno() {
		return roomno;
	}

	public WebElement getPickDate() {
		return pickDate;
	}

	public WebElement getOutDate() {
		return outDate;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	
	public WebElement getTextLoginMsg() {
		return textLoginMsg;
	}

	public WebElement getErrorcheckin() {
		return errorcheckin;
	}

	public WebElement getErrorcheckout() {
		return errorcheckout;
	}

	public WebElement getErrorlocation() {
		return errorlocation;
	}

	public WebElement getAdactin() {
		return adactin;
	} 
	
	
	/**
	 * 
	 * @param Locations
	 * @param Hotels
	 * @param RoomType
	 * @param NoOfRooms
	 * @param CheckinDate
	 * @param CheckoutDate
	 * @param Adultsperroom
	 * @param Childrensperroom
	 * @see searchHotels
	 */
	public void searchHotels(String Locations, String Hotels, String RoomType, String NoOfRooms, String CheckinDate,String CheckoutDate, String Adultsperroom, String Childrensperroom) {

		WebElement location = getLocation();
		selectOptionByText(location, Locations);

		WebElement hotel = getHotel();
		selectOptionByText(hotel, Hotels);

		WebElement roomType = getRoomType();
		selectOptionByText(roomType, RoomType);

		WebElement roomNo = getRoomno();
		selectOptionByText(roomNo, NoOfRooms);

		WebElement pickDate = getPickDate();
		elementClear(pickDate);
		elementSendKeys(pickDate, CheckinDate);

		WebElement outDate = getOutDate();
		elementClear(outDate);
		elementSendKeys(outDate, CheckoutDate);

		WebElement adult =getAdult();
		selectOptionByText(adult, Adultsperroom);

		WebElement child = getChild();
		selectOptionByText(child, Childrensperroom);

		WebElement submit = getSubmit();
		elementClick(submit);
		
		
	}

	/**
	 * 
	 * @param Locations
	 * @param NoOfRooms
	 * @param CheckinDate
	 * @param CheckoutDate
	 * @param Adultsperroom
	 * @see searchHotels
	 */
	// 2.Verify Mandatory Fields
	public void searchHotels(String Locations, String NoOfRooms, String CheckinDate, String CheckoutDate,String Adultsperroom) {

		WebElement location = getLocation();
		selectOptionByText(location, Locations);


		WebElement roomNo = getRoomno();
		selectOptionByText(roomNo, NoOfRooms);
		
		WebElement pickDate = getPickDate();
		elementSendKeys(pickDate, CheckinDate);

		WebElement outDate = getOutDate();
		elementSendKeys(outDate, CheckoutDate);
		
		WebElement adult =getAdult();
		selectOptionByText(adult, Adultsperroom);
		
		WebElement submit = getSubmit();
		elementClick(submit);
		
		

	}
	
	/**
	 * @see searchHotels
	 */
	//4.Without enter any fields
	
	public void searchHotels() {
	
		WebElement submit = getSubmit();
		elementClick(submit);
		
		
	}
	
	

	
}
