package com.automationexercise.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDeletedPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By accountDeletedMsg = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    // Constructor with default wait
    public AccountDeletedPage(WebDriver driver) {
        this(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    // Constructor with custom wait
    public AccountDeletedPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Verify account deleted message
    public boolean isAccountDeletedVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMsg)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Account deleted message not visible: " + e.getMessage());
            return false;
        }
    }

    // Click Continue button
    public void clickContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
            System.out.println("Clicked on Continue button after account deletion.");
        } catch (Exception e) {
            System.out.println("Continue button not clickable: " + e.getMessage());
        }
    }
}
