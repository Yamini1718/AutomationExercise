package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;
//    Locators

    private By productDetails   = By.xpath("//div[contains(@class,'product-details')]");
    private By productName      = By.xpath("//div[contains(@class,'product-information')]//h2");
//    private By productCategory  = By.xpath("//div[contains(@class,'product-information')]//p[b[contains(text(),'Category')]]");
    private By productPrice     = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private By availability     = By.xpath("//div[contains(@class,'product-information')]//p[b[contains(text(),'Availability')]]");
    private By condition        = By.xpath("//div[contains(@class,'product-information')]//p[b[contains(text(),'Condition')]]");
    private By brand            = By.xpath("//div[contains(@class,'product-information')]//p[b[contains(text(),'Brand')]]");

    
    private By productCategory=By.xpath ("//section/div/div/div[2]/div[2]/div[2]/div/p[1]");

    public ProductDetailPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Visibility checks
    public boolean isProductDetailVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productDetails)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductNameVisible() { return !getProductName().isEmpty(); }
    public boolean isProductCategoryVisible() { return !getProductCategory().isEmpty(); }
    public boolean isProductPriceVisible() { return !getProductPrice().isEmpty(); }
    public boolean isProductAvailabilityVisible() { return !getProductAvailability().isEmpty(); }
    public boolean isProductConditionVisible() { return !getProductCondition().isEmpty(); }
    public boolean isProductBrandVisible() { return !getProductBrand().isEmpty(); }

    // Getters
    public String getProductName() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
        } catch (WebDriverException e) {
            return "";
        }
    }

    public String getProductCategory() {
        try {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory)).getText();
            return text.replace("Category:", "").trim();
        } catch (WebDriverException e) {
            return "";
        }
    }


    public String getProductPrice() {
        try {
            return driver.findElement(productPrice).getText();
        } catch (WebDriverException e) {
            return "";
        }
    }

    public String getProductAvailability() {
        try {
            String text = driver.findElement(availability).getText();
            return text.replace("Availability:", "").trim();
        } catch (WebDriverException e) {
            return "";
        }
    }

    public String getProductCondition() {
        try {
            String text = driver.findElement(condition).getText();
            return text.replace("Condition:", "").trim();
        } catch (WebDriverException e) {
            return "";
        }
    }

    public String getProductBrand() {
        try {
            String text = driver.findElement(brand).getText();
            return text.replace("Brand:", "").trim();
        } catch (WebDriverException e) {
            return "";
        }
    }
}
