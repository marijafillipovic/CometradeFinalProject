package AppTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class BaseTestSetUp {

    public static WebDriver driver;

    LogInPage logInPage = new LogInPage(driver);
    CartPage cartPage = new CartPage(driver);
    LinksInFooterPage linksInFooterPage = new LinksInFooterPage(driver);
    ProductPage productPage = new ProductPage(driver);
    FinalShoppingPage finalShoppingPage = new FinalShoppingPage(driver);
    CheckoutInformationPage checkoutInformation = new CheckoutInformationPage(driver);
    ProductItem productItem = new ProductItem(driver);

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }

}


