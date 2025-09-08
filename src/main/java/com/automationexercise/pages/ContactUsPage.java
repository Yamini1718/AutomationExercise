package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By successMsg = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
    private By getInTouchHeader = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By subjectInput = By.name("subject");
    private By messageInput = By.name("message");
    private By uploadFileInput = By.name("upload_file");
    private By submitButton = By.name("submit");

    // Constructor
    public ContactUsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Check if "Get In Touch" header is visible
    public boolean isGetInTouchVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchHeader)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ 'Get In Touch' header not visible: " + e.getMessage());
            return false;
        }
    }

    // Fill contact form
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void enterSubject(String subject) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput)).sendKeys(subject);
    }

    public void enterMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageInput)).sendKeys(message);
    }

    // Upload a file
    public void uploadFile(String path) {
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadFileInput)).sendKeys(path);
    }

    // Click submit button
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    // Handle alert after submit
    public void acceptAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println("✅ Alert accepted successfully.");
        } catch (Exception e) {
            System.out.println("⚠ No alert appeared: " + e.getMessage());
        }
    }

    // Verify success message is visible
    public boolean isSuccessMessageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Success message not visible: " + e.getMessage());
            return false;
        }
    }
}
