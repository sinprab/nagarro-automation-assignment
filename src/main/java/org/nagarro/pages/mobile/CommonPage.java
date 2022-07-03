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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;
import static org.testng.Assert.assertEquals;

/**
 * Test toast, popup window and exceptions
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-07-03
 */
public class CommonPage extends CommonHelper {

	public static final Logger log = Logger.getLogger(CommonPage.class.getName());

	@FindBy(id = "io.selendroid.testapp:id/showToastButton")
	public WebElement showToastButton;

	@FindBy(xpath = "/hierarchy/android.widget.Toast")
	public WebElement verifyToastText;

	@FindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
	public WebElement showPopupWindowButton;

	@FindBy(id = "io.selendroid.testapp:id/exceptionTestButton")
	public WebElement exceptionTestButton;

	@FindBy(id = "io.selendroid.testapp:id/exceptionTestField")
	public WebElement exceptionTestField;

	AndroidDriver driver;
	public CommonPage() {
		this.driver = DriverFactory.getAndroidDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * verify Displays a toast.
	 * 
	 * @throws IOException
	 *
	 */
	public void tapOnToastButton() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		child.log(Status.INFO, "Click on toast button");

		showToastButton.click();

		child.log(Status.INFO, "Clicked on toast button - " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "Toast button")).toString());
	}
	public void verifyDisplaysAToast() throws IOException {

		WebDriverWait waitForToast = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));

		assertEquals("Hello selendroid toast!", verifyToastText.getText());

		child.log(Status.INFO, "Toast text verified is - " + verifyToastText.getText());

	}

	/**
	 * verify Displays a popup.
	 *
	 * @exception InterruptedException
	 * @throws IOException
	 */
	public void tapOnDispalyPopUp() throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		showPopupWindowButton.click();

		child.log(Status.INFO, "Pop message is - displayed " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "Popupmessage")).toString());

	}
	public void dismissDisplaysPopup() throws InterruptedException, IOException {

		tapByCoordinates(550, 1063);

	}

	/**
	 * verify unhandled Exception when clicking on button
	 *
	 */
	public void verifyUnhandledException() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		child.log(Status.INFO, "Click on unhandled exception");

		try {
			exceptionTestButton.click();
		} catch (Exception e) {
			// assert.fail(e.printstackTrace);
			child.log(Status.INFO, "Error log - " + e.toString());
		}
	}

	/**
	 * verify unhandled exception by sending text
	 *
	 */
	public void verifyTypeAndUnhandledException(String test) throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		child.log(Status.INFO, "Pass 'test' text in input field ");

		try {
			exceptionTestField.sendKeys(test);

		} catch (Exception e) {

			log.info("Error log - " + e.toString());

		}

	}

	@SuppressWarnings("rawtypes")
	public void tapByCoordinates(int x, int y) {
		//new TouchAction(PerformsTouchActions performsTouchActions) (driver).tap(point(x, y)).waitAction(waitOptions(Duration.ofMillis(250))).perform();

	}

}
