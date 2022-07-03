package org.nagarro.pages.web;

import org.nagarro.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TestPage {

    public void launchGoogle() throws Exception {

        WebDriver driver = DriverFactory.getDriver();

        driver.get("https://www.google.com");

        driver.quit();

    }
}
