
Feature: Authenticated User Functionality

  Background: 
    Given Navigate to BGS Application

  @Regression @Smoke
  Scenario: TC-01_Verify the user login
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-01_Verify the user login - User is not able to login with invalid credentials
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.invaliduser.username |
      | password | @testdata.login.invaliduser.password |
    Then 'LOGIN' Page is Opened
    And Following Error Message Should be Displayed:
      | errormsg | @testdata.login.invaliduser.errormsg |

  @Regression @Smoke
  Scenario: TC-06_Verify if search yields the expected products list
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    Then 'PLP' Page is Opened
    And Verify Result Matches with Actual Value
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-08_Verify Product listing page is visible properly 10 Products per page
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    Then 'PLP' Page is Opened
    And Verify Result Matches with Actual Value
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    And User Able to View the Products Related to Searched Keyword
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-10_Verify the display of Add to Cart popup in PLP
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    Then 'PLP' Page is Opened
    And I Click on First Product Add To Cart in PLP
    Then 'Added To Cart' PopUp is Opened
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-12_Verify Product description page is visible properly- must be different for configurable and non-configurable products
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
    Then Verify PDP Page for NonConfigurable Products
    When I Search for the Product:
      | searchProduct | @testdata.search.configProduct.searchProduct1 |
    Then 'PLP' Page is Opened
    And I Click on First Product in PLP
    Then 'PDP' Page is Opened
    Then Verify PDP Page for Configurable Products
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-13_Verify the display of Add to Cart popup in PDP
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
    And I Click on Add To Cart in PDP
    Then 'Added To Cart' PopUp is Opened
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-14_Verify increase or decrease, add or remove the products to or from the cart page
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
    When I Click on PLUS Sign Verify Quantity is Increased
    When I Click on MINUS Sign Verify Quantity is Decreased
    And I Click on Add To Cart in PDP
    Then 'Added To Cart' PopUp is Opened
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.simpleProduct |
    And I Click on First Product in PLP
    And I Click on Add To Cart in PDP
    Then Click on CheckOut in PopUp
    When I Click on REMOVE in Cart Page
    Then Product is Removed Message is Displayed
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-15_Validate the shipping address section in the checkout flow
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
    Then Validate Error Message for Country:
      | countryError | @testdata.shippingaddress.errormessages.country |
    Then Validate Error Message for Mandatory Fields in ShippingAddress:
      | firstNameError   | @testdata.shippingaddress.errormessages.firstName    |
      | lastNameError    | @testdata.shippingaddress.errormessages.lastName     |
      | add1Error        | @testdata.shippingaddress.errormessages.addressLine1 |
      | TownCityError    | @testdata.shippingaddress.errormessages.townCity     |
      | stateError       | @testdata.shippingaddress.errormessages.state        |
      | zipcodeError     | @testdata.shippingaddress.errormessages.zipPostCode  |
      | countrycodeError | @testdata.shippingaddress.errormessages.countryCode  |
      | areacodeError    | @testdata.shippingaddress.errormessages.areaCode     |
      | phoneError       | @testdata.shippingaddress.errormessages.phoneNumber  |
    Then Validate the All Fields in the Shipping Address
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

  @Regression @Smoke
  Scenario: TC-16_Validate the Shipping Details section in the checkout flow:
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
    And I Select Shipping Method:
      | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod |

  @Regression @Smoke
  Scenario: TC-17_Validate the Payment and Billing Address in the checkout flow page
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
    And I Select Shipping Method:
      | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod |
    And I Input Payment Information:
      | accountpayment | @testdata.shippingaddress.paymentbillingaddress.accountpaymentPOnumber |

  @Regression @Smoke
  Scenario: TC-18_Validate the Final Review section in the checkout flow
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
    And I Select Shipping Method:
      | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod |
    And I Input Payment Information:
      | accountpayment | @testdata.shippingaddress.paymentbillingaddress.accountpaymentPOnumber |
    Then Navigate to Final Review and Accept Terms and Condition

  @Regression @Smoke
  Scenario: TC-19_Verify if the user is able to place an order
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
    And I Select Shipping Method:
      | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod |
    And I Input Payment Information:
      | accountpayment | @testdata.shippingaddress.paymentbillingaddress.accountpaymentPOnumber |
    Then Navigate to Final Review and Accept Terms and Condition
    Then Click on Place Order Button

 @Regression @Smoke1
 Scenario: TC-25_Addition of configurable product to the cart
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search and Add Below Configurable Products to Cart:
      | searchProduct1 | @testdata.search.configProduct.searchProduct1         |
      | searchProduct2 | @testdata.search.configProduct.searchProduct2         |
      | searchProduct3 | @testdata.search.configProduct.searchProduct3         |
      | searchProduct4 | @testdata.search.configProduct.searchProduct4         |
      | searchProduct5 | @testdata.search.configProduct.searchProduct5         |
      | Aircraft       | @testdata.aircraftdetails.configPageDetails.Aircraft  |
      | Avionics       | @testdata.aircraftdetails.configPageDetails.Avionics  |
      | Coverages      | @testdata.aircraftdetails.configPageDetails.Coverages |


