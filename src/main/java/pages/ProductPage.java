package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    public WebDriver driver;

    public By productItem = By.className("inventory_item");
    public By removeButton = By.xpath("//button[contains(text(), 'Remove')]");
    public By productsInTheCart = By.xpath("//span[@class='shopping_cart_badge']");
    public By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    public By checkoutButton = By.id("checkout");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getTheTotalNumberOfProducts() {
        return driver.findElements(productItem).size();
    }

    public int getRandomFromNumberOfProducts() {
        int random = (int) (Math.random() * getTheTotalNumberOfProducts());
        return random;
    }
    public int getTheNumberOfRemoveButtons(){
        int size = driver.findElements(removeButton).size();
        return size;
    }

    public int getActualNumberOfProductsInTheCart() {
        String innerText = driver.findElement(productsInTheCart).getText();
        int actualNumberOfProducts = Integer.parseInt(innerText.trim());
        return actualNumberOfProducts;
    }

    public void clickOnTheCartButton(){
        driver.findElement(cartButton).click();
    }

    public void clickOnCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public String formatNumber(double number) {
        String result = String.format("%.2f", number);
        return result;
    }

}