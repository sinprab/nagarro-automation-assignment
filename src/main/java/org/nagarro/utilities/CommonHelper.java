package org.nagarro.utilities;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.testng.Reporter;

public class CommonHelper {

    public static ExtentTest child;


    /**
     * Generate screenshot
     *
     * @param driver and image name
     *
     * @throws IOException
     */

    public String getScreenshot(WebDriver driver, String imageName) throws IOException {

        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        if (imageName.equals("")) {
            imageName = "_blank";
        }

        Calendar calander = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        String reportDirectory = new File(System.getProperty("user.dir"))
                + "/src/main/resources/output/screenshot/";

        String actualImageName = reportDirectory + imageName + "_" + format.format(calander.getTime()) + ".png";
        File destFile = new File(actualImageName);
        FileUtils.copyFile(image, destFile);

        Reporter.log("<a href= '" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
                + "' height='100' width ='100'/></a>");

        return actualImageName;

    }

    /**
     * Method to wait till element is visible
     *
     */
    public void explicatWait(WebDriver driver, WebElement xpathValue) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(xpathValue));
    }

    /**
     * Method to wait till element become invisible
     *
     */
    public void explicatWaitTillInvisibility(WebDriver driver, WebElement xpathValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(xpathValue));

    }

    /**
     * scroll till element is visible
     *
     * @param driver and WebElement
     */
    public void scrollView(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Method to Check if element is clickable or not
     *
     */
    public static boolean isClickableWeb(WebElement el, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Method to Check if element is clickable or not
     *
     */
    public static boolean isClickableAndroid(WebElement element, AndroidDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitUntilInvisibilityAndroid(WebElement element, AndroidDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
