feature: Product Details Verification

  Scenario: Verify product details on product detail page
    Given I open the home page
    When I navigate to Products page
    And I view the first product
    Then I should see the product detail page
    And I should see product name
    And I should see product category
    And I should see product price
    And I should see product availability
    And I should see product condition
    And I should see product brand
