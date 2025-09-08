package com.automationexercise.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    
    //Locators
    private By NewUserSignupBtn=By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By SignupEmailBtn=By.xpath("//input[@data-qa='signup-email']");
    private By SignupBtn=By.xpath("//button[@data-qa='signup-button']");
    private By LoginVisibleBtn= By.xpath("//h2[contains(text(),'Login to your account')]");
    private By LoginEmailBtn=By.xpath("//input[@data-qa='login-email']");
    private By LoginPasswordBtn=By.xpath("//input[@data-qa='login-password']");
    private By LoginButtonBtn=By.xpath("//button[@data-qa='login-button']");
    public SignupLoginPage(WebDriver driver) {
        this(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public SignupLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // --------------------- Signup methods ---------------------
    public boolean isNewUserSignupVisible() {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(NewUserSignupBtn
                    ));
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        el.clear();
        el.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(SignupEmailBtn));
        el.clear();
        el.sendKeys(email);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SignupBtn)).click();
    }

    // --------------------- Login methods ---------------------
    public boolean isLoginVisible() {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginVisibleBtn
                   ));
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterLoginEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginEmailBtn
                ));
        el.clear();
        el.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPasswordBtn
                ));
        el.clear();
        el.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButtonBtn
                )).click();
    }
}
