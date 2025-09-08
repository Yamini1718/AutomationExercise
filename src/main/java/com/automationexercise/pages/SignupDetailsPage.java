package com.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    
    private By CreateAccountBtn=By.xpath("//button[@data-qa='create-account']");
    
    
    public SignupDetailsPage(WebDriver driver) {
        this(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }


    public SignupDetailsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year){
        new Select(driver.findElement(By.id("days"))).selectByValue(day);
        new Select(driver.findElement(By.id("months"))).selectByVisibleText(month);
        new Select(driver.findElement(By.id("years"))).selectByValue(year);
    }

    public void setNewsletter(boolean value){
        WebElement checkbox = driver.findElement(By.id("newsletter"));
        if(value != checkbox.isSelected()) checkbox.click();
    }

    public void setOffers(boolean value){
        WebElement checkbox = driver.findElement(By.id("optin"));
        if(value != checkbox.isSelected()) checkbox.click();
    }

    public void enterFirstName(String firstName) { driver.findElement(By.id("first_name")).sendKeys(firstName); }
    public void enterLastName(String lastName) { driver.findElement(By.id("last_name")).sendKeys(lastName); }
    public void enterCompany(String company) { driver.findElement(By.id("company")).sendKeys(company); }
    public void enterAddress1(String address) { driver.findElement(By.id("address1")).sendKeys(address); }
    public void enterAddress2(String address) { driver.findElement(By.id("address2")).sendKeys(address); }
    public void selectCountry(String country){ new Select(driver.findElement(By.id("country"))).selectByVisibleText(country); }
    public void enterState(String state) { driver.findElement(By.id("state")).sendKeys(state); }
    public void enterCity(String city) { driver.findElement(By.id("city")).sendKeys(city); }
    public void enterZipcode(String zip) { driver.findElement(By.id("zipcode")).sendKeys(zip); }
    public void enterMobileNumber(String mobile) { driver.findElement(By.id("mobile_number")).sendKeys(mobile); }

    public void clickCreateAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountBtn)).click();
    }
}
