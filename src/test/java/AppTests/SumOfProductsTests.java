package AppTests;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutInformationPage;

public class SumOfProductsTests extends LoginAndLogoutSetup {
    @Test
    public void sumOfItemsAddedToTheCart() throws InterruptedException {
        int number = productPage.getRandomFromNumberOfProducts();
        int number2 = productPage.getRandomFromNumberOfProducts();

        while (number == number2) {
            number2 = productPage.getRandomFromNumberOfProducts();
        }

        productItem.clickOnAddToCartButton(number);
        productItem.clickOnAddToCartButton(number2);

        productPage.clickOnTheCartButton();

        productPage.clickOnCheckoutButton();

        checkoutInformation.enterFirstName();
        checkoutInformation.enterLastName();
        checkoutInformation.enterZipCode();

        checkoutInformation.clickOnContinueButton();

        double price = Double.parseDouble(productItem.getProductPriceNoDollarSymbol(0));
        double price2 = Double.parseDouble(productItem.getProductPriceNoDollarSymbol(1));

        double totalSum = price + price2 + ((price + price2) * CheckoutInformationPage.TAX);
        String expectedTotalFormatted = productPage.formatNumber(totalSum);
        String actualTotal = checkoutInformation.getTheFinalPrice();

        Assert.assertEquals("Total price is not correct!", expectedTotalFormatted, actualTotal);
        System.out.println(actualTotal);
    }
}