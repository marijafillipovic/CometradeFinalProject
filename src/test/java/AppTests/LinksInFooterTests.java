package AppTests;

import org.junit.Assert;
import org.junit.Test;
import pages.LinksInFooterPage;

public class LinksInFooterTests extends LoginAndLogoutSetup {

        @Test
        public void correctTwitterLinkInFooter() throws InterruptedException {
            linksInFooterPage.clickOnTheTwitterButton();
            linksInFooterPage.switchTab();
            String actualLink = driver.getCurrentUrl();
            Assert.assertTrue("URLs do not match", linksInFooterPage.EXPECTED_TWITTER_LINK.equals(actualLink));
            driver.close();
            linksInFooterPage.switchToFirstTab();
        }

         @Test
         public void correctFacebookLinkInFooter() throws InterruptedException {
            String obtainedLink = linksInFooterPage.getFacebookHref();
            Assert.assertTrue("URLs do not match", obtainedLink.equals(LinksInFooterPage.EXPECTED_FACEBOOK_LINK));
            linksInFooterPage.clickOnTheFacebookButton();
            linksInFooterPage.switchTab();
            String actualLink = driver.getCurrentUrl();
            Assert.assertTrue("URLs do not match", linksInFooterPage.EXPECTED_FACEBOOK_LINK.equals(actualLink));
            driver.close();
            linksInFooterPage.switchToFirstTab();
        }

        @Test
        public void correctLinkedInLinkInFooter() throws InterruptedException {
            String obtainedLink = linksInFooterPage.getLinkedInHref();
            Assert.assertTrue("URLs do not match", obtainedLink.equals(LinksInFooterPage.EXPECTED_LINKEDIN_LINK));
        }

    }

