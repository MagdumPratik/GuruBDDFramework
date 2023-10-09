Feature: Login

@sanity
  Scenario: User is able to login with valid creadintial
    Given user launch browser
    When User opens URL "https://demo.guru99.com/v4/index.php"
    And user pass Email as "mngr524719" and Password as "qUsUdAr"
    And click on login button
    Then Page Title should be "Guru99 Bank Manager HomePage"
    When click on logout button
    And close Browser

@regres
    Scenario Outline: DAT Test Cases
    Given user launch browser
    When User opens URL "https://demo.guru99.com/v4/index.php"
    And user pass Email as "<email>" and Password as "<password>"
    And click on login button
    Then Page Title should be "Manger Id : mngr524719"
    When click on logout button
    And close Browser
    
    Examples:
    |email|password|
    |mngr524719|qUsUdAr|
    |mngr524|qUsUdAr|