Feature: ASM Agent Functionality

  Background: 
    Given Navigate to BGS Application
    
  
  Scenario: QA-BM-77-Able to place an order by impersonation
 When Navigate to BGS Application Using ASM Agent
   And I Login to BGS ASM Application Using Below Credentials:
	      | username      | @testdata.login.asmLogin.username      |
	      | password      | @testdata.login.asmLogin.password      | 
 			  | customername  | @testdata.login.asmLogin.customername  | 
 	  When I Search for the Product:
		      | searchProduct | @testdata.search.simpleSearch.searchProduct |
	  Then 'PLP' Page is Opened
	  And I Click on First Product in PLP
	  Then 'PDP' Page is Opened
	  Then I Click on Add To Cart in PDP
	  Then 'Added To Cart' PopUp is Opened
		Then Click on CheckOut in PopUp
		Then Click on CheckOut in Cart Page
		And I Input Shipping Address Section:
		      | shippingcountry         | @testdata.shippingaddress.basicaddress.country                |
		      | shippingfirstname       | @testdata.shippingaddress.basicaddress.firstName              |
		      | shippingLastName        | @testdata.shippingaddress.basicaddress.lastName               |
		      | shippingaddress1        | @testdata.shippingaddress.basicaddress.addressLine1           |
		      | shippingaddress2        | @testdata.shippingaddress.basicaddress.addressLine2Optional   |
		      | shippingaddresscity     | @testdata.shippingaddress.basicaddress.townCity               |
		      | shippingaddressstate    | @testdata.shippingaddress.basicaddress.state                  |
		      | shippingzipcode         | @testdata.shippingaddress.basicaddress.zipPostCode            |
		      | shippingcountrycode     | @testdata.shippingaddress.basicaddress.countryCode            |
		      | shippingcountryareacode | @testdata.shippingaddress.basicaddress.areaCode               |
		      | shippingphone           | @testdata.shippingaddress.basicaddress.phoneNumber            |
		      | shippingExtension       | @testdata.shippingaddress.basicaddress.extension              |
		 And I Select Shipping Method:
		      | shippingdetails | @testdata.shippingaddress.shippingdetails.shippingMethod              |
		 And I Input Payment Information:
		      | accountpayment | @testdata.shippingaddress.paymentbillingaddress.accountpaymentPOnumber |
		 Then Navigate to Final Review and Accept Terms and Condition
		 Then Click on Place Order Button
	   When I Navigate to Order History Page 
		 And Verify Sort with Date in Order History Table
		 Then Verify CSC Text in Order History
	