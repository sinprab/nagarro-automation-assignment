package org.nagarro.stepDefinations.web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.nagarro.drivers.DriverFactory;
import org.nagarro.pages.web.ControlgroupPage;
import org.nagarro.pages.web.DroppablePage;
import org.nagarro.pages.web.SelectablePage;
import org.nagarro.utilities.ExtentTestManager;
import org.nagarro.utilities.PropertyHandler;
import org.nagarro.utilities.CommonHelper;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class JQueryWebSteps extends CommonHelper {

    public static final Logger log = Logger.getLogger(JQueryWebSteps.class.getName());

    Scenario scenario;
    WebDriver driver;
    DroppablePage droppablePage;
    SelectablePage selectablePage;
    ControlgroupPage controlgroupPage;
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        DriverFactory.setDriver();
        this.driver = DriverFactory.getDriver();
        droppablePage = new DroppablePage();
        selectablePage = new SelectablePage();
        controlgroupPage = new ControlgroupPage();
    }

    @Given("Launch jquery website")
    public void launch_jquery_website() {
        try {
            child = ExtentTestManager.startTest(scenario.getName(), "");
            driver.get(PropertyHandler.readData("jqueryURI"));
            droppablePage.verifyHomePage();
        }
        catch (Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }
    }
    @When("User selects option {string} from left menu under Interactions")
    public void user_selects_option_from_left_menu_under_interactions(String string) {
        try {
            if(string.equalsIgnoreCase("Droppable"))
            droppablePage.clickDroppableButton();
            else if (string.equalsIgnoreCase("Selectable")) {
                selectablePage.clickSelectableButton();
                
            } else if (string.equalsIgnoreCase("Controlgroup")) {
                controlgroupPage.clickOnControlGroupButton();
            }
        }
        catch (Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }
    }
    @When("User Drag ‘Drag me around’ component to ‘Drop here’ component")
    public void user_drag_drag_me_around_component_to_drop_here_component() {
        try {

            droppablePage.dragDropInDroppableInteraction();
        }
        catch (Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }
    }
    @Then("‘Drag me around’ component must get dragged ‘Drop here’ component")
    public void drag_me_around_component_must_get_dragged_drop_here_component() {
        try {

            droppablePage.verifyDragDropInDroppableInteraction();
        }
        catch (Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }
    }
    @When("User Selects <Item>")
    public void user_selects_item(DataTable dataTable) {
        try {
            List<List<String>> items = dataTable.cells();
            String itemList = items.get(0).get(0);
            for (int i = 1; i < items.size(); i++) {
                itemList = itemList + "," + items.get(i).get(0);
            }
            selectablePage.selectItemTab(itemList);
        }
        catch(Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }


    }
    @Then("All specified item must get selected")
    public void all_specified_item_must_get_selected() {
        try {
            selectablePage.verifyThatItemsAreSelected();
        }
        catch(Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }
    }
    @When("User Book Car with details {string},{string},{string}")
    public void user_book_car_with_details(String carType, String transmissionType, String numberOfCar) {
        try {
            controlgroupPage.controlgroupTab(carType,transmissionType,numberOfCar);
        }
        catch(Exception e)
        {
            log.error(e);
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        DriverFactory.closeDriver();
        ExtentTestManager.endTest();
    }
}
