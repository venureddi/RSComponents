package uk.rscomponents.stepdefinitions;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.rscomponents.base.TestContext;
import uk.rscomponents.base.TestContext;
import uk.rscomponents.pages.HomePage;
import uk.rscomponents.pages.PassiveComponentsPage;
import uk.rscomponents.pages.SurgeSuppressorUnitsPage;

public class End_To_End_Test_01  {

    private HomePage homePage;
    private PassiveComponentsPage passiveComponentsPage;
    private SurgeSuppressorUnitsPage surgeSuppressorUnitsPage;
    private WebDriver driver;
    private TestContext testContext;

    public End_To_End_Test_01(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void initialiseCucumberTests(Scenario scenario) {
        testContext.initialize();
    }

    @Given("^user navigated to 'RS Components' Home page$")
    public void user_navigated_to_RS_Components_Home_page() throws Throwable {
        homePage = PageFactory.initElements(testContext.getDriver(), HomePage.class);
        homePage.verifyHomePage();
    }

    @And("^user verifies different sections present on the Home page$")
    public void userVerifiesDifferentSectionsPresentOnTheHomePage() throws Throwable {
        homePage.validatePrimaryNavigation();
    }

    @When("^user clicks on 'All Products' link on Home page$")
    public void userClicksOnAllProductsLinkOnHomePage() throws Throwable {
        homePage.clickAllProducts();
    }

    @Then("^user validates different sections under 'All Products'$")
    public void userValidatesDifferentSectionsUnderAllProducts() throws Throwable {
//        homePage.validateAllProductsSection();
    }

    @And("^user clicks on 'Passive Components' under 'Electronics Components' section$")
    public void userClicksOnPassiveComponentsUnderElectronicsComponentsSection() throws Throwable {
        homePage.clickPassiveComponents();
    }

    @Then("^the 'Passsive Components' page is displayed$")
    public void thePasssiveComponentsPageWillBeDisplayed() throws Throwable {
        passiveComponentsPage = PageFactory.initElements(testContext.getDriver(), PassiveComponentsPage.class);
        passiveComponentsPage.validatePassiveComponentsPage();

    }

    @And("^user clicks on 'Surge Protection Components'$")
    public void userClicksOnSurgeProtectionComponents() throws Throwable {
        passiveComponentsPage.clickSurgeProtectionComponents();
    }

    @Then("^the 'Surge Protection Components' Page is displayed$")
    public void theSurgeProtectionComponentsPageIsDisplayed() throws Throwable {
        passiveComponentsPage.validateSurgeProtectionComponentsPage();
    }

    @And("^user clicks on 'Surge Suppressor Units'$")
    public void userClicksOnSurgeSuppressorUnits() throws Throwable {
        passiveComponentsPage.clickSurgeSuppressorUnits();
    }

    @Then("^the 'Surge Suppressor Units' page is displayed$")
    public void theSurgeSuppressorUnitsPageIsDisplayed() throws Throwable {
        surgeSuppressorUnitsPage = PageFactory.initElements(testContext.getDriver(), SurgeSuppressorUnitsPage.class);
        surgeSuppressorUnitsPage.validateSurgeSuppressorPage();

    }

    @And("^user selects surge suppressor with RS Stock No \"([^\"]*)\"$")
    public void userSelectsSurgeSuppressorWithRSStockNo(String value) throws Throwable {
        surgeSuppressorUnitsPage.clickTableRow(value);
    }

    @And("^user clicks on 'Add To Basket' button to add in cart$")
    public void userClicksOnAddToBasketButtonToAddInCart() throws Throwable {
        surgeSuppressorUnitsPage = PageFactory.initElements(testContext.getDriver(), SurgeSuppressorUnitsPage.class);
        surgeSuppressorUnitsPage.clickAddToBasketButton();
    }

    @After
    public void closeDriver() {
        testContext.getDriver().quit();
    }


}
