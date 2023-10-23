Feature: Logout

  @Logout
  Scenario: Success logout
    Given User have logged in to swaglab website
    When Click hamburger menu
    And Click logout menu
    Then Success logout