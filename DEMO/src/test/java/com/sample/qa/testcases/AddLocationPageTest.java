package com.traction.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.AddLocationPage;
import com.qa.pages.CreateInvitesPage;
import com.qa.pages.HomePage;
import com.qa.pages.LocationPage;
import com.qa.pages.LoginPage;

public class AddLocationPageTest extends BasePage {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	LocationPage locationPage;
	AddLocationPage addLocationPage;
	CreateInvitesPage createInvitesPage;
	
	public AddLocationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		locationPage = homePage.clickOnLocationLink();
    	addLocationPage = locationPage.clickOnCreateLocation();
	}
	
	@Test(priority=1)
	public void verifyCreateLocationTest(){
		createInvitesPage = addLocationPage.clickOnCreateLocationLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
