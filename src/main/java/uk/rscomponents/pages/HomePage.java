package uk.rscomponents.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.rscomponents.FrameworkMethods.CommonMethods;
import uk.rscomponents.base.BaseTest;
import uk.rscomponents.base.TestContext;

public class HomePage extends BaseTest {

    private CommonMethods commonMethods;
    /**
     * Constructor
     * @param driver driver object
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // ***** Page Objects *****
    @FindBy(xpath = "//*[@class=\"icon-rslogo\"]")
    private WebElement rsLogo;

    @FindBy(xpath = "//*[@title=\"All Products\"]")
    private WebElement allProductsLink;

    @FindBy(xpath = "//*[@title=\"Our Brands\"]")
    private WebElement ourBrandsLink;

    @FindBy(xpath = "//*[@title=\"New Products\"]")
    private WebElement newProductsLink;

    @FindBy(xpath = "//*[@title=\"Offers and Deals\"]")
    private WebElement offersAndDealsLink;

    @FindBy(xpath = "//*[@title=\"My Account\"]")
    private WebElement myAccountsLink;

    @FindBy(xpath = "//*[@title=\"Our Services\"]")
    private WebElement ourServicesLink;

    @FindBy(xpath = "//a[contains(text(),'Passive Components')]")
    private WebElement passiveComponentsLink;

    @FindBy(xpath = "//a[contains(text(),'Electronics Components, Power & Connectors')]")
    private WebElement electronicsComponentsLink;

    @FindBy(xpath = "//a[contains(text(),'Electrical, Automation & Cables')]")
    private WebElement electricalComponentsLink;

    @FindBy(xpath = "//a[contains(text(),'Mechanical Products & Tools')]")
    private WebElement mechanicComponentsLink;

    @FindBy(xpath = "//a[contains(text(),'IT, Test & Safety Equipment')]")
    private WebElement itComponentsLink;

    @FindBy(xpath="//a[@class='sprite sprite-brand-13'][@title='Siemens']")
    private WebElement siemensLink;

    @FindBy(xpath ="//*[@id=\"searchTerm\"]")
    private WebElement searchBox;


    // Methods

    /**
     * Method to verify the Home Page of RS Components Web application
     */
    public void verifyHomePage() {
        String title = driver.getTitle();
        Assert.assertEquals("RS Components | Electronic and Electrical Components", title);
        Assert.assertTrue("'RS Components' HomePage is displayed", rsLogo.isDisplayed());
    }

    /**
     * Method to verify different navigation links on the Home Page
     */
    public void validatePrimaryNavigation() {
        Assert.assertTrue("'All Products' Link is displayed", allProductsLink.isDisplayed());
        Assert.assertTrue("'Our Brands' Link is displayed", ourBrandsLink.isDisplayed());
        Assert.assertTrue("'New Products' Link is displayed", newProductsLink.isDisplayed());
        Assert.assertTrue("'Offers and Deals' Link is displayed", offersAndDealsLink.isDisplayed());
        Assert.assertTrue("'My Account' Link is displayed", myAccountsLink.isDisplayed());
        Assert.assertTrue("'Our Services' Link is displayed", ourServicesLink.isDisplayed());
    }

    /*
     * Method to click All Products link on Home Page
     */
    public void clickAllProducts() {
        waitForElementToBeClickable(allProductsLink);
        allProductsLink.click();
    }
    /*
     * Method to click Our Brands link on Home Page
     */
    public void clickOurBrands() {
        waitForElementToBeClickable(ourBrandsLink);
        ourBrandsLink.click();
    }
    /**
     * Method to validate that all section displayed under All Products
     */
    public void validateAllProductsSection() {

       // waitForElementToBeClickable(electricalComponentsLink);
        electronicsComponentsLink.isDisplayed();
        isElementPresent(electricalComponentsLink);
        scrollDown();
        isElementPresent(mechanicComponentsLink);
        isElementPresent(itComponentsLink);
    }

    /**
     * Method to click on Passive Components in Electronics components, Power & Connectors Section
     */
    public void clickPassiveComponents() {
        waitForElementToBeClickable(passiveComponentsLink);
        passiveComponentsLink.click();
    }

    public void clickSiemensBrand() {
        waitForElementToBeClickable(siemensLink);
        siemensLink.click();
        checkAlert();
    }

    /**
     * Method to enter text and search from the home page
     * @param value value
     */
    public void searchText(String value) {
        waitForElementToBeClickable(searchBox);
        searchBox.sendKeys(value);
        searchBox.sendKeys(Keys.ENTER);

    }

}
