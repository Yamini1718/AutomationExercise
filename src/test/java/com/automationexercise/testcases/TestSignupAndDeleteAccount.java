package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.*;
import com.automationexercise.utils.ExcelUtiles;
import com.automationexercise.utils.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import com.automationexercise.utils.ExtentManager;

public class TestSignupAndDeleteAccount extends BaseClass {

    @Test
    public void signupAndDeleteAccount() throws Exception {
        ExtentTest test = ExtentManager.getInstance().createTest("SignUp And Delete Test");

        try {
            // Load Excel
            String excelPath = System.getProperty("user.dir") + "/testdata/userdata.xlsx";
            ExcelUtiles excel = new ExcelUtiles(excelPath, "SignUp");

            int row = 1; // 2nd row has data
            String name = excel.getCellData(row, 0);
            String email = excel.getCellData(row, 1);
            String password = excel.getCellData(row, 2);
            String firstName = excel.getCellData(row, 3);
            String lastName = excel.getCellData(row, 4);
            String company = excel.getCellData(row, 5);
            String address1 = excel.getCellData(row, 6);
            String address2 = excel.getCellData(row, 7);
            String country = excel.getCellData(row, 8);
            String state = excel.getCellData(row, 9);
            String city = excel.getCellData(row, 10);
            String zipcode = excel.getCellData(row, 11);
            String mobile = excel.getCellData(row, 12);

            // Home page
            HomePage home = new HomePage(driver, wait);
            Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");
            test.pass("Home page is visible");

            home.clickSignupLogin();
            test.pass("Clicked Signup/Login");

            SignupLoginPage signupLogin = new SignupLoginPage(driver, wait);
            signupLogin.enterName(name);
            signupLogin.enterEmail(email);
            signupLogin.clickSignupButton();
            test.pass("Entered name and email, clicked Signup");

            // Signup details
            SignupDetailsPage details = new SignupDetailsPage(driver, wait);
            details.enterPassword(password);
            details.enterFirstName(firstName);
            details.enterLastName(lastName);
            details.enterCompany(company);
            details.enterAddress1(address1);
            details.enterAddress2(address2);
            details.selectCountry(country);
            details.enterState(state);
            details.enterCity(city);
            details.enterZipcode(zipcode);
            details.enterMobileNumber(mobile);
            details.clickCreateAccount();
            test.pass("Filled signup details and clicked Create Account");

            // Account created
            AccountCreatedPage accountCreated = new AccountCreatedPage(driver, wait);
            Assert.assertTrue(accountCreated.isAccountCreatedVisible(), "Account not created");
           Screenshot.Capture(driver, "AccountCreated");
            test.pass("Account created");
            accountCreated.clickContinue();

            // Delete account
            home.deleteAccount();
            AccountDeletedPage accountDeleted = new AccountDeletedPage(driver, wait);
            Assert.assertTrue(accountDeleted.isAccountDeletedVisible(), "Account not deleted");
        Screenshot.Capture(driver, "AccountDeleted");
            test.pass("Account deleted");

            test.pass("Signup and Delete flow completed successfully");

        } catch (AssertionError | Exception e) {
            Screenshot.Capture(driver, "SignUpDelete_Failed");
            test.fail("Test failed: " + e.getMessage());
           
            throw e; // ensure TestNG marks it failed
        }
    }
}
