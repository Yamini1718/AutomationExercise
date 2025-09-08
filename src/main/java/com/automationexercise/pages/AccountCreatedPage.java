package com.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage {
	

    private WebDriver driver;
    private WebDriverWait wait;
    
   private By accountCreatemsg= By.xpath("//b[contains(text(),'Account Created!')]");
   private By Continuebtn=By.xpath("//a[@data-qa='continue-button']");
    public AccountCreatedPage(WebDriver driver) {
        this(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }


    public AccountCreatedPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isAccountCreatedVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatemsg)).isDisplayed();
        } catch(Exception e){
            return false;
        }
    }

    public void clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(Continuebtn)).click();
    }
}
