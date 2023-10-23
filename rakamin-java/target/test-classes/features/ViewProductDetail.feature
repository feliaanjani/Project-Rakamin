Feature: View Product Detail

  @ViewProductDetail
  Scenario: Success see product detail
    Given User success logged in to swaglab website
    When Click product name
    Then Success view product detail