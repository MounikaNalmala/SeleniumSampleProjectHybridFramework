package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.base.BasePage;
import com.qa.util.ElementActions;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;

	// OR:
	By LocationMenuBtn = By.id("menuButton2");

	public HomePage() {
		//default Constructor
	}
	
	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	public LocationPage clickOnLocationLink() {
		elementActions.getElement(LocationMenuBtn).click();
		return new LocationPage();
	}

	public void clickOnLocationBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(elementActions.getElement(LocationMenuBtn)).build().perform();
	}

}