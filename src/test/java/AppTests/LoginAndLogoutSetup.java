package AppTests;

import org.junit.After;
import org.junit.Before;
import pages.LogInPage;

public class LoginAndLogoutSetup extends BaseTestSetUp {

    @Before
    public  void beforeEach() {
        logInPage.enterUserName(LogInPage.VALID_USER_NAME);
        logInPage.enterPassword(LogInPage.VALID_PASSWORD);
        logInPage.clickOnLoginInButton();
    }

    @After
    public void afterEach() throws InterruptedException {
        logInPage.clickOnOptionsMenu();
        Thread.sleep(500);
        logInPage.clickOnResetAppState();
        Thread.sleep(300);
        logInPage.clickOnLogOutButton();
    }
}
