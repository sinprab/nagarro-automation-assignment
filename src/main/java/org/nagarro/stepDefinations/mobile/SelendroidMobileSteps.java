package org.nagarro.stepDefinations.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.pages.mobile.*;
import org.nagarro.stepDefinations.web.JQueryWebSteps;
import org.nagarro.utilities.CommonHelper;
import org.nagarro.utilities.ExtentTestManager;

public class SelendroidMobileSteps extends CommonHelper {

    public static final Logger log = Logger.getLogger(JQueryWebSteps.class.getName());

    Scenario scenario;
    AndroidDriver driver;

    public static HomePage homePage;
    public static ChromeLogoPage chromeLogoPage;
    public static FileLogoPage fileLogoPage;

    public static ProgressBarPage progressBarPage;
    public static CommonPage commonPage;

    //*******************************************************************************************************************************************
    //                                          ** Before Scenario **
    //*******************************************************************************************************************************************

    @Before
    public void before(Scenario scenario) {
        try {
            String log4jConfPath = "log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
            this.scenario = scenario;
            DriverFactory.setAndroidDriver();
            this.driver = DriverFactory.getAndroidDriver();
            homePage = new HomePage();
            chromeLogoPage = new ChromeLogoPage();
            fileLogoPage = new FileLogoPage();
            progressBarPage = new ProgressBarPage();
            commonPage = new CommonPage();

        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        }
    }

    //*******************************************************************************************************************************************
    //                                          ** Verify Home Page Title Scenario Definitions**
    //*******************************************************************************************************************************************


    @Given("Launch application")
    public void launch_application() {
        try {
            child = ExtentTestManager.startTest(scenario.getName(), "");

        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        }
    }

    @When("user reaches home page")
    public void user_reaches_home_page() {
        homePage.acceptHomePagePopUp();

    }

    @Then("verify the home page title")
    public void verify_the_home_page_title() {
        homePage.verifyHomePageTitle();

    }

    //*******************************************************************************************************************************************
    //                                          ** Verify EN Button Scenario Definitions**
    //*******************************************************************************************************************************************

    @When("Tap on EN button")
    public void tap_on_EN_button() {
        homePage.tapOnENButton();
    }

    @When("Select option as NO")
    public void select_option_as_no() {
        homePage.selectOptionAsNo();
    }

    //*******************************************************************************************************************************************
    //                                          ** Verify Chrome Logo Scenario Definitions**
    //*******************************************************************************************************************************************

    @When("tap on Chrome logo button")
    public void tap_on_chrome_logo_button() {
        try {
            chromeLogoPage.tapOnChromeLogoButton();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("verify the text {string}")
    public void verify_the_text(String textToVerify) {
        try {
            chromeLogoPage.verifyTheTellNameText(textToVerify);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    @When("user enters its {string} in textbox")
    public void user_enters_its_in_textbox(String name) {
        try {
            chromeLogoPage.enterNameInTheTextBox(name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @When("selects prefered car as {string}")
    public void selects_prefered_car_as(String carName) {
        try {
            chromeLogoPage.selectPrefferedCar(carName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @When("taps on send me your name")
    public void taps_on_send_me_your_name() {
        try {
            chromeLogoPage.tapOnSendMeYourName();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("verify entered {string} and selected {string}")
    public void verify_entered_and_selected(String name, String carName) {
        try {
            chromeLogoPage.verifyNameAndCarName(name, carName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("verify the hello text {string}")
    public void verifyTheHelloText(String textToVerify) {
        try {
            chromeLogoPage.verifyTheTextMyWaySayingHello(textToVerify);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    //*******************************************************************************************************************************************
    //                                          ** Verify File Logo Scenario Definitions**
    //*******************************************************************************************************************************************

    @When("tap on File logo button")
    public void tap_on_file_logo_button() {
        try {
            fileLogoPage.tapOnFileLogoButton();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("verify the text on registration page as {string}")
    public void verifyTheTextOnRegistrationPageAs(String textToVerify) {
        try {
            fileLogoPage.verifyRegistrationPageText(textToVerify);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("Check if the Name eld is pre-populated with {string}")
    public void check_if_the_name_eld_is_pre_populated_with(String string) {
        try {
            fileLogoPage.verifyPrePopulatedName();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("Check if {string} is selected as Programming Language by default")
    public void check_if_is_selected_as_programming_language_by_default(String string) {
        try {
            fileLogoPage.verifyPreSelectedProgrammingLanguage();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @When("Fill in the fields with new values as {string} {string} and {string}")
    public void fill_in_the_fields_with_new_values_as_and(String name, String email, String password) {
        try {
            fileLogoPage.setFieldInUserRegistration(name, password, email);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @When("Select {string}")
    public void select(String string) {
        try {
            fileLogoPage.acceptTnC();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @When("Tap on Register User verify")
    public void tap_on_register_user_verify() {
        try {
            fileLogoPage.tapOnRegisterUser();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("Verify the user details on the next screen as  {string} {string} and {string}")
    public void verify_the_user_details_on_the_next_screen_as_and(String name, String email, String password) {
        try {
            fileLogoPage.verifyRegistrationDetails(name, password, email);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @When("Tap on Register User link")
    public void tap_on_register_user_link() {
        try {
            fileLogoPage.tapOnRegisterUserButton();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("click on link {string}")
    public void click_on_link(String string) {
        try {
            chromeLogoPage.clickLinkHere();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    @Then("Check if the screen navigates to the home screen.")
    public void check_if_the_screen_navigates_to_the_home_screen() {
        try {
            fileLogoPage.verifyNavigationToHomeScreen();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }
    //*******************************************************************************************************************************************
    //                                          ** Progress Bar Steps **
    //*******************************************************************************************************************************************

    @When("Tap on Show Progress Bar Button")
    public void tap_on_show_progress_bar_button() {
        try {
            progressBarPage.tapOnProgressBarTab();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("Wait for the loader to disappear")
    public void wait_for_the_loader_to_disappear() {
        try {
            progressBarPage.waitForLoader();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("Verify the elements on the user registration on screen")
    public void verify_the_elements_on_the_user_registration_on_screen() {
        try {
            progressBarPage.verifyUserRegistrationPage();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    //*******************************************************************************************************************************************
    //                                          ** Verify Toast Scenario **
    //*******************************************************************************************************************************************

    @And("Tap on Display Toast")
    public void tapOnDisplayToast() {
        try {
            commonPage.tapOnToastButton();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("Verify the toast text")
    public void verifyTheToastText() {
        try {
            commonPage.verifyDisplaysAToast();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
    //*******************************************************************************************************************************************
    //                                          ** Verify Pop Up Scenario **
    //*******************************************************************************************************************************************

    @And("Tap on popup")
    public void tapOnPopup() {
        try {
            commonPage.tapOnDispalyPopUp();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Then("dismiss the popup")
    public void dismissThePopup() {
        try {
            commonPage.dismissDisplaysPopup();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
    //*******************************************************************************************************************************************
    //                                          ** Press Unhandled Exception Scenario **
    //*******************************************************************************************************************************************


    @And("Tap on Press to throw unhandled exception")
    public void tapOnPressToThrowUnhandledException() {
        try {
            commonPage.verifyUnhandledException();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    //*******************************************************************************************************************************************
    //                                          ** Type Unhandled Exception Scenario **
    //*******************************************************************************************************************************************

    @And("Tap on Type to throw unhandled exception")
    public void tapOnTypeToThrowUnhandledException() {
        try {
            commonPage.verifyTypeAndUnhandledException("test");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    //*******************************************************************************************************************************************
    //                                          ** After Scenario **
    //*******************************************************************************************************************************************

    @After
    public void after() {
        DriverFactory.closeAndroidDriver();
        ExtentTestManager.endTest();
    }

}
