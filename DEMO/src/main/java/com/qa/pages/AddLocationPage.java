package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.util.ElementActions;

public class AddLocationPage extends BasePage {
	// *[contains(@class,'btn btn--l btn--white btn--icon ng-isolate-scope')][2]
	WebDriver driver;
	ElementActions elementActions;

	// OR:
	By locationName = By.xpath("//*[contains(@class,'ng-pristine ng-valid ng-scope text-field__input ng-empty ng-touched')]");
	By locationType = 	By.xpath("//*[contains(text(),'Lobby')]");
	By selectLocationGroup = 	By.id("lx-select-selected-wrapper-156A2935-4FE5-47B8-AF41-F368F3AFADDE");
	By okBtn = 	By.xpath("//*[contains(text(),'OK')]");
	
	public AddLocationPage() {
		//default Constructor
	}
	
	// Initializing the Page Objects:
	public AddLocationPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}


	public CreateInvitesPage clickOnCreateLocationLink() {
		elementActions.waitForVisibilityOfElement(locationName);
		elementActions.doSendKeys(locationName,"13");
		elementActions.getElement(locationName).click();
		elementActions.doClickByActions(okBtn);
		return new CreateInvitesPage();
	}

}
