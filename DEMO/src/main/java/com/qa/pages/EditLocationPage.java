package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class EditLocationPage extends BasePage{
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement clickdeleteLocation;
	
	WebDriverWait wait = new WebDriverWait(driver, 50);

	Actions actions = new Actions(driver);

	// Initializing the Page Objects:
	public EditLocationPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDeleteLocation() {
		clickdeleteLocation.click();
	}

}
