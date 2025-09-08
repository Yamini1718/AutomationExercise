package com.automationexercise.testcases;

import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.FooterSubscriptionPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.Screenshot;
import com.automationexercise.utils.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSubscriptionFooter extends BaseClass {

    @Test
    public void verifyFooterSubscription() throws Exception {
        ExtentTest test = ExtentManager.getInstance().createTest("Footer Subscription Test");

        // Navigate to footer
        HomePage home = new HomePage(driver, wait);
        home.scrollToFooter();
        test.pass("Scrolled to footer");

        // Initialize footer page
        FooterSubscriptionPage footer = new FooterSubscriptionPage(driver, wait);

        // Verify "SUBSCRIPTION" text
        Assert.assertTrue(footer.isSubscriptionTextVisible(), "'SUBSCRIPTION' text not visible");
        test.pass("'SUBSCRIPTION' text is visible");

        // Generate a random email to avoid duplicate subscription error
        String randomEmail = "yamini" + System.currentTimeMillis() + "@test.com";

        // Enter email and subscribe
        footer.enterEmail(randomEmail);
        footer.clickSubscribe();
        test.pass("Entered email and clicked subscribe: " + randomEmail);

        // Verify success message
        Assert.assertTrue(footer.isSuccessMessageVisible(), "Subscription success message not visible");
        test.pass("Subscription success message displayed");

        // Capture screenshot
        Screenshot.Capture(driver, "FooterSubscription");
    }
}
