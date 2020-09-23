Feature: Regression Search Functionality

  Background: 
    Given Navigate to BGS Application

  @Regression
  Scenario: QA-BM-TC139 No Search Results Page
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.noResult |
    And It Should Display Message Zero Results Found

  @Regression
  Scenario: QA-BM-TC142 Verify Search Results
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    And Verify Search Results

  @Regression
  Scenario: QA-BM-TC142 Verify Search Count
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    And Verify Results Count

  @Regression
  Scenario: QA-BM-TC142 Verify Search Pagination
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    And Verify Results Paginations

  @Regression
  Scenario: QA-BM-TC409 Verify the sort by functionality
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then Verify Default is RELEVANCE in Sort Type
      | relevanceOrder | @testdata.search.Sorting.relv |
    Then Sort the Search Products in Ascending Order
      | AscendingOrder | @testdata.search.Sorting.AscOrder |
    Then Sort the Search Products in Descending Order
      | DescendingOrder | @testdata.search.Sorting.DesOrder |
    And I Click on First Product in PLP
    Then 'PDP' Page is Opened

  @Regression
  Scenario: QA-BM-TC141 Verify if the Customer is able to see all product types in search results
  When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then Verify Default is RELEVANCE in Sort Type
      | relevanceOrder | @testdata.search.Sorting.relv |
    Then Sort the Search Products in Ascending Order
      | AscendingOrder | @testdata.search.Sorting.AscOrder |
    Then Sort the Search Products in Descending Order
      | DescendingOrder | @testdata.search.Sorting.DesOrder |
    And I Click on First Product in PLP
    Then 'PDP' Page is Opened

  @Regression
  Scenario: QA-BM-TC141 Verify if the Customer is able to see all product types in search results
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |

  @Regression
  Scenario: QA-BM-89_User Management_ Verify the Currency and Profile Relationship of the user
    When I Click on Register Link
    When Select the Exisitng User as No
    When Select Personal Account
    And Input Account Details for New Personal Account:
      | newPerRegion   | @testdata.registration.personalregister.personalRegion            |
      | perName        | @testdata.registration.personalregister.personalname              |
      | perLast        | @testdata.registration.personalregister.personalLastName          |
      | perCountrycode | @testdata.registration.personalregister.personalCountryCode       |
      | perAreaCode    | @testdata.registration.personalregister.personalAreaCode          |
      | perPhoneNumb   | @testdata.registration.personalregister.personalPhoneNumber       |
      | perExtension   | @testdata.registration.personalregister.personalExtension         |
      | perEmailID     | @testdata.registration.PersonalloginInformation.emailAddress      |
      | perPassword    | @testdata.registration.PersonalloginInformation.Password          |
      | conPassword    | @testdata.registration.PersonalloginInformation.confimredPassword |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    And Verify Search Results
    And Validate the Currency Displayed is as per Country Code Selected

  @Regression
  Scenario: ALM  14669 QA-BM-266_Verify if the PLP and Search Results will display in a list format
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then User Able to View the Products Related to Searched Keyword
    Then Verify Search Results
    Then Verify Results Count
    When I Search for the Product:
      | searchProduct | @testdata.search.configProduct.searchProduct1 |
    Then Verify that Price of Configurable Product is Not Displayed in PLP

  @Regression
  Scenario: QA-BM-274_TC_ Price Row Setup_Verify if the user is able to select Categories
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    And Price Range Selected Should Match With Prices of Products Displayed
    And Verify Facets Selected Match With Results Displayed
