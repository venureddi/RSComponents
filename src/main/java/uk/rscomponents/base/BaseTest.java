package uk.rscomponents.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 */
public class BaseTest extends TestContext{

    public WebDriver driver;
    private  WebDriverWait wait;
    public BaseTest(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,10);
    }

    /**
     * Method to wait for an Element to be visible on the screen to perform an action
     * @param element Element Locator
     */
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method to validate whether element is displayed or not on the screen
     * @param element WebElement
     * @return true/False
     */
    public boolean isElementPresent(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
//        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    /**
     * Method to move the scroll bar down
     */
    public void scrollDown() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        } catch(Exception e) {
            // do nothing
        }

    }

    /**
     * Method to move the scroll bar up
     */
    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, -500)", new Object[]{""});
    }

    /**
     * Method to check Alert on the page
     */
    public void checkAlert() {
        try {
            wait(1000);
            driver.switchTo().alert();
            driver.findElement(By.xpath("//*[@title='No, thanks']")).click();
        } catch (Exception e) {
            // Do nothing
        }
    }



}
