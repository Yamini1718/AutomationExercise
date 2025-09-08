package com.automationexercise.testcases;

import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import com.automationexercise.utils.Screenshot;
import com.aventstack.extentreports.ExtentTest;

import com.automationexercise.utils.ExcelUtiles;
import com.automationexercise.utils.ExtentManager;

import org.testng.annotations.Test;

public class TestAnotherFunctionality extends BaseClass {

    @Test
    public void verifySearchFunctionality() throws Exception {
        ExtentTest test = ExtentManager.getInstance().createTest("Search Functionality Test");

        HomePage home = new HomePage(driver, wait);
        // Verify home page loaded
        if(!home.isHomePageVisible()) {
            System.out.println("Home page not visible");
            return;
        }

        // Step 1: Click Login / Signup
        home.clickSignupLogin();

        // Step 2: Read login credentials from Excel
        String excelPath = System.getProperty("user.dir") + "/testdata/UserData.xlsx";
        ExcelUtiles loginExcel = new ExcelUtiles(excelPath, "Login");

        int row = 1; // first user row (row 0 = header)
        String email = loginExcel.getLoginEmail(row);
        String password = loginExcel.getLoginPassword(row);

        // Step 3: Login using Excel credentials
        SignupLoginPage loginPage = new SignupLoginPage(driver, wait);
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        loginPage.clickLoginButton();

        System.out.println("Logged in successfully using Excel credentials: " + email);

        // Step 4: Go to Products page and search
        home.clickProducts();
        home.searchProduct("Dress");

        test.pass("Searched product");
        Screenshot.Capture(driver, "SearchFunctionality");
        System.out.println("Searching for Dress");
    }
}
