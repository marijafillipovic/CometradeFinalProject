package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductItem {

    public WebDriver driver;

    public By productTitle = By.className("inventory_item_name");
    public By productPrice = By.className("inventory_item_price");
    public By productDescription = By.className("inventory_item_desc");
    public By addToCartButton = By.xpath("//button[contains(@class, 'btn_inventory')]");
    public By removeButton = By.xpath("//button[contains(text(), 'Remove')]");

    public ProductItem(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void clickOnAddToCartButton(int index) {
        driver.findElements(addToCartButton).get(index).click();
    }

    public void clickOnRemoveButton() {
        driver.findElement(removeButton).click();
    }

    public String getProductTitle(int index) {
        return driver.findElements(productTitle).get(index).getText();
    }

    public String getProductDesc(int index) {
        return driver.findElements(productDescription).get(index).getText();
    }

    public String getProductPrice(int index) {
        return driver.findElements(productPrice).get(index).getText();
    }

    public String getProductPriceNoDollarSymbol(int index) {
        return driver.findElements(productPrice).get(index).getText().substring(1);
    }

}
