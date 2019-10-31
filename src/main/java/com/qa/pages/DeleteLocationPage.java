package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.BasePage;
import com.qa.util.ElementActions;

public class DeleteLocationPage extends BasePage {
	WebDriver driver;
	ElementActions elementActions;
	Actions actions = new Actions(driver);


	// OR:
	By clickdeleteLocation = By.xpath("//button[contains(text(),'Delete')]");
	By addLocationBtn = By.xpath("//*[contains(@class,'btn btn--l btn--white btn--icon ng-isolate-scope')][2]");
	By deleteLocations = By.xpath("//*[contains(@class,'truncate notranslate ng-binding')]");
	By deleteLocationBtn = By.xpath("//*[contains(@class,'icon icon--s icon--grey icon--flat mdi mdi-delete')");
	By mouseDelete = By.xpath("//*[contains(@class,'list-row-actions-group pr++')][1]");
	By alerDelete = By.xpath("//*[contains(text(),'Delete')]");
	By dialogBox = By.xpath("//*[contains(@class,'dialog dialog--alert dialog--is-shown')]");


	public DeleteLocationPage() {
		// TODO Auto-generated constructor stub
	}

	// Initializing the Page Objects:
	public DeleteLocationPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	public DeleteLocationPage deleteLocationPage() {
		WebElement deleteElement;
		String deleteXpath;
		List<WebElement> getdeleteLocations = driver.findElements(deleteLocations);
		List<WebElement> getdeleteLocationsBtn = driver.findElements(deleteLocationBtn);

	
		deleteElement = getdeleteLocations.get(0);
		//elementActions.waitForElementClickable(deleteElement);

		actions.moveToElement(deleteElement).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.click(getdeleteLocationsBtn.get(0)).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementActions.waitForElementClickable(alerDelete);
			elementActions.doClick(alerDelete);
		actions.moveToElement(driver.findElement(dialogBox)).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.click(driver.findElement(alerDelete)).perform();
		System.out.println(driver.findElement(alerDelete).getText());
		return new DeleteLocationPage();
	}

}
