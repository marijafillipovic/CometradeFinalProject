package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LinksInFooterPage {
    public WebDriver driver;

    public static String EXPECTED_TWITTER_LINK = "https://twitter.com/i/flow/login?redirect_after_login=%2Fsaucelabs";
    public static String EXPECTED_FACEBOOK_LINK = "https://www.facebook.com/saucelabs";
    public static String EXPECTED_LINKEDIN_LINK = "https://www.linkedin.com/company/sauce-labs/";

    public static By twitterLink = By.xpath("//*[text()='Twitter']");
    public static By facebookLink = By.linkText("Facebook");
    public static By linkedInLink = By.linkText("LinkedIn");

    public LinksInFooterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnTheTwitterButton(){
        driver.findElement(twitterLink).click();
    }
    public void clickOnTheFacebookButton(){
        driver.findElement(facebookLink).click();
    }
    public void clickOnTheLinkedInButton(){
        driver.findElement(linkedInLink).click();
    }

    public String getLinkedInHref() {
        return driver.findElement(linkedInLink).getAttribute("href");
    }

    public String getFacebookHref() {
        return driver.findElement(facebookLink).getAttribute("href");
    }

    public String getTwitterHref() {
        return driver.findElement(twitterLink).getAttribute("href");
    }

    public void switchTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void switchToFirstTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

}
