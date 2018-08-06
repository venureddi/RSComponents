package uk.rscomponents.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.rscomponents.base.BaseTest;

public class SiemensPage  extends BaseTest {

    public SiemensPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//img[@title=\'Siemens\']")
    private WebElement siemensLogo;

    @FindBy(xpath ="//*[@href=\'automation-control-gear/\']")
    private  WebElement automationControlGearLink;

    @FindBy(xpath="//*[@title='Advanced Motor Starters']")
    private WebElement advancedMotorStarterLink;

    public WebElement getSiemensLogo() {
        return siemensLogo;
    }

    /**
     * Method to click on Automation & Gear section
     */
    public void getAutomationControlGearLink() {
        waitForElementToBeClickable(automationControlGearLink);
        automationControlGearLink.click();
        checkAlert();
    }

    /**
     * Method to click on Advanced Motor Starters under Electric motors section
     */
    public void getAdvancedMotorStarterLink() {
        waitForElementToBeClickable(advancedMotorStarterLink);
        advancedMotorStarterLink.click();
        checkAlert();
    }
}
