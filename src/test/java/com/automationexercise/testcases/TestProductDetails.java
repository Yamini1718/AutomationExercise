package com.automationexercise.testcases;

import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.*;
import com.automationexercise.utils.ExtentManager;
import com.automationexercise.utils.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductDetails extends BaseClass {

    @Test
    public void verifyProductDetails() throws Exception {
        ExtentTest test = ExtentManager.getInstance().createTest("Product Details Test");

        try {
            // Home Page
            HomePage home = new HomePage(driver, wait);
            Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");
            test.pass("Home page is visible");

            home.clickProducts();
            test.pass("Clicked Products");

            // Products Page
            ProductsPage products = new ProductsPage(driver, wait);
            Assert.assertTrue(products.isAllProductsPageVisible(), "All Products page not visible");
            test.pass("All Products page is visible");

            products.clickFirstProductView();
            test.pass("Clicked View Product");

            // Product Detail Page
            ProductDetailPage productDetail = new ProductDetailPage(driver, wait);
            Assert.assertTrue(productDetail.isProductDetailVisible(), "Product detail not visible");
            test.pass("Product detail page is visible");

            Assert.assertTrue(productDetail.isProductNameVisible(), "Product name not visible");
            test.pass("Product name is visible");

            Assert.assertTrue(productDetail.isProductCategoryVisible(), "Product category not visible");
            test.pass("Product category is visible");

            Assert.assertTrue(productDetail.isProductPriceVisible(), "Product price not visible");
            test.pass("Product price is visible");

            Assert.assertTrue(productDetail.isProductAvailabilityVisible(), "Availability not visible");
            test.pass("Product availability is visible");

            Assert.assertTrue(productDetail.isProductConditionVisible(), "Condition not visible");
            test.pass("Product condition is visible");

            Assert.assertTrue(productDetail.isProductBrandVisible(), "Brand not visible");
            test.pass("Product brand is visible");

            Screenshot.Capture(driver, "ProductDetail");
            test.pass("Screenshot captured: ProductDetail");

            // Console Output
            System.out.println("Product Name: " + productDetail.getProductName());
            System.out.println("Category: " + productDetail.getProductCategory());
            System.out.println("Price: " + productDetail.getProductPrice());
            System.out.println("Availability: " + productDetail.getProductAvailability());
            System.out.println("Condition: " + productDetail.getProductCondition());
            System.out.println("Brand: " + productDetail.getProductBrand());

            test.pass("All product details verified successfully");

        } catch (AssertionError | Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Screenshot.Capture(driver, "ProductDetail_Failed");
            throw e; // rethrow to mark test as failed in TestNG
        }
    }
}
