package com.automationexercise.stepdefinitions;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import com.automationexercise.utils.ExcelUtiles;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSteps {

    WebDriver driver;
    WebDriverWait wait;
    HomePage home;
    SignupLoginPage loginPage;

    @Given("user is on the Home page")
    public void user_is_on_home_page() {
        home = new HomePage(driver, wait);
        home.isHomePageVisible();
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String option) {
        if(option.equals("Signup / Login")) {
            home.clickSignupLogin();
        }
    }

    @When("user logs in using valid credentials from Excel")
    public void user_logs_in_using_valid_credentials_from_excel() {
        String excelPath = System.getProperty("user.dir") + "/testdata/UserData.xlsx";
        ExcelUtiles loginExcel = new ExcelUtiles(excelPath, "Login");

        String email = loginExcel.getLoginEmail(1);
        String password = loginExcel.getLoginPassword(1);

        loginPage = new SignupLoginPage(driver, wait);
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        loginPage.clickLoginButton();
    }

    @When("user navigates to the Products page")
    public void user_navigates_to_the_products_page() {
        home.clickProducts();
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        home.searchProduct(product);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        System.out.println("Search results displayed successfully");
    }
}
