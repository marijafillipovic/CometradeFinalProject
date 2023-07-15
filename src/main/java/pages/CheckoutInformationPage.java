package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    public WebDriver driver;
    public static String VALID_FIRST_NAME = "Marija";
    public static String VALID_LAST_NAME = "Filipovic";
    public static String VALID_ZIP_POSTAL_CODE = "11000";
    public static double TAX = 0.08;

    public By firstNameField = By.xpath("//input[@placeholder='First Name']");
    public By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    public By zipCodeField = By.xpath("//input[@placeholder='Zip/Postal Code']");
    public By continueButton = By.id("continue");
    public By finishButton = By.id("finish");
    public By finalPriceOfTheProduct = By.xpath("//div[@class='summary_info_label summary_total_label']");

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(){
        driver.findElement(firstNameField).sendKeys(VALID_FIRST_NAME);
    }
    public void enterLastName(){
    driver.findElement(lastNameField).sendKeys(VALID_LAST_NAME);
    }
    public void enterZipCode(){
    driver.findElement(zipCodeField).sendKeys(VALID_ZIP_POSTAL_CODE);
    }
    public void clickOnContinueButton(){
    driver.findElement(continueButton).click();
    }
    public String getTheFinalPrice() {
        return driver.findElement(finalPriceOfTheProduct).getText().substring(8);
    }
    public void clickOnFinishButton() {
        driver.findElement(finishButton).click();
    }
}