package AppTests;

import org.junit.Assert;
import org.junit.Test;

public class CartPageTest extends LoginAndLogoutSetup {

    @Test
    public void SuccessfullyAddedItemToTheCart(){
        cartPage.clickAddToCartButton();
        String expectedNumberOfItems = "1";
        String actualNumberOfItems = cartPage.getShoppingCartNumber();
        Assert.assertEquals("The item has not been added to the cart", expectedNumberOfItems, actualNumberOfItems);
    }
}
