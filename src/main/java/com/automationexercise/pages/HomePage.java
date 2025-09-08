package com.automationexercise.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    
    private By SignUpbtn=By.xpath("//a[contains(text(),'Signup / Login')]");
    private By Productsbtn= By.xpath("//a[contains(text(),'Products')]");
    private By ContactUsbtn=By.xpath("//a[@href='/contact_us']");
    private By DeleteAccountbtn=By.xpath("//a[contains(text(),'Delete Account')]");
    // Overloaded constructors
   
    public HomePage(WebDriver driver) {
        this(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageVisible() {
        try {
            return wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector(".logo.pull-left"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSignupLogin() {
        wait.until(ExpectedConditions
                .elementToBeClickable(SignUpbtn)).click();
    }

    public void clickProducts() {
        wait.until(ExpectedConditions
                .elementToBeClickable(Productsbtn)).click();
    }

    public void clickContactUs() {
        wait.until(ExpectedConditions
                .elementToBeClickable(ContactUsbtn)).click();
    }

    // ✅ Fixed scrolling to footer
    public void scrollToFooter() {
        try {
            WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("footer")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
            Thread.sleep(500); // small wait for stability
        } catch (Exception e) {
            System.out.println("Footer not found or could not scroll: " + e.getMessage());
        }
    }

    // ✅ Search product
    public void searchProduct(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }

    // ✅ Delete account
    public void deleteAccount() {
        wait.until(ExpectedConditions
                .elementToBeClickable(DeleteAccountbtn)).click();
    }
}
