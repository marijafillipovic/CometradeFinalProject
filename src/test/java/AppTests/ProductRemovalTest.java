package AppTests;

import org.junit.Assert;
import org.junit.Test;

public class ProductRemovalTest extends LoginAndLogoutSetup {
    @Test
    public void productRemoval() {
        int number = productPage.getRandomFromNumberOfProducts();
        int number2 = productPage.getRandomFromNumberOfProducts();

        while(number == number2) {
            number2 = productPage.getRandomFromNumberOfProducts();
        }

        String secondProductTitle = productItem.getProductTitle(number2);

        productItem.clickOnAddToCartButton(number);
        productItem.clickOnAddToCartButton(number2);

        productPage.clickOnTheCartButton();

        productItem.clickOnRemoveButton();

        String retainedTitle = productItem.getProductTitle(0);

        Assert.assertEquals("Removal of the product is not successful", 1, productPage.getTheNumberOfRemoveButtons());
        Assert.assertEquals("Removal of the product is not successful", secondProductTitle, retainedTitle);
    }
}