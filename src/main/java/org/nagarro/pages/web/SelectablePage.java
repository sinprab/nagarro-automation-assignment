package org.nagarro.pages.web;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.utilities.ExtentTestManager;
import org.nagarro.utilities.CommonHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Select multiple items.
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-06-29
 */
public class SelectablePage extends CommonHelper {


	public static final Logger log = Logger.getLogger(SelectablePage.class.getName());
	//ExtentTest child;
	WebDriver driver;

	@FindBy(xpath = "//li/a[@href='https://jqueryui.com/demos/']")
	WebElement verifyHomePage;

	@FindBy(xpath = "//a[contains(text(),'Selectable')]")
	WebElement selectableButton;

	@FindBy(xpath = "//h1[@class='entry-title']")
	WebElement verifySelectabletitle;

	@FindBy(xpath = "//iframe[@src='/resources/demos/selectable/default.html']")
	WebElement selectFrame;

	@FindBy(xpath = "//ol[@id='selectable']/li")
	List<WebElement> listOfItems;

	@FindBy(id = "selectable")
	WebElement itemView;

	public SelectablePage() {
		this.driver =  DriverFactory.getDriver();;
		PageFactory.initElements(driver, this);
	}

	public void clickSelectableButton()
	{
		selectableButton.click();

		Assert.assertEquals("Selectable", verifySelectabletitle.getText());
		child.log(Status.INFO, "Selectable Button Clicked");
	}
	/**
	 * select multiple item in jquery ui and verify
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void selectItemTab(String itemsToSelect) throws InterruptedException, IOException {

		explicatWait(driver,selectFrame);
		driver.switchTo().frame(selectFrame);
		scrollView(driver, itemView);

		String[] inputItemList = itemsToSelect.split(",");
		List<WebElement> webElementList = new ArrayList<>();
		for (WebElement option : listOfItems) {

			for (int i = 0; i < inputItemList.length; i++) {
				if (option.getText().equals(inputItemList[i].toString())) {
					webElementList.add(option);
				}
			}
		}

		for (int i = 0; i < webElementList.size(); i++) {
			Actions builder = new Actions(driver);
			builder.keyDown(Keys.CONTROL).click(webElementList.get(i)).keyUp(Keys.CONTROL);
			Action selectMultiple = builder.build();
			selectMultiple.perform();
		}


	}
	public void verifyThatItemsAreSelected() throws IOException {

		child.log(Status.INFO, "Item selected - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "ItemSelected")).toString());

		log.info("Items selected successfully");
	}

}
