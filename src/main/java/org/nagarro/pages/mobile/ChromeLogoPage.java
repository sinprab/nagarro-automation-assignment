package org.nagarro.pages.mobile;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.utilities.CommonHelper;
import org.nagarro.utilities.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

/**
 * Add name and car details in chrome and verify
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-07-03
 */
public class ChromeLogoPage extends CommonHelper {

	public static final Logger log = Logger.getLogger(ChromeLogoPage.class.getName());

	@FindBy(id = "android:id/title")
	public WebElement homepageTitle;

	@FindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
	public WebElement chromeLogoButton;

	@FindBy(xpath = "//android.view.View[@package='io.selendroid.testapp']")
	public WebElement verifyFormPage;

	@FindBy(xpath = "//android.widget.EditText[@package='io.selendroid.testapp']")
	public WebElement nameInput;

	@FindBy(xpath = "//android.widget.Spinner[@package='io.selendroid.testapp'][@scrollable='false']")
	public WebElement selectCarButton;

	@FindBy(xpath = "//android.view.View[@index='0']")
	public WebElement verifyFormPageHeading;

	// Verify added name
	@FindBy(xpath = "//android.view.View[@index='3']")
	public WebElement verifyAddedName;

	// Verify Added car
	@FindBy(xpath = "//android.view.View[@index='5']")
	public WebElement verifyAddedCar;

	@FindBy(xpath = "//android.view.View[@index='9']")
	public WebElement StartAgainButton;
	AndroidDriver driver;

	public ChromeLogoPage() {
		this.driver = DriverFactory.getAndroidDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Tap on Chrome Logo Button
	 */
	public void tapOnChromeLogoButton()
	{
		explicatWait(driver, chromeLogoButton);

		chromeLogoButton.click();
		child.log(Status.INFO, "tapped on Chorome Logo successfully !! ");
	}

	/**
	 * Verify Hello, can you please tell me your name? text
	 */
	public void verifyTheTellNameText(String textToVerify)
	{
		explicatWait(driver, driver.findElement(By.id("io.selendroid.testapp:id/tableRowWebview")));
		verifyFormPage = driver.findElement(By.xpath("//android.widget.TextView[@text='"+textToVerify+"']"));
		if(textToVerify.equals(verifyFormPage.getText())) {
			child.log(Status.PASS, textToVerify + " :: Verified text successfully !! ");
			Assert.assertTrue(true);
		}
		else {
			child.log(Status.FAIL, textToVerify + " not mactched with :: "+verifyFormPage.getText());
			Assert.assertTrue(false);
		}
	}

	/**
	 * Enter name in the textbox
	 * @param name
	 */
	public void enterNameInTheTextBox(String name)
	{
		nameInput.click();
		nameInput.clear();
		nameInput.sendKeys(name);
		child.log(Status.INFO, "Name entered is - " + name);
	}
	/**
	 * Select Preffered Car
	 * @param carName
	 */
	public void selectPrefferedCar(String carName) throws IOException {

		selectCarButton.click();

		String carValue = "//android.widget.CheckedTextView[@package='io.selendroid.testapp'][@text='" + carName + "']";
		driver.findElement(By.xpath(carValue)).click();
		child.log(Status.INFO, "Car name entered is - " + carName);
		child.log(Status.INFO, "Item selected - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "ItemSelected")).toString());

	}

	public void tapOnSendMeYourName()
	{
		driver.findElement(By.xpath("//android.widget.Button[@text='Send me your name!']")).click();

	}

	public void verifyTheTextMyWaySayingHello(String textToVerify)
	{
		waitUntilInvisibilityAndroid(verifyFormPageHeading,driver);

		//verifyFormPageHeading = driver.findElement(By.xpath("//android.view.View[@text='"+textToVerify+"']"));
		if(textToVerify.equals(verifyFormPageHeading.getText())) {
			child.log(Status.PASS, textToVerify + " :: Verified text successfully !! ");
			Assert.assertTrue(true);
		}
		else {
			child.log(Status.FAIL, textToVerify + " not mactched with :: "+verifyFormPageHeading.getText());
			Assert.assertTrue(false);
		}

	}

	public void verifyNameAndCarName(String name, String carName) throws IOException {
		String expextedName = "\"" + name + "\"";

		// assert added name
		verifyAddedName = driver.findElement(By.xpath("//android.widget.TextView[@text='\""+name+"\"']"));
		assertEquals(expextedName, verifyAddedName.getText());

		// Assert added car
		carName = carName.toLowerCase();
		String expextedCar = "\"" + carName + "\"";
		verifyAddedCar =  driver.findElement(By.xpath("//android.widget.TextView[@text='\""+carName+"\"']"));
		assertEquals(expextedCar, verifyAddedCar.getText());

		child.log(Status.INFO, "Added data in chrome logo verification - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "ChromeLogoAddedData")).toString());

		child.log(Status.PASS, "Verified heading, name and car name");

	}
	public void clickLinkHere()  {


		StartAgainButton.click();
		child.log(Status.INFO, "Clicked link <here>");

	}

}