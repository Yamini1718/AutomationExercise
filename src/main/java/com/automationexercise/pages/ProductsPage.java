package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By ProductReviewBtn=By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By ProductsPageVisible=By.xpath("//h2[contains(text(),'All Products')]");
    		
    public ProductsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isAllProductsPageVisible(){
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPageVisible)).isDisplayed();
        } catch(Exception e){
            return false;
        }
    }

    public boolean isProductsListVisible(){
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".features_items"))).isDisplayed();
        } catch(Exception e){
            return false;
        }
    }

    public void clickFirstProductView(){
        wait.until(ExpectedConditions.elementToBeClickable(ProductReviewBtn)).click();
    }
}
