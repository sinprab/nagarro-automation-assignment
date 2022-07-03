package org.nagarro.pages.mobile;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.utilities.CommonHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/**
 * verify user is in homepage
 *
 * @author Prabhat Ranjan Singh
 * @version 1.0
 * @since 2022-07-03
 */
public class HomePage extends CommonHelper {

	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	@FindBy(id = "android:id/button1")
	WebElement popoupButton;

	@FindBy(id = "android:id/title")
	WebElement homepageTitle;

	@FindBy(id = "io.selendroid.testapp:id/buttonTest")
	WebElement enButton;

	@FindBy(id = "android:id/button2")
	WebElement EndActivityNoButton;

	AndroidDriver driver ;
	public HomePage() {
		this.driver = DriverFactory.getAndroidDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Accept popup if present
	 * 
	 */
	public void acceptHomePagePopUp() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		if (popoupButton.isDisplayed()) {
			popoupButton.click();
			child.log(Status.INFO,"Popup was present, hence it was accepted to move forward ");
		}

	}

	/**
	 * Verify homepage title
	 *
	 */

	public void verifyHomePageTitle()
	{
		try {
			if (homepageTitle.getText().equals("selendroid-test-app")) {
				child.log(Status.PASS, "Home Page Title is :: selendroid-test-app ");
				log.info("Homepage title is - " + homepageTitle.getText());
			} else {
				child.log(Status.FAIL, "Home Page Title is not :: selendroid-test-app but it found to be  " + homepageTitle.getText());
			}
		}
		catch (Exception e)
		{
			child.log(Status.FAIL, "Exception occurred while accessing home page title <textarea> "+e+"</textarea>");
		}
	}

	/**
	 * Click on EN button and perform required action
	 * 
	 */
	public void tapOnENButton() {

		enButton.click();
		child.log(Status.INFO,"Tapped successfully on EN button ");
	}
	public void selectOptionAsNo()
	{

		EndActivityNoButton.click();
		child.log(Status.INFO,"Selected EN Option as NO ");


	}
}
