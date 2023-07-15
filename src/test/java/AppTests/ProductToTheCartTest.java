package AppTests;

import org.junit.Assert;
import org.junit.Test;

public class ProductToTheCartTest extends LoginAndLogoutSetup {

    @Test
    public void randomItemAddedToCart() {
        int number = productPage.getRandomFromNumberOfProducts();
        productItem.clickOnAddToCartButton(number);

        Assert.assertEquals("The number of items in the cart is not correct", 1, productPage.getActualNumberOfProductsInTheCart());
        Assert.assertEquals("The number of items in the cart is not correct", 1, productPage.getTheNumberOfRemoveButtons());

        String desc = productItem.getProductDesc(number);
        String title = productItem.getProductTitle(number);
        String price = productItem.getProductPrice(number);

        productPage.clickOnTheCartButton();

        String descOnCartPage = productItem.getProductDesc(0);
        String titleOnCartPage = productItem.getProductTitle(0);
        String priceOnCartPage = productItem.getProductPrice(0);

        Assert.assertEquals("Product descriptions do not match", desc, descOnCartPage);
        Assert.assertEquals("Product titles do not match", title, titleOnCartPage);
        Assert.assertEquals("Product prices do not match", price, priceOnCartPage);

    }

    @Test
    public void theFirstTwoItemsAddedToCart() {
        productItem.clickOnAddToCartButton(0);
        productItem.clickOnAddToCartButton(1);
        int actualNumberOfItemsInTheCart = productPage.getActualNumberOfProductsInTheCart();
        Assert.assertEquals("The number of added products does not match", 2, actualNumberOfItemsInTheCart);
    }

    @Test
    public void twoRandomItemsAddedToCart() {
        int numberOfProductsToAdd = productPage.getRandomFromNumberOfProducts();

        if (numberOfProductsToAdd == 0) {
            numberOfProductsToAdd = 1;
        }

        for (int i=0; i < numberOfProductsToAdd; i++){
            productItem.clickOnAddToCartButton(i);
        }

        int actualNumberOfItemsInTheCart = productPage.getActualNumberOfProductsInTheCart();

        Assert.assertEquals("The number of added products does not match", numberOfProductsToAdd, actualNumberOfItemsInTheCart);

        productPage.clickOnTheCartButton();

        Assert.assertEquals("The number of remove buttons does not match to the number of added items to the cart", numberOfProductsToAdd, productPage.getTheNumberOfRemoveButtons());
    }
}
