Feature: addEmployee
  Scenario: adding an employee
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option
    When user enters firstName , middleName and lastName
    And user clicks on save button
    Then employee added successfully