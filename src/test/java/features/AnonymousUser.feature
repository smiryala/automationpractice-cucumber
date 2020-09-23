Feature: Anonymous User Functionality

  Background: 
    Given Navigate to BGS Application

 
@Regression @Smoke
 Scenario: TC-05_Verify if search yields the expected products list- Anonymous
 
   When I Search for the Product:
	      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
	   Then 'PLP' Page is Opened
	    And Verify Result Matches with Actual Value
	      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |


@Regression @Smoke
Scenario: TC-07_Verify the display of all the components in the homepage

   Then User Should be Able to View the Below Components in Home Page:
       	| CompanyLogo            |
       	| CartIcon               |
       	| GlobalNavigationBar    |
       	| HeroBanner             |
       	| MainCategory           |
       	| RecommendedProducts  	 |
       	| PopularProducts      	 |
       	| ShopCategory         	 |
       	| FamilyBrands         	 |


@Regression @Smoke
Scenario: TC-09_Verify PLP is visible properly 10 Products per page

   When I Search for the Product:
	      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
	   Then 'PLP' Page is Opened
	    And Verify Result Matches with Actual Value
	      | searchProduct | @testdata.search.simpleProduct.hardgoodProduct |
	    And User Able to View the Products Related to Searched Keyword


@Regression @Smoke @Tester
Scenario: TC-11_Verify PDP is visible properly

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