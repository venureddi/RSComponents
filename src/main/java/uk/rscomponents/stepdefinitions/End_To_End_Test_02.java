package uk.rscomponents.stepdefinitions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import uk.rscomponents.base.BaseTest;
import uk.rscomponents.pages.HomePage;
import uk.rscomponents.base.TestContext;
import uk.rscomponents.pages.SiemensPage;
import uk.rscomponents.pages.SurgeSuppressorUnitsPage;

public class End_To_End_Test_02 {
    private HomePage homePage;
    private SiemensPage siemensPage;
    private  SurgeSuppressorUnitsPage surgeSuppressorUnitsPage;
    private BaseTest baseTest;
    private TestContext testContext;

    public End_To_End_Test_02(TestContext testContext) {
        this.testContext = testContext;
        baseTest = new BaseTest(testContext.getDriver());
    }

    @When("^user clicks on 'Our Brands' link on Home page$")
    public void userClicksOnOurBrandsLinkOnHomePage() throws Throwable {
        homePage = PageFactory.initElements(testContext.getDriver(), HomePage.class);
        homePage.clickOurBrands();
    }

    @When("^user clicks on 'Siemens' logo on Top brands section$")
    public void userClicksOnSiemensLogoOnTopBrandsSection() throws Throwable {
        homePage.clickSiemensBrand();
    }

    @Then("^Siemens brand page is displayed$")
    public void siemensBrandPageIsDisplayed() throws Throwable {
        siemensPage = PageFactory.initElements(testContext.getDriver(), SiemensPage.class);
        siemensPage.getSiemensLogo().isDisplayed();

    }

    @And("^user clicks on 'Automation  Control Gear' under Categories$")
    public void userClicksOnAutomationControlGearUnderCategories() throws Throwable {
        siemensPage.getAutomationControlGearLink();
    }

    @And("^user clicks on 'Advanced Motor Starters' under 'Electrical Motors' section$")
    public void userClicksOnAdvancedMotorStartersUnderElectricalMotorsSection() throws Throwable {
        siemensPage.getAdvancedMotorStarterLink();
    }

    @And("^user selects Sirus (\\d+)kW compact feeder with RS stock no \"([^\"]*)\"$")
    public void userSelectsSirusKWCompactFeederWithRSStockNo(int arg0, String value) throws Throwable {
        surgeSuppressorUnitsPage = PageFactory.initElements(testContext.getDriver(), SurgeSuppressorUnitsPage.class);
        surgeSuppressorUnitsPage.clickTableRow(value);
    }

    @And("^user enters text \"([^\"]*)\" in the search field on Home page$")
    public void userEntersTextInTheSearchFieldOnHomePage(String value) throws Throwable {
        homePage = PageFactory.initElements(testContext.getDriver(), HomePage.class);
        homePage.searchText(value);

    }

    @And("^user apply filters to select brand and Maximum Surge Current$")
    public void userApplyFiltersToSelectBrandAndMaximumSurgeCurrent() throws Throwable {
        surgeSuppressorUnitsPage = PageFactory.initElements(testContext.getDriver(), SurgeSuppressorUnitsPage.class);
        surgeSuppressorUnitsPage.applyFilters();
    }

    @And("^user selects \"([^\"]*)\" surge suppressor unit$")
    public void userSelectsSurgeSuppressorUnit(String value) throws Throwable {
        surgeSuppressorUnitsPage.clickTableRow(value);
    }
}
