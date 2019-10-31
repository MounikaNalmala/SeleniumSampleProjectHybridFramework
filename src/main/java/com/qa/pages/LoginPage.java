package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.util.ElementActions;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;

	// OR:
	By username = By.id("username");
	By password = By.id("pword");
	By loginBtn = By.xpath("//button[contains(text(),'Sign In')]");
	By startTrial = By.xpath("//a[contains(text(),'Start a free trial')]");
	By signInHelp = By.xpath("//a[contains(text(),'Sign-in Help')]");
	By tractionLogo = By.xpath("//img[contains(@alt,'Traction Guest')]");

	// Initializing the Page Objects:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	// Actions:
	public String validateLoginPageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public boolean validateTractionImage() {
		return elementActions.isElementDisplayed(tractionLogo);
	}

	public HomePage doLogin(String un, String pwd) {
		elementActions.doSendKeys(username, un);
		elementActions.doSendKeys(password, pwd);
		elementActions.getElement(loginBtn).click();
		return new HomePage();
	}

}