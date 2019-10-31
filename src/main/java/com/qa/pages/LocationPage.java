package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;

public class LocationPage extends BasePage {

	@FindBy(xpath = "//*[contains(text(),'New Group')]")
	WebElement createLocationBtn;

	@FindBy(xpath = "//*[contains(@class,'ng-pristine ng-valid ng-scope text-field__input ng-empty ng-touched')]")
	WebElement locationGrpName;

	@FindBy(xpath = "//*[contains(text(),'OK')]")
	WebElement okBtn;

	@FindBy(xpath = "//*[contains(@class,'btn btn--l btn--white btn--icon ng-isolate-scope')][2]")
	WebElement addLocationBtn;

	@FindBy(xpath = "//*[contains(@class,'truncate notranslate ng-binding')]")
	List<WebElement> deleteLocations;

	@FindBy(xpath = "//*[contains(@class,'icon icon--s icon--grey icon--flat mdi mdi-delete')]")
	List<WebElement> deleteLocationBtn;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement clickdeleteLocation;

	@FindBy(xpath = "//*[contains(@class,'list-row-actions-group pr++')][1]")
	WebElement mouseDelete;

	@FindBy(xpath = "//*[contains(text(),'Delete')]")
	WebElement alerDekete;

	@FindBy(xpath = "//*[contains(@class,'dialog dialog--alert dialog--is-shown')]")
	WebElement dialogBox;

	WebDriverWait wait = new WebDriverWait(driver, 50);

	Actions actions = new Actions(driver);

	// Initializing the Page Objects:
	public LocationPage() {
		PageFactory.initElements(driver, this);
	}

	public AddLocationPage clickOnCreateLocationGroup() {
		createLocationBtn.click();
		wait.until(ExpectedConditions.visibilityOf(locationGrpName));
		locationGrpName.sendKeys("13");
		okBtn.click();
		return new AddLocationPage();
	}

	public AddLocationPage clickOnCreateLocation() {
		wait.until(ExpectedConditions.visibilityOf(addLocationBtn));
		addLocationBtn.click();
		return new AddLocationPage();
	}

	public DeleteLocationPage deleteLocationPage() {
		WebElement deleteElement;
		String deleteXpath;
		deleteElement = deleteLocations.get(4);
		wait.until(ExpectedConditions.elementToBeClickable(deleteElement));

		actions.moveToElement(deleteElement).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.click(deleteLocationBtn.get(4)).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(alerDekete));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alerDekete.getText();
		System.out.println(alerDekete.isDisplayed());
		alerDekete.click();
		actions.moveToElement(dialogBox).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.click(alerDekete).perform();
		System.out.println(alerDekete.getText());
		return new DeleteLocationPage();
	}
}
