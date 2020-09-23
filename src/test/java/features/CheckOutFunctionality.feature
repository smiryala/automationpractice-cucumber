Feature: Regression CheckOut Functionality

  Background: 
    Given Navigate to BGS Application
  
  @Regression
  Scenario: QA-BM-490_Integration_Verify user able to add New address in the checkout.
  
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
    Then Click on CheckOut in Cart Page
    And I Input Shipping Address Section:
      | shippingcountry         | @testdata.shippingaddress.basicaddress.country              |
      | shippingfirstname       | @testdata.shippingaddress.basicaddress.firstName            |
      | shippingLastName        | @testdata.shippingaddress.basicaddress.lastName             |
      | shippingaddress1        | @testdata.shippingaddress.basicaddress.addressLine1         |
      | shippingaddress2        | @testdata.shippingaddress.basicaddress.addressLine2Optional |
      | shippingaddresscity     | @testdata.shippingaddress.basicaddress.townCity             |
      | shippingaddressstate    | @testdata.shippingaddress.basicaddress.state                |
      | shippingzipcode         | @testdata.shippingaddress.basicaddress.zipPostCode          |
      | shippingcountrycode     | @testdata.shippingaddress.basicaddress.countryCode          |
      | shippingcountryareacode | @testdata.shippingaddress.basicaddress.areaCode             |
      | shippingphone           | @testdata.shippingaddress.basicaddress.phoneNumber          |
      | shippingExtension       | @testdata.shippingaddress.basicaddress.extension            |  
