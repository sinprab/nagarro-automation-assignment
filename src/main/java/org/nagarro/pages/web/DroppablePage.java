package org.nagarro.pages.web;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.utilities.ExtentTestManager;
import org.nagarro.utilities.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

/**
 * Drag and Drop in jqueryui
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-06-29
 */

public class DroppablePage extends CommonHelper {

	public static final Logger log = Logger.getLogger(DroppablePage.class.getName());
	//ExtentTest child;
	WebDriver driver;


	@FindBy(xpath = "//li/a[@href='https://jqueryui.com/demos/']")
	WebElement verifyHomePage;

	@FindBy(xpath = "//a[contains(text(),'Droppable')]")
	WebElement droppableButton;

	@FindBy(xpath = "//h1[@class='entry-title']")
	WebElement verifyDroppabletitle;

	@FindBy(xpath = "//iframe[@src='/resources/demos/droppable/default.html']")
	WebElement dragDropFrame;

	@FindBy(id = "draggable")
	WebElement dragSource;

	@FindBy(id = "droppable")
	WebElement dragDestination;

	@FindBy(xpath = "//div[@id='droppable']/p")
	WebElement verifyDroppedSuccess;

	public DroppablePage()
	{
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);

	//	this.child=ExtentTestManager.getTest();
	}

	/**
	 * Verify Home Page
	 *
	 * @throws InterruptedException
	 */

	public void verifyHomePage()  throws InterruptedException
	{
		explicatWait(driver, verifyHomePage);

		Assert.assertEquals("Demos", verifyHomePage.getText());
		child.log(Status.INFO, "Home Page Verified");
	}

	/**
	 * Drag and Drop element in jquery ui and verify
	 *
	 * @throws InterruptedException
	 */
	public void clickDroppableButton()throws InterruptedException
	{

		droppableButton.click();

		Assert.assertEquals("Droppable", verifyDroppabletitle.getText());
		child.log(Status.INFO, "Droppable button clicked successfully");

	}


	/**
	 * Drag and Drop element in jquery ui and verify
	 *
	 * @throws InterruptedException
	 */


	public void dragDropInDroppableInteraction() throws InterruptedException {

		driver.switchTo().frame(dragDropFrame);
		scrollView(driver, dragSource);
		Actions act = new Actions(driver);
		act.dragAndDrop(dragSource, dragDestination).build().perform();

	}
	/**
	 * Verify Drag and Drop element in jquery ui and verify
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void verifyDragDropInDroppableInteraction()  throws IOException, InterruptedException  {

		Assert.assertEquals("Dropped!", verifyDroppedSuccess.getText());

		log.info("Dragged and Dropped successfully");
		child.log(Status.INFO, "Dragged and Dropped successfully");

		child.log(Status.INFO, "Dragged and Dropped - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "DraggedDropped")).toString());

	}

}
