package AppTests;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutInformationPage;
import pages.FinalShoppingPage;

public class ShoppingFlowTest extends LoginAndLogoutSetup {

    @Test
    public void checkThePurchaseOfTheProduct() throws InterruptedException {
        int number = productPage.getRandomFromNumberOfProducts();
        productItem.clickOnAddToCartButton(number);

        Assert.assertEquals("The number of items in the cart is not correct", 1, productPage.getActualNumberOfProductsInTheCart());
        Assert.assertEquals("The number of items in the cart is not correct", 1, productPage.getTheNumberOfRemoveButtons());

        String desc = productItem.getProductDesc(number);
        String title = productItem.getProductTitle(number);
        String price = productItem.getProductPriceNoDollarSymbol(number);

        productPage.clickOnTheCartButton();

        String descOnCartPage = productItem.getProductDesc(0);
        String titleOnCartPage = productItem.getProductTitle(0);
        String priceOnCartPage = productItem.getProductPriceNoDollarSymbol(0);

        Assert.assertEquals("Product descriptions do not match", desc, descOnCartPage);
        Assert.assertEquals("Product titles do not match", title, titleOnCartPage);
        Assert.assertEquals("Product prices do not match", price, priceOnCartPage);

        Thread.sleep(1000);

        productPage.clickOnCheckoutButton();

        checkoutInformation.enterFirstName();
        checkoutInformation.enterLastName();
        checkoutInformation.enterZipCode();

        checkoutInformation.clickOnContinueButton();

        String descOnCheckOutPage = productItem.getProductDesc(0);
        String titleOnCheckOutPage = productItem.getProductTitle(0);
        String priceOnCheckOutPage = productItem.getProductPriceNoDollarSymbol(0);

        Assert.assertEquals("Product descriptions do not match", desc, descOnCheckOutPage);
        Assert.assertEquals("Product titles do not match", title, titleOnCheckOutPage);
        Assert.assertEquals("Product prices do not match", price, priceOnCheckOutPage);

        double productPrice = Double.parseDouble(priceOnCheckOutPage);
        double expectedTotal = productPrice + (productPrice * CheckoutInformationPage.TAX);
        String expectedTotalFormatted = productPage.formatNumber(expectedTotal);

        String actualTotal = checkoutInformation.getTheFinalPrice();

        Assert.assertEquals("Product prices do not match", expectedTotalFormatted, actualTotal);

        checkoutInformation.clickOnFinishButton();

        Assert.assertEquals("Shopping has not been finalized", FinalShoppingPage.EXPECTED_TEXT_MESSAGE, finalShoppingPage.getText());
        Assert.assertEquals("Shopping has not been finalized", FinalShoppingPage.EXPECTED_SUB_TEXT_MESSAGE, finalShoppingPage.getSubText());
    }
}

