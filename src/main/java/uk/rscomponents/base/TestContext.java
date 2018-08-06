package uk.rscomponents.base;

import cucumber.api.java.Before;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.Properties;

public class TestContext {

    private WebDriver driver;
    private Properties properties;

    private void readProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("F:\\Test\\Selenium\\EasePro\\demoproject\\src\\main\\java\\uk\\rscomponents\\config\\config.properties");
            properties.load(fis);
            System.out.println(properties.getProperty("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void initialize() {
        readProperties();
        String browser = properties.getProperty("driver_type");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "F:\\Test\\Selenium\\EasePro\\demoproject\\src\\main\\java\\uk\\rscomponents\\config\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            driver = new ChromeDriver(options);
        } else if (browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "F:\\Test\\Selenium\\EasePro\\demoproject\\src\\main\\java\\uk\\rscomponents\\config\\chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
            capabilities.setCapability(InternetExplorerDriver.
                    INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
