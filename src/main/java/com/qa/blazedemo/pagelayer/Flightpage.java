package com.qa.blazedemo.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.blazedemo.utils.ElementUtil;

public class Flightpage {

	WebDriver driver;
	ElementUtil elementUtil;

	By flightPageText = By.tagName("h3");
	By chooseFlight = By.xpath("//form[@name='AL969']//following-sibling::td//input[@type='submit']");
	By flightBookingText = By.tagName("h2");
	By name = By.id("inputName");
	By address = By.id("address");
	By city = By.id("city");
	By state = By.id("state");
	By zipCode = By.id("zipCode");
	By cardType = By.id("cardType");
	By creditCardNumber = By.id("creditCardNumber");
	By creditCardMonth = By.id("creditCardMonth");
	By creditCardYear = By.id("creditCardYear");
	By cardName = By.id("nameOnCard");
	By purchaseFlightBtn = By.xpath("//input[@type='submit']");
	By confirmationMessage = By.tagName("h1");
	By bookingId = By.xpath("//td[contains(text(),'Id')]//following-sibling::td");

	public Flightpage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String bookingPageText() {
		elementUtil.waitForElementPresence(10, flightPageText);
		return elementUtil.doGetText(flightPageText);
	}

	public void selectFlight() {
		elementUtil.doClick(chooseFlight);
	}

	public String flightBookingHeaderText() {
		elementUtil.waitForElementPresence(10, flightBookingText);
		return elementUtil.doGetText(flightBookingText);
	}

	public void bookFlight(String name, String address, String city, String state, String zipCode, String cardType,
			String creditCardNumber, String creditCardMonth, String creditCardYear, String cardName) {
		elementUtil.doSendKeys(this.name, name);
		elementUtil.doSendKeys(this.address, address);
		elementUtil.doSendKeys(this.city, city);
		elementUtil.doSendKeys(this.state, state);
		elementUtil.doSendKeys(this.zipCode, zipCode);
		elementUtil.doSelectDropDownByValue(this.cardType, cardType);
		elementUtil.doSendKeys(this.creditCardNumber, creditCardNumber);
		elementUtil.doSendKeys(this.creditCardMonth, creditCardMonth);
		elementUtil.doSendKeys(this.creditCardYear, creditCardYear);
		elementUtil.doSendKeys(this.cardName, cardName);
		elementUtil.doClick(purchaseFlightBtn);
	}

	public String bookingMessage() {
		return elementUtil.doGetText(confirmationMessage);
	}

	public String bookingId() {
		return elementUtil.doGetText(bookingId);
	}
}
