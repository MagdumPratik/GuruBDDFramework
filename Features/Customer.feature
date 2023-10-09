Feature: Customeer

Background: Steps common for all scenario
  Given user launch browser
    When User opens URL "https://demo.guru99.com/v4/index.php"
    And user pass Email as "mngr524719" and Password as "qUsUdAr"
    And click on login button
    Then Page Title should be "Guru99 Bank Manager HomePage"
   
   @sanity
  Scenario: Added new Customer
   When click on add new Customer
    And user enters customer info
    Then User can view confirmation message "Customer Registered Successfully!!!"
    And close browser

    #8127
    @smoke
    Scenario: Add New Account
     When click on add new Account
    And user enters customer account info
    Then User can view acccount generated massage "Account Generated Successfully!!!"
    And close browser
    