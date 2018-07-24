Feature: LoginFeature
  This feature deals with login issue

  Scenario: Login with the correct username and password
    Given I navigate to the login page
    And I enter the username as admin and password as admin
    And I enter again the username as "admin" and password as "adminpassword"
    And I enter the following for login
      | username | password       |
      | admin1   | admin1password |
      | admin2   | admin2password |
    And I click login button
    Then I should see the userform page