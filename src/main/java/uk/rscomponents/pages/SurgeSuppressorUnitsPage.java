package uk.rscomponents.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.rscomponents.FrameworkMethods.CommonMethods;
import uk.rscomponents.base.BaseTest;
import java.util.List;

public class SurgeSuppressorUnitsPage extends BaseTest {

    public SurgeSuppressorUnitsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h1[contains(text(), ' Surge Suppressor Units')]")
    private WebElement surgeSuppressorPageHeading;

    @FindBy(xpath="//button[@class='btn btn-primary-red btn-large btn-add-to-basket']")
    private WebElement addToBasketButtton;

    @FindBy(xpath = "//*[@id=\"results-table\"]")
    private WebElement resultsTable;

    @FindBy(xpath = "//*[@id=\"filters\"]/div/div/rs-facets/a[1]")
    private WebElement brandFilter;

    @FindBy(xpath="//*[@id=\"4294967273\"]/span[1]")
    private WebElement ABBCheckbox;

    @FindBy(xpath ="//*[@id=\"filters\"]/div/div/rs-facets/a[3]")
    private WebElement maximumVoltageRatingFilter;

    @FindBy(xpath ="//*[@id=\"4294451878\"]/span[1]")
    private WebElement fourVoltacCheckbox;

    @FindBy(xpath="//*[@class=\"btn btn-primary matches-btn active\"]")
    private WebElement applyFiltersButton;


    /**
     * Method to validate the Surge Suppressor Page has been displayed
     */
    public void validateSurgeSuppressorPage() {
        waitForElementToBeClickable(surgeSuppressorPageHeading);
        surgeSuppressorPageHeading.isDisplayed();
    }

    /**
     * Method used to click the required component
     * @param value value
     */
    public void clickTableRow(String value) {
        scrollDown();
        checkAlert();
        String price =null;
        waitForElementToBeClickable(resultsTable);
        WebElement resultsTable = driver.findElement(By.xpath("//*[@id=\"results-table\"]"));
        List<WebElement> rows = resultsTable.findElements(By.tagName("tr"));
        try {
            for (WebElement row : rows) {
                Thread.sleep(500);
                if (row.getText().contains(value)) {
                    List<WebElement> columns = row.findElements(By.tagName("td"));
                    price = columns.get(2).getText();
                    price = price.replaceAll("\n"," ");
                    price = price.split(" ")[0];
                    System.out.println("............"+price);
                    checkAlert();
                    columns.get(0).click();
                }
            }
        }catch (Exception e) {
            // Do nothing
        }
        checkAlert();
    }

    /**
     * Method to click Add to Basket button
     */
    public void clickAddToBasketButton() {
            checkAlert();
            scrollDown();
            waitForElementToBeClickable(addToBasketButtton);
            addToBasketButtton.click();

    }

    /**
     *
     */
    public void applyFilters() {
        checkAlert();
        brandFilter.click();
        waitForElementToBeClickable(ABBCheckbox);
        ABBCheckbox.click();
        //scrollDown();
        //applyFiltersButton.click();
        waitForElementToBeClickable(maximumVoltageRatingFilter);
        maximumVoltageRatingFilter.click();
        waitForElementToBeClickable(fourVoltacCheckbox);
        fourVoltacCheckbox.click();
        //scrollDown();
        waitForElementToBeClickable(applyFiltersButton);
        applyFiltersButton.click();
    }
}
