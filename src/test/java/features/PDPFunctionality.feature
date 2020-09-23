Feature: Regression PDP Functionality

  Background: 
    Given Navigate to BGS Application
    
 @Regression 
  Scenario: QA-BM-TC315 Verify the product price as an authentic user
  When I Click on Login
	  And I Login to BGS Application Using Below Credentials:
			      | username | @testdata.login.validuser.username |
			      | password | @testdata.login.validuser.password |
		Then Hover the GNB
	  And Retrieve Price of Product in PLP
		Then I Click on First Product in PLP
		And Verify Price of Product in PDP
		Then 'PDP' Page is Opened
			      
 @Regression 
  Scenario: QA-BM-TC315_Verify the product prices as unauthentic user
	Then Hover the GNB 
		And Retrieve Price of Product in PLP
		And Verify if USD Available Add to Cart Should Displayed in PLP
		Then I Click on First Product in PLP
	  And Verify if USD Available Add to Cart Should Displayed in PDP
		And Verify Price of Product in PDP
		Then 'PDP' Page is Opened	       
	 
 @Regression
  Scenario: QA-BM-270_Verify the Capacity of Cart
	When I Click on Login
    And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
    Then 'HOME' Page is Opened
    When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.simpleProduct |
    Then 'PLP' Page is Opened
    And I Click on First Product in PLP
    Then Verify Able to Add Min and Max in PDP
        Then I Click on Add To Cart in PDP
    Then 'Added To Cart' PopUp is Opened
    Then Click on CheckOut in PopUp
    Then Verify Able to Add Min and Max in PLP
                   
	 @Regression
 	 Scenario: QA-BM-278_Verify system should not display inventory product amount number.
  
   When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
   Then 'PLP' Page is Opened
   Then Verify for Available Products Text
    And I Click on First Product in PLP
   Then 'PDP' Page is Opened    
	 Then Verify for Available Products Text  

	 @Regression
	Scenario: Test ID :14644 QA-BM-757_Verify Price display for unauthenticated users 

   When I Search for the Product:
      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
   Then 'PLP' Page is Opened
    And I Click on First Product in PLP
   Then 'PDP' Page is Opened
   Then Verify PDP Page for NonConfigurable Products
   Then Verify Price of Product in PDP

 @Regression
Scenario: ALM ID14627 QA-BM-276_Verify product description and attributes displayed on the PDP. 
 
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