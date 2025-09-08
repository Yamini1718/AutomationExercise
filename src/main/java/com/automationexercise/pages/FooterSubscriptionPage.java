package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterSubscriptionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By subscriptionText = By.xpath("//div[@class='single-widget']/h2[contains(text(),'Subscription')]");
    private By emailField = By.id("susbscribe_email");  // fixed to match site typo
    private By subscribeButton = By.id("subscribe");
    private By successMsgText = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

    public FooterSubscriptionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Enter email
    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Click Subscribe
    public void clickSubscribe() {
        WebElement subscribeBtn = wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        subscribeBtn.click();
    }

    // Check if 'SUBSCRIPTION' text is visible
    public boolean isSubscriptionTextVisible() {
        try {
            WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText));
            return text.isDisplayed();
        } catch (Exception e) {
            System.out.println("Subscription text not visible: " + e.getMessage());
            return false;
        }
    }

    // Verify success message after subscription
    public boolean isSuccessMessageVisible() {
        try {
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsgText));
            return successMsg.isDisplayed();
        } catch (Exception e) {
            System.out.println("Success message not visible: " + e.getMessage());
            return false;
        }
    }
}
