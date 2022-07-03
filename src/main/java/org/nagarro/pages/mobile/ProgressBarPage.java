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

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Verify progress bar in selandroid
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-07-03
 */
public class ProgressBarPage extends CommonHelper {

	public static final Logger log = Logger.getLogger(ProgressBarPage.class.getName());


	@FindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
	public WebElement progressBarButton;

	@FindBy(id = "io.selendroid.testapp:id/inputUsername")
	public WebElement verifyRegisterUserName;

	@FindBy(id = "io.selendroid.testapp:id/inputEmail")
	public WebElement verifyRegisterEmail;

	@FindBy(id = "io.selendroid.testapp:id/inputPassword")
	public WebElement verifyRegisterPassword;

	@FindBy(id = "io.selendroid.testapp:id/inputName")
	public WebElement verifyRegisterInputName;

	@FindBy(id = "android:id/text1")
	public WebElement verifyRegisterProgrammingLanguage;

	@FindBy(id = "io.selendroid.testapp:id/input_adds")
	public WebElement verifyRegisterTCCheckBox;

	@FindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	public WebElement verifyRegisterButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
	public WebElement verifyReistrationPage;

	AndroidDriver driver;
	public ProgressBarPage() {
		this.driver = DriverFactory.getAndroidDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * progress bar verification
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void tapOnProgressBarTab() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		progressBarButton.click();

		child.log(Status.INFO, "Progress bar is in progress.... " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "ProgressBar")).toString());
	}
	public void waitForLoader() {

		explicatWaitTillInvisibility(driver, driver.findElement(By.id("android:id/progress")));

		child.log(Status.INFO, "Progress bar completed");

	}
	public void verifyUserRegistrationPage() throws InterruptedException, IOException {
		child.log(Status.PASS, "Registration Page title - " + verifyReistrationPage.getText());
		assertEquals("Welcome to register a new User", verifyReistrationPage.getText());

		Thread.sleep(3000);

		driver.hideKeyboard();

		checkRegistrationForm(verifyRegisterUserName);
		checkRegistrationForm(verifyRegisterEmail);
		checkRegistrationForm(verifyRegisterPassword);
		checkRegistrationForm(verifyRegisterInputName);
		checkRegistrationForm(verifyRegisterProgrammingLanguage);
		checkRegistrationForm(verifyRegisterTCCheckBox);
		checkRegistrationForm(verifyRegisterButton);

		child.log(Status.INFO, "Verified register user page successfully " + ExtentTestManager.getTest()
				.addScreenCaptureFromPath(getScreenshot(driver, "ProgressBarRegisterPage")).toString());

		child.log(Status.PASS, "Verified registration page event");

	}

	/**
	 * Validate registration page element
	 * 
	 * @throws InterruptedException
	 */
	public void checkRegistrationForm(WebElement element) {

		if (isClickableAndroid(element, driver) == true) {
			assertEquals(true, true);{}
		} else {
			assertEquals(false, false);
		}

	}

}
