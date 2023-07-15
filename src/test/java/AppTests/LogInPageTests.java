package AppTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LogInPage;

public class LogInPageTests extends BaseTestSetUp {

    @Before
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Test
    public void noCredentialsInserted() {
        logInPage.enterUserName("");
        logInPage.enterPassword("");
        logInPage.clickOnLoginInButton();

        String expectedMessage = "Epic sadface: Username is required";
        String actualMessage = logInPage.displayErrorMessageText();

        Assert.assertTrue("The wrong message is displayed", expectedMessage.equals(actualMessage));
    }

    @Test
    public void invalidUserNameInvalidPassword(){
        logInPage.enterUserName(LogInPage.INVALID_USER_NAME);
        logInPage.enterPassword(LogInPage.INVALID_PASSWORD);
        logInPage.clickOnLoginInButton();

        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = logInPage.displayErrorMessageText();

        Assert.assertTrue("The wrong message is displayed", expectedMessage.equals(actualMessage));
    }

    @Test
    public void validUserNameInvalidPassword(){
        logInPage.enterUserName(LogInPage.VALID_USER_NAME);
        logInPage.enterPassword(LogInPage.INVALID_PASSWORD);
        logInPage.clickOnLoginInButton();

        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = logInPage.displayErrorMessageText();

        Assert.assertTrue("The wrong message is displayed", expectedMessage.equals(actualMessage));
    }

    @Test
    public void invalidUserNameValidPassword(){
        logInPage.enterUserName(LogInPage.INVALID_USER_NAME);
        logInPage.enterPassword(LogInPage.VALID_PASSWORD);
        logInPage.clickOnLoginInButton();

        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = logInPage.displayErrorMessageText();

        Assert.assertTrue("The wrong message is displayed", expectedMessage.equals(actualMessage));
    }

    @Test
    public void logInSuccessful(){
        logInPage.enterUserName(LogInPage.VALID_USER_NAME);
        logInPage.enterPassword(LogInPage.VALID_PASSWORD);
        logInPage.clickOnLoginInButton();

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Page after login is not correct!", LogInPage.CORRECT_URL_AFTER_LOGIN, actualUrl);
    }
}
