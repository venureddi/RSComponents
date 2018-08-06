package uk.rscomponents.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.rscomponents.FrameworkMethods.CommonMethods;
import uk.rscomponents.base.BaseTest;

public class PassiveComponentsPage extends BaseTest {


    public PassiveComponentsPage(WebDriver driver) {
        super(driver);
    }
    /*public PassiveComponentsPage(WebDriver driver) {
        this.driver = driver;
    }*/

    @FindBy(xpath="//*[@title=\"Surge Protection Components\"]")
    private WebElement surgeProtectionComponentsLink;

    @FindBy(xpath="//*[@title=\"Surge Suppressor Units\"]")
    private WebElement surgeSuppresserUnitLink;

    /**
     * Method to validate that Passive Components Page is displayed
     */
    public void validatePassiveComponentsPage() {
        String title = driver.getTitle();
        Assert.assertEquals("Passive Components | RS Components", title);
    }

    /**
     * Method to click surge protection components link
     */
    public void clickSurgeProtectionComponents() {
        waitForElementToBeClickable(surgeProtectionComponentsLink);
        surgeProtectionComponentsLink.click();
    }
    /**
     * Method to validate that Passive Components Page is displayed
     */
    public void validateSurgeProtectionComponentsPage() {
        String title = driver.getTitle();
        Assert.assertEquals("Surge Protection Components | RS Components", title);
        checkAlert();
    }

    /**
     * Method to click surge protection components link
     */
    public void clickSurgeSuppressorUnits() {
        waitForElementToBeClickable(surgeSuppresserUnitLink);
        surgeSuppresserUnitLink.click();
    }

}
