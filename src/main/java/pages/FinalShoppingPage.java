package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalShoppingPage {
    public WebDriver driver;

    public static String EXPECTED_TEXT_MESSAGE = "Thank you for your order!";
    public static String EXPECTED_SUB_TEXT_MESSAGE = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    public By completeHeader = By.xpath("//h2[@class='complete-header']");
    public By completeText = By.xpath("//div[@class='complete-text']");

    public FinalShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getText() {
        return driver.findElement(completeHeader).getText();
    }

    public String getSubText() {
        return driver.findElement(completeText).getText();
    }
}
