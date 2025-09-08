package com.automationexercise.stepdefinitions;

import com.automationexercise.base.BaseClass;
import com.automationexercise.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductSteps extends BaseClass {

    HomePage home;
    ProductsPage products;
    ProductDetailPage productDetail;

    @Given("I open the home page")
    public void i_open_home_page() {
        home = new HomePage(driver, wait);
        Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");
    }

    @When("I navigate to Products page")
    public void i_navigate_to_products_page() {
        home.clickProducts();
        products = new ProductsPage(driver, wait);
        Assert.assertTrue(products.isAllProductsPageVisible(), "Products page not visible");
    }

    @When("I view the first product")
    public void i_view_the_first_product() {
        products.clickFirstProductView();
        productDetail = new ProductDetailPage(driver, wait);
    }

    @Then("I should see the product detail page")
    public void i_should_see_the_product_detail_page() {
        Assert.assertTrue(productDetail.isProductDetailVisible(), "Product detail not visible");
    }

    @Then("I should see product name")
    public void i_should_see_product_name() {
        Assert.assertTrue(productDetail.isProductNameVisible(), "Product name not visible");
    }

    @Then("I should see product category")
    public void i_should_see_product_category() {
        Assert.assertTrue(productDetail.isProductCategoryVisible(), "Product category not visible");
    }

    @Then("I should see product price")
    public void i_should_see_product_price() {
        Assert.assertTrue(productDetail.isProductPriceVisible(), "Product price not visible");
    }

    @Then("I should see product availability")
    public void i_should_see_product_availability() {
        Assert.assertTrue(productDetail.isProductAvailabilityVisible(), "Product availability not visible");
    }

    @Then("I should see product condition")
    public void i_should_see_product_condition() {
        Assert.assertTrue(productDetail.isProductConditionVisible(), "Product condition not visible");
    }

    @Then("I should see product brand")
    public void i_should_see_product_brand() {
        Assert.assertTrue(productDetail.isProductBrandVisible(), "Product brand not visible");
    }
}



