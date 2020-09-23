Feature: System Test case

  Background: 
    Given Navigate to BGS Application

  @Refer
  Scenario: TCSYS 02_Adding aircraft details from My Account.
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    Then Click on My Account and Select New Aircraft
    When Input all Aircraft Details:
      | crafttailno   | @testdata.aircraftdetails.aeroDetails.aircraftTailNumber |
      | craftmanufact | @testdata.aircraftdetails.aeroDetails.aircraftMake       |
      | craftmodel    | @testdata.aircraftdetails.aeroDetails.aircraftModel      |
      | craftserialno | @testdata.aircraftdetails.aeroDetails.aircraftSerialno   |
      | craftYear     | @testdata.aircraftdetails.aeroDetails.aircraftYear       |
    Then Check Purchase Term and Condition and Save

  @Refer 
  Scenario: TCSYS 01_Registration with first Company Account
   When I Click on Register Link
    And Input Account Details of Company User:
      | comAccountNo   | @testdata.registration.register.companyAccountNumber |
      | comRegion      | @testdata.registration.register.companyRegion        |
      | comName        | @testdata.registration.register.companyname          |
      | comPostalCode  | @testdata.registration.register.companyPostalCode    |
      | comCountrycode | @testdata.registration.register.companyCountryCode   |
      | comAreaCode    | @testdata.registration.register.companyAreaCode      |
      | comPhoneNumb   | @testdata.registration.register.companyPhoneNumber   |
      | comExtension   | @testdata.registration.register.companyExtension     |
    Then Input Login Information Email Id and Password:
      | comEmailID  | @testdata.registration.loginInformation.emailAddress      |
      | comPassword | @testdata.registration.loginInformation.confimredPassword |

  Scenario: TC_Verify Ascending order of products list
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then 'PLP' Page is Opened
    And Verify Result Matches with Actual Value
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then Sort the search products in Ascending order
      | AscendingOrder | @testdata.search.Sorting.AscOrder |
    And I Click on LogOut

  @Refer
  Scenario: TC_Verify descending order of products list
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then 'PLP' Page is Opened
    And Verify Result Matches with Actual Value
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then Sort the search products in descending order
      | DescendingOrder | @testdata.search.Sorting.DesOrder |
    And I Click on LogOut

  @Refer
  Scenario: TCSYS-03_Product search and navigation
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByValue |
    Then 'PLP' Page is Opened
    And Verify Result Matches with Actual Value
      | searchProduct | @testdata.search.searchSystemTC.searchByValue |
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByName1 |
    Then 'PLP' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByName2 |
    Then 'PLP' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then 'PLP' Page is Opened
    And Verify Result Matches with Actual Value
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    And Price Range Selected Should Match With Prices of Products Displayed
    And Verify Facets Selected Match With Results Displayed

  @Refer
  Scenario: TCSYS-04 Verify the prices for configurable and non-configurable products
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.configProduct.searchProduct |
    Then 'PLP' Page is Opened
    And Verify The Price Of The Configurable Product Is Not Displayed In The PLP
    And Clicking Configurable Product to Re-directed To PDP Page
    Then 'PDP' Page is Opened
    Then User Should be Not be Able to See Any Price of the Configurable Product
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.simpleProduct |
    Then 'PLP' Page is Opened
    And Verify the Price and Currency of the Product for Simple Product
    Then 'PDP' Page is Opened
    Then Verify the Prices and Quantity Functionality
      | Quantity | @testdata.search.searchSystemTC.Quantity |
    And Price Range Selected Should Match With Prices of Products Displayed
    And Verify Facets Selected Match With Results Displayed

  @Refer
  Scenario: TCSYS-05 Adding the product to the cart when the inventory is available.
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
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    Then I Click on Add To Cart in PDP
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.MediaProduct |
    Then 'PLP' Page is Opened
    And I Click on First Product in PLP
    Then 'PDP' Page is Opened
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    Then I Click on Add To Cart in PDP
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
    Then 'PLP' Page is Opened
    And I Click on First Product in PLP
    Then 'PDP' Page is Opened
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    Then I Click on Add To Cart in PDP
    Then Click on Continue Shoping in PopUp
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

   
    
  @Refer
   Scenario: TCSYS 07_Price and discount in Cart.
		When I Click on Login
				And  I Login to BGS Application Using Below Credentials:
							|username	|	@testdata.login.validuser.username|
							|password |	@testdata.login.validuser.password|
			 Then 'HOME' Page is Opened
			 When I Search for the Product:
			      	|searchProduct| @testdata.search.simpleProduct.hardgoodProduct|
			 Then 'PLP' Page is Opened
			 And   I Click on First Product Add To Cart in PLP
			 Then 'Added To Cart' PopUp is Opened 
			 Then Click on Continue Shoping in PopUp	
			 When I Search for the Product:
			        | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
			 Then 'PLP' Page is Opened
			 And   I Click on First Product Add To Cart in PLP
			 Then 'Added To Cart' PopUp is Opened
			 Then Click on CheckOut in PopUp
			 When I Increase the Quantity Verify Item Total Price
			 When I Decrease the Quantity Verify Item Total Price
			 And Verify Cart Total Price
			 Then Click on CheckOut in Cart Page
		   Then 'CHECKOUT' Page is Opened
		      	
	@Refer
Scenario: TCSYS TC-08-Shipping address in the checkout
	
	When I Click on Login
				And  I Login to BGS Application Using Below Credentials:
					|username	|	@testdata.login.validuser.username|
					|password |	@testdata.login.validuser.password|
				Then 'HOME' Page is Opened
	 			When I Search for the Product:
     		 | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
  			Then 'PLP' Page is Opened
   		 And I Click on First Product in PLP
			 # Then 'PDP' Page is Opened
			Then I Click on Add To Cart in PDP
			Then 'Added To Cart' PopUp is Opened 
 			 Then Click on CheckOut in PopUp
 	 		Then Click on CheckOut in Cart Page
 			Then Validate Error Message for Country:
 				 	| countryError              | @testdata.shippingaddress.errormessages.country            | 	 	     
 			Then Validate Error Message for Mandatory Fields in ShippingAddress: 	 	   
      	| firstNameError           | @testdata.shippingaddress.errormessages.firstName             |
      	| lastNameError             | @testdata.shippingaddress.errormessages.lastName             |
      	| add1Error                | @testdata.shippingaddress.errormessages.addressLine1          |
       	| TownCityError            | @testdata.shippingaddress.errormessages.townCity              |
      	| stateError               | @testdata.shippingaddress.errormessages.state                 |
      	| zipcodeError             | @testdata.shippingaddress.errormessages.zipPostCode           |
      	| countrycodeError         | @testdata.shippingaddress.errormessages.countryCode           |
      	| areacodeError            | @testdata.shippingaddress.errormessages.areaCode              |       
      	| phoneError               | @testdata.shippingaddress.errormessages.phoneNumber           |
			Then Validate the All Fields in the Shipping Address
    	And I Input Shipping Address Section:
      	| shippingcountry          | @testdata.shippingaddress.basicaddress.country                |          
      	| shippingfirstname        | @testdata.shippingaddress.basicaddress.firstName              |
      	| shippingLastName         | @testdata.shippingaddress.basicaddress.lastName               |
      	| shippingaddress1         | @testdata.shippingaddress.basicaddress.addressLine1           |
     		| shippingaddress2         | @testdata.shippingaddress.basicaddress.addressLine2Optional   |
      	| shippingaddresscity      | @testdata.shippingaddress.basicaddress.townCity               |
      	| shippingaddressstate     | @testdata.shippingaddress.basicaddress.state                  |
      	| shippingzipcode          | @testdata.shippingaddress.basicaddress.zipPostCode            |
      	| shippingcountrycode      | @testdata.shippingaddress.basicaddress.countryCode            |
      	| shippingcountryareacode  | @testdata.shippingaddress.basicaddress.areaCode               |       
      	| shippingphone            | @testdata.shippingaddress.basicaddress.phoneNumber            |
      	| shippingExtension        | @testdata.shippingaddress.basicaddress.extension              |  
       And Click on Edit in Shipping Address
   		 And I Input Shipping Address Section:
      	| shippingcountry          | @testdata.shippingaddress.editaddress.country                 |          
      	| shippingfirstname        | @testdata.shippingaddress.editaddress.firstName               |
      	| shippingLastName         | @testdata.shippingaddress.editaddress.lastName                |
      	| shippingaddress1         | @testdata.shippingaddress.editaddress.addressLine1            |
     		| shippingaddress2         | @testdata.shippingaddress.editaddress.addressLine2Optional    |
      	| shippingaddresscity      | @testdata.shippingaddress.editaddress.townCity                |
      	| shippingaddressstate     | @testdata.shippingaddress.editaddress.state                   |
      	| shippingzipcode          | @testdata.shippingaddress.editaddress.zipPostCode             |
      	| shippingcountrycode      | @testdata.shippingaddress.editaddress.countryCode             |
      	| shippingcountryareacode  | @testdata.shippingaddress.editaddress.areaCode                |       
      	| shippingphone            | @testdata.shippingaddress.editaddress.phoneNumber             |
      	| shippingExtension        | @testdata.shippingaddress.editaddress.extension               |    
			And I Select Shipping Method: 
		   	| shippingdetails         | @testdata.shippingaddress.shippingdetails.shippingMethod       |
			Then Verify Shipping Method Lowest in the Top and Highest in the Bottom 

@Refer
Scenario: TCSYS TC-09-Validating the total prices in the Checkout page
		
	When I Click on Login
				And  I Login to BGS Application Using Below Credentials:
							|username	|	@testdata.login.validuser.username|
							|password |	@testdata.login.validuser.password|
			 Then 'HOME' Page is Opened
			 When I Search for the Product:
			      	|searchProduct| @testdata.search.simpleProduct.hardgoodProduct|
			 Then 'PLP' Page is Opened
			 And   I Click on First Product Add To Cart in PLP
			 Then 'Added To Cart' PopUp is Opened 
			 Then Click on Continue Shoping in PopUp	
			 When I Search for the Product:
			        | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
			 Then 'PLP' Page is Opened
			 And   I Click on First Product Add To Cart in PLP
			 Then 'Added To Cart' PopUp is Opened
			 Then Click on CheckOut in PopUp
			 When I Increase the Quantity Verify Item Total Price
			 Then Click on CheckOut in Cart Page
		   Then 'CHECKOUT' Page is Opened
		   Then Verify Order Totals 
		   
		      	
  @Refer
  Scenario: TCSYS-06 Adding configurable products to cart
    When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.ConfigUser |
      | password | @testdata.login.validuser.configpassword |
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

 