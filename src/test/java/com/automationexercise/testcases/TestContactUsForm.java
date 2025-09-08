package com.automationexercise.testcases;

import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.Screenshot;
import com.automationexercise.utils.ExcelUtiles;
import com.automationexercise.utils.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class TestContactUsForm extends BaseClass {

    @Test
    public void submitContactUsForm() throws Exception {

        ExtentTest test = ExtentManager.getInstance().createTest("Contact Us Form Test");

        // Navigate to Contact Us Page
        HomePage home = new HomePage(driver, wait);
        home.clickContactUs();
        test.pass("Clicked Contact Us");

        // Excel setup
        String excelPath = System.getProperty("user.dir") + "/testdata/UserData.xlsx";
        ExcelUtiles excel = new ExcelUtiles(excelPath, "ContactUs");

        // Defensive check if Excel sheet loaded
        if (!excel.isSheetLoaded()) {
            test.fail("Excel sheet not loaded: " + excelPath);
            Assert.fail("Excel sheet not loaded properly. Please check the sheet name.");
        }

        // Fetch data from Excel
        String name = excel.getContactName(1);
        String email = excel.getContactEmail(1);
        String subject = excel.getContactSubject(1);
        String message = excel.getContactMessage(1);

        // Fill the form
        ContactUsPage contact = new ContactUsPage(driver, wait);
        contact.enterName(name);
        contact.enterEmail(email);
        contact.enterSubject(subject);
        contact.enterMessage(message);
        test.pass("Filled Contact Us form fields");

        Screenshot.Capture(driver, "BeforeContactUsForm");

        // File upload with existence check
        String filePath = System.getProperty("user.dir") + "/testdata/sample.txt";
        File file = new File(filePath);
        if (file.exists()) {
            contact.uploadFile(filePath);
            test.pass("File uploaded: " + filePath);
        } else {
            test.warning("File not found: " + filePath);
        }

        // Submit form and handle alert
        contact.clickSubmit();
        contact.acceptAlert();

        // Verify success message
        Assert.assertTrue(contact.isSuccessMessageVisible(), "Success message not visible");
        test.pass("Contact Us form submitted successfully");

        // Capture screenshot
        Screenshot.Capture(driver, "ContactUsForm");
    }
}
