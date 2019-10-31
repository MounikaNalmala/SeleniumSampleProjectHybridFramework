package com.traction.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.HomePage;
import com.qa.pages.LocationPage;
import com.qa.pages.LoginPage;

public class HomePageTest extends BasePage {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	LocationPage locationPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyContactsLinkTest(){
     	 locationPage = homePage.clickOnLocationLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}