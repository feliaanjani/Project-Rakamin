Feature: Login

  @Login @Positive
  Scenario: Success login with valid username and password
    Given Halaman login swaglab
    When Input Username
    And Input Password
    And Click Login button
    Then User in on dashboard page

  @Login @Negative
  Scenario: Failed login with invalid username and password
    Given Halaman login swaglab
    When Input invalid Username
    And Input invalid Password
    And Click Login button
    Then User get error message