package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;

    public By addToCartButton = By.xpath("//*[contains(text(),'Add to cart')]");
    public By addedItemToTheCart = By.xpath("//span[@class='shopping_cart_badge']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public String getShoppingCartNumber(){
        return driver.findElement(addedItemToTheCart).getText();
    }
}