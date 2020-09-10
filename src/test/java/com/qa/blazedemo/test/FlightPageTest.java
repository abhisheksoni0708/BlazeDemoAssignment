package com.qa.blazedemo.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.blazedemo.basepage.BasePage;
import com.qa.blazedemo.pagelayer.Flightpage;
import com.qa.blazedemo.pagelayer.HomePage;
import com.qa.blazedemo.utils.Constants;
import com.qa.blazedemo.utils.ExcelUtil;

public class FlightPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	Flightpage flightPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_browser(prop);
		homePage = new HomePage(driver);
		flightPage = homePage.findflight(Constants.DEPARTURE_CITY, Constants.DESTINATION_CITY);
	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		String bookingPageTitle = flightPage.bookingPageText();
		System.out.println(bookingPageTitle);
		Assert.assertEquals(bookingPageTitle, Constants.BOOKING_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifySelectFlightTest() {
		flightPage.selectFlight();
	}

	@Test(priority = 3)
	public void verifyflightBookingHeaderTextTest() {
		String FlightBookingPageText = flightPage.flightBookingHeaderText();
		System.out.println(FlightBookingPageText);
		Assert.assertEquals(FlightBookingPageText, Constants.FLIGHT_BOOKING_PAGE_TEXT);
	}

	@Test(priority = 4, dataProvider = "getBookingTestData")
	public void verifyflightBookingTest(String name, String address, String city, String state, String zipCode,
			String cardType, String creditCardNumber, String creditCardMonth, String creditCardYear, String cardName) {

		flightPage.bookFlight(name, address, city, state, zipCode, cardType, creditCardNumber, creditCardMonth,
				creditCardYear, cardName);
	}

	@Test(priority = 5)
	public void verifyBookingConfirmationTest() {
		String flightBookingConfirmationMessage = flightPage.bookingMessage();
		System.out.println(flightBookingConfirmationMessage);
		Assert.assertEquals(flightBookingConfirmationMessage, Constants.FLIGHT_BOOKING_CONFIRMATION_MESSAGE);

	}

	@Test(priority = 6)
	public void verifyBookingIdTest() {
		String Id = flightPage.bookingId();
		System.out.println(Id);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getBookingTestData() {
		Object[][] data = ExcelUtil.getTestData(Constants.FLIGHT_BOOKING_TEST_SHEET_NAME);
		return data;
	}

}
