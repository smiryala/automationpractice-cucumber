Feature: E2E with New Company Account

  Background: 
    Given Navigate to BGS Application

 @STC @Scenario4
  Scenario: TCSYS 04_E2E with New Personal Account
    When I Click on Login
    	And I Login to BGS Application Using Below Credentials:
	      | username | @testdata.login.validuser.company  |
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
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByValue |
	    And Verify Result Matches with Actual Value
	      | searchProduct | @testdata.search.searchSystemTC.searchByValue |
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByName1 |
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByName2 |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
	    And Verify Result Matches with Actual Value
	      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then Sort the Search Products in Ascending Order
      | AscendingOrder | @testdata.search.Sorting.AscOrder |
    Then Sort the Search Products in Descending Order
      | DescendingOrder | @testdata.search.Sorting.DesOrder |
	    And Price Range Selected Should Match With Prices of Products Displayed
	    And Verify Facets Selected Match With Results Displayed
    #When I Search for the Product:
    #  | searchProduct | @testdata.search.configProduct.searchProduct |
     # And Verify that Price of Configurable Product is Not Displayed in PLP
	   # And Clicking Configurable Product to Re-directed To PDP Page
    #Then User Should be Not be Able to See Any Price of the Configurable Product
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.simpleProduct |
    	And Verify the Price and Currency of the Product for Simple Product
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.MediaProduct |
    	And I Click on First Product in PLP
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    Then I Click on Add To Cart in PDP
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
    	And I Click on First Product in PLP
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    #When I Search and Add Below Configurable Products to Cart:
    #| searchProduct1 | @testdata.search.configProduct.searchProduct1         |
    #| searchProduct2 | @testdata.search.configProduct.searchProduct2         |
    #| searchProduct3 | @testdata.search.configProduct.searchProduct3         |
    #| searchProduct4 | @testdata.search.configProduct.searchProduct4         |
    #| Aircraft       | @testdata.aircraftdetails.configPageDetails.Aircraft  |
    # | Avionics       | @testdata.aircraftdetails.configPageDetails.Avionics  |
    #| Coverages      | @testdata.aircraftdetails.configPageDetails.Coverages |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    Then 'PLP' Page is Opened
    	And I Click on First Product Add To Cart in PLP
    Then 'Added To Cart' PopUp is Opened
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
    Then 'PLP' Page is Opened
    	And I Click on First Product Add To Cart in PLP
    Then 'Added To Cart' PopUp is Opened
    Then Click on CheckOut in PopUp
    When I Increase the Quantity Verify Item Total Price
    When I Decrease the Quantity Verify Item Total Price
    	And Verify Cart Total Price
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
	    And Click on Edit in Shipping Address
	    And I Input Shipping Address Section:
	      | shippingcountry         | @testdata.shippingaddress.editaddress.country              |
	      | shippingfirstname       | @testdata.shippingaddress.editaddress.firstName            |
	      | shippingLastName        | @testdata.shippingaddress.editaddress.lastName             |
	      | shippingaddress1        | @testdata.shippingaddress.editaddress.addressLine1         |
	      | shippingaddress2        | @testdata.shippingaddress.editaddress.addressLine2Optional |
	      | shippingaddresscity     | @testdata.shippingaddress.editaddress.townCity             |
	      | shippingaddressstate    | @testdata.shippingaddress.editaddress.state                |
	      | shippingzipcode         | @testdata.shippingaddress.editaddress.zipPostCode          |
	      | shippingcountrycode     | @testdata.shippingaddress.editaddress.countryCode          |
	      | shippingcountryareacode | @testdata.shippingaddress.editaddress.areaCode             |
	      | shippingphone           | @testdata.shippingaddress.editaddress.phoneNumber          |
	      | shippingExtension       | @testdata.shippingaddress.editaddress.extension            |
	   Then Verify Shipping Method Lowest in the Top and Highest in the Bottom
    	And I Select Shipping Method:
     		 | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod |
    	And I Input Payment Information:
     	 	 | accountpayment | @testdata.shippingaddress.paymentbillingaddress.accountpaymentPOnumber |
    	And Verify Order Totals
    Then Navigate to Final Review and Accept Terms and Condition
    Then Click on Place Order Button
    Then Verify Order Confirmation Page Validation
    When I Navigate to Order History Page
    Then Verify Order History Table Headers:
      	| Order number |
      	| Status       |
      	| Date placed  |
      	| Total        |
    	And Verify Sort with Order Number in Order History Table
   	  And Verify Sort with Date in Order History Table
    Then Verify Order Details Page Validation
  
  Scenario: TCSYS 04_E2E with New Personal Account
    When I Click on Register Link
    When Select the Exisitng User as No
    When Select Company Account
	    And Input Account Details for New Company Account:
	      | newcomRegion   | @testdata.registration.companyregister.companyRegion             |
	      | comName        | @testdata.registration.companyregister.companyname               |
	      | comCountrycode | @testdata.registration.companyregister.companyCountryCode        |
	      | comAreaCode    | @testdata.registration.companyregister.companyAreaCode           |
	      | comPhoneNumb   | @testdata.registration.companyregister.companyPhoneNumber        |
	      | comExtension   | @testdata.registration.companyregister.companyExtension          |
	      | comEmailID     | @testdata.registration.CompanyloginInformation.emailAddress      |
	      | comPassword    | @testdata.registration.CompanyloginInformation.Password          |
	      | conPassword    | @testdata.registration.CompanyloginInformation.confimredPassword |
    Then 'HOME' Page is Opened
    	And I Click on LogOut
    Then 'LOGIN' Page is Opened         
    When I Click on Login
	    And I Login to BGS Application Using Below Credentials:
	      | username | @envVariable.email 																			|
	      | password | @testdata.registration.CompanyloginInformation.Password  |
    Then 'HOME' Page is Opened    
    Then Click on My Account and Select New Aircraft
    When Input all Aircraft Details:
      | crafttailno   | @testdata.aircraftdetails.aeroDetails.aircraftTailNumber |
      | craftmanufact | @testdata.aircraftdetails.aeroDetails.aircraftMake       |
      | craftmodel    | @testdata.aircraftdetails.aeroDetails.aircraftModel      |
      | craftserialno | @testdata.aircraftdetails.aeroDetails.aircraftSerialno   |
      | craftYear     | @testdata.aircraftdetails.aeroDetails.aircraftYear       |
    Then Check Purchase Term and Condition and Save


    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByValue |
	    And Verify Result Matches with Actual Value
	      | searchProduct | @testdata.search.searchSystemTC.searchByValue |
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByName1 |
    When I Search for the Product:
      | searchProduct | @testdata.search.searchSystemTC.searchByName2 |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleSearch.searchProduct |
	    And Verify Result Matches with Actual Value
	      | searchProduct | @testdata.search.simpleSearch.searchProduct |
    Then Sort the Search Products in Ascending Order
      | AscendingOrder | @testdata.search.Sorting.AscOrder |
    Then Sort the Search Products in Descending Order
      | DescendingOrder | @testdata.search.Sorting.DesOrder |
	    And Price Range Selected Should Match With Prices of Products Displayed
	    And Verify Facets Selected Match With Results Displayed
    When I Search for the Product:
      | searchProduct | @testdata.search.configProduct.searchProduct |
      And Verify that Price of Configurable Product is Not Displayed in PLP
	    And Clicking Configurable Product to Re-directed To PDP Page
    Then User Should be Not be Able to See Any Price of the Configurable Product
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.simpleProduct |
    	And Verify the Price and Currency of the Product for Simple Product
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.MediaProduct |
    	And I Click on First Product in PLP
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    Then I Click on Add To Cart in PDP
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
    	And I Click on First Product in PLP
    Then Verify the Prices and Quantity Functionality
      | Quantity  | @testdata.search.searchSystemTC.Quantity  |
      | Quantity1 | @testdata.search.searchSystemTC.Quantity1 |
    #When I Search and Add Below Configurable Products to Cart:
    #| searchProduct1 | @testdata.search.configProduct.searchProduct1         |
    #| searchProduct2 | @testdata.search.configProduct.searchProduct2         |
    #| searchProduct3 | @testdata.search.configProduct.searchProduct3         |
    #| searchProduct4 | @testdata.search.configProduct.searchProduct4         |
    #| Aircraft       | @testdata.aircraftdetails.configPageDetails.Aircraft  |
    # | Avionics       | @testdata.aircraftdetails.configPageDetails.Avionics  |
    #| Coverages      | @testdata.aircraftdetails.configPageDetails.Coverages |
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
    Then 'PLP' Page is Opened
    	And I Click on First Product Add To Cart in PLP
    Then 'Added To Cart' PopUp is Opened
    Then Click on Continue Shoping in PopUp
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.onlinelearningProduct |
    Then 'PLP' Page is Opened
    	And I Click on First Product Add To Cart in PLP
    Then 'Added To Cart' PopUp is Opened
    Then Click on CheckOut in PopUp
    When I Increase the Quantity Verify Item Total Price
    When I Decrease the Quantity Verify Item Total Price
    	And Verify Cart Total Price
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
	    And Click on Edit in Shipping Address
	    And I Input Shipping Address Section:
	      | shippingcountry         | @testdata.shippingaddress.editaddress.country              |
	      | shippingfirstname       | @testdata.shippingaddress.editaddress.firstName            |
	      | shippingLastName        | @testdata.shippingaddress.editaddress.lastName             |
	      | shippingaddress1        | @testdata.shippingaddress.editaddress.addressLine1         |
	      | shippingaddress2        | @testdata.shippingaddress.editaddress.addressLine2Optional |
	      | shippingaddresscity     | @testdata.shippingaddress.editaddress.townCity             |
	      | shippingaddressstate    | @testdata.shippingaddress.editaddress.state                |
	      | shippingzipcode         | @testdata.shippingaddress.editaddress.zipPostCode          |
	      | shippingcountrycode     | @testdata.shippingaddress.editaddress.countryCode          |
	      | shippingcountryareacode | @testdata.shippingaddress.editaddress.areaCode             |
	      | shippingphone           | @testdata.shippingaddress.editaddress.phoneNumber          |
	      | shippingExtension       | @testdata.shippingaddress.editaddress.extension            |
	   Then Verify Shipping Method Lowest in the Top and Highest in the Bottom
    	And I Select Shipping Method:
     		 | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod |
    	And I Input Payment Information:
     	 	 | accountpayment | @testdata.shippingaddress.paymentbillingaddress.accountpaymentPOnumber |
    	And Verify Order Totals
    Then Navigate to Final Review and Accept Terms and Condition
    Then Click on Place Order Button
    Then Verify Order Confirmation Page Validation
    When I Navigate to Order History Page
    Then Verify Order History Table Headers:
      	| Order number |
      	| Status       |
      	| Date placed  |
      	| Total        |
    	And Verify Sort with Order Number in Order History Table
   	  And Verify Sort with Date in Order History Table
    Then Verify Order Details Page Validation   