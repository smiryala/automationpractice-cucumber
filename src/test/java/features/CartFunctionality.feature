Feature: Regression Cart Functionality

  Background: 
    Given Navigate to BGS Application
  
  @Regression
  Scenario: QA-BM-233_Verify if the user is able to empty the cart
  
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    Then 'PLP' Page is Opened
    And I Click on First Product in PLP
    Then 'PDP' Page is Opened
    Then I Click on Add To Cart in PDP
    Then 'Added To Cart' PopUp is Opened
    Then Click on CheckOut in PopUp
    Then Remove All Items From Cart
    
@Regression
  Scenario: QA-BM-233_Verify if the user is able to view the empty cart message
  
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When Remove All Items From Cart
    Then Verify for Cart is Empty Message