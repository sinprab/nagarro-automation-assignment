package org.nagarro.pages.web;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.utilities.ExtentTestManager;
import org.nagarro.utilities.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

/**
 * Control group in jqueryui.
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-06-29
 */
public class ControlgroupPage extends CommonHelper {

	public static final Logger log = Logger.getLogger(ControlgroupPage.class.getName());

	@FindBy(xpath = "//li/a[@href='https://jqueryui.com/demos/']")
	WebElement verifyHomepage;

	@FindBy(xpath = "//a[contains(text(),'Controlgroup')]")
	WebElement controlgroupButton;

	@FindBy(xpath = "//h1[@class='entry-title']")
	WebElement verifyControlgrouptitle;

	@FindBy(xpath = "//iframe[@src='/resources/demos/controlgroup/default.html']")
	WebElement selectControlgroupFrame;

	@FindBy(id = "car-type-button")
	WebElement compactCarDropDownButton;

	@FindBy(id = "horizontal-spinner")
	WebElement horizontalNumberOfCarsInput;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//span[@id='ui-id-8-button']")
	WebElement compactCarDropDownVerticalButton;

	@FindBy(id = "vertical-spinner")
	WebElement verticalNumberOfCarsInput;

	@FindBy(xpath = "//label[@for='insurance'][@class='ui-button ui-widget ui-checkboxradio-label ui-controlgroup-item']")
	WebElement HorizontalInsuranceCheckbox;

	@FindBy(xpath = "//label[@for='insurance-v'][@class='ui-button ui-widget ui-checkboxradio-label ui-controlgroup-item']")
	WebElement VerticalInsuranceCheckbox;

	@FindBy(id = "book")
	WebElement bookButton;

	WebDriver driver;
	public ControlgroupPage() {
		this.driver =  DriverFactory.getDriver();;
		PageFactory.initElements(driver, this);
	}

	public void clickOnControlGroupButton()
	{
		controlgroupButton.click();

		Assert.assertEquals("Controlgroup", verifyControlgrouptitle.getText());
	}
	/**
	 * Fill rent car details in control group
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void controlgroupTab(String carType, String transmissionType, String numberofCar) throws InterruptedException, IOException {


		driver.switchTo().frame(selectControlgroupFrame);

		scrollView(driver, compactCarDropDownButton);

		compactCarDropDownButton.click();

		String selectCompactCar = "//ul[@aria-labelledby='car-type-button']/li/div[contains(text(),'" + carType
				+ "')]";
		driver.findElement(By.xpath(selectCompactCar)).click();

		String transmissionType1 = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//label[@class='ui-button ui-widget ui-checkboxradio-radio-label ui-checkboxradio-label ui-controlgroup-item'][contains(text(),'"
				+ transmissionType + "')]";
		driver.findElement(By.xpath(transmissionType1)).click();

		if (isClickableWeb(HorizontalInsuranceCheckbox, driver)) {
			HorizontalInsuranceCheckbox.click();
		} else {
			log.info("Checkbox already clicked");
		}

		horizontalNumberOfCarsInput.sendKeys(numberofCar);

		compactCarDropDownVerticalButton.click();

		bookButton.click();

		child.log(Status.INFO, "Contro group url - " + driver.getCurrentUrl());
		log.info("Current URL - " + driver.getCurrentUrl());

		child.log(Status.INFO, "Control group - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "ControlGroup")).toString());

	}

}
