Feature: Add to cart

  @AddToCart
  Scenario: Success add item to cart
    Given User can access Product page
    When Click Add to cart button
    Then Success add to cart