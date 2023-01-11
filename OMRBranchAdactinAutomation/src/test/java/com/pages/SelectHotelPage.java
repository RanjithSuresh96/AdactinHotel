package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Ranjith
 * @see SelectHotelPage
 *
 */
public class SelectHotelPage extends BaseClass {

	// 1.By select Hotel name

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "radiobutton_0")
	private WebElement circleSelect;
	@FindBy(id = "continue")
	private WebElement conti;
	@FindBy(id="radiobutton_span")
	private WebElement errorContinueClick;
	@FindBy(className="login_title")
	private WebElement selectHotelTitle;

	public WebElement getCircleSelect() {
		return circleSelect;
	}

	public WebElement getConti() {
		return conti;
	}
	

	public WebElement getErrorContinueClick() {
		return errorContinueClick;
	}

	public WebElement getSelectHotelTitle() {
		return selectHotelTitle;
	}

	/**
	 * @see selectHotel
	 */
	public void selectHotel() {

		WebElement circleSelect = getCircleSelect();
		elementClick(circleSelect);
		WebElement conti = getConti();
		elementClick(conti);
	}

	/**
	 * @see clickContinue
	 */
	// 2.without select hotel click continue

	public void clickContinue() {

		WebElement conti = getConti();
		elementClick(conti);
	}

}
