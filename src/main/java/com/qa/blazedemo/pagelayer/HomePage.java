package com.qa.blazedemo.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.blazedemo.basepage.BasePage;
import com.qa.blazedemo.utils.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By departureCity = By.name("fromPort");
	By destinationCity = By.name("toPort");
	By findButton = By.xpath("//input[@type='submit']");
	By pageText = By.tagName("h1");
	By flightPageText = By.tagName("h3");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String homePageText() {
		return elementUtil.doGetText(pageText);
	}

	public Flightpage findflight(String depCity, String desCity) {
		elementUtil.doSelectDropDownByValue(departureCity, depCity);
		elementUtil.doSelectDropDownByVisibleText(destinationCity, desCity);
		elementUtil.doClick(findButton);
		return new Flightpage(driver);
	}
}
