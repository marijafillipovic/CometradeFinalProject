package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    public WebDriver driver;

    public static String VALID_USER_NAME = "standard_user";
    public static String INVALID_USER_NAME = "x y user";
    public static String VALID_PASSWORD = "secret_sauce";
    public static String INVALID_PASSWORD = "x y user";
    public static String CORRECT_URL_AFTER_LOGIN = "https://www.saucedemo.com/inventory.html";

    public By userNameInputField = By.xpath("//*[@placeholder='Username']");
    public By passwordInputField = By.xpath("//*[@placeholder='Password']");
    public By logInButton = By.cssSelector("input[name='login-button'][type='submit']");
    public By errorMessage = By.xpath("//h3[contains(text(),'Epic sadface')]");
    public By optionsMenu = By.xpath("//*[contains(text(),'Open Menu')]");
    public By logOutButton = By.xpath("//*[contains(text(),'Logout')]");
    public By resetAppStateButton = By.xpath("//*[contains(text(),'Reset App State')]");


    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String userName){
        driver.findElement(userNameInputField).sendKeys(userName);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public void clickOnLoginInButton(){
        driver.findElement(logInButton).click();
    }

    public String displayErrorMessageText(){
        return driver.findElement(errorMessage).getText();
    }

    public void clickOnOptionsMenu(){
        driver.findElement(optionsMenu).click();
    }

    public void clickOnLogOutButton(){
        driver.findElement(logOutButton).click();
    }

    public void clickOnResetAppState(){
        driver.findElement(resetAppStateButton).click();
    }
}
