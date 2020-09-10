package com.qa.blazedemo.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.blazedemo.basepage.BasePage;
import com.qa.blazedemo.pagelayer.HomePage;
import com.qa.blazedemo.utils.Constants;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_browser(prop);
		homePage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		String title = homePage.pageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_HEADER_TITLE);
	}

	@Test(priority = 2)
	public void verifyHomePageTitleTest() {
		String text = homePage.homePageText();
		System.out.println(text);
		Assert.assertEquals(text, Constants.HOME_PAGE_HEADER_VALUE);
	}

	@Test(priority = 3)
	public void verifyFindFlightsTest() {
		homePage.findflight(Constants.DEPARTURE_CITY, Constants.DESTINATION_CITY);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}