Feature: Regression Header Functionality

  Background: 
    Given Navigate to BGS Application
 
 	@Regression 
 	 Scenario: QA-BM-321_Verify the navigation from the GNB
	 When Verify GNB Tabs Which Visible Primary Categories
		 Then Hover the GNB
		 And Retrieve Price of Product in PLP
		 Then I Click on First Product in PLP
		  And Verify Price of Product in PDP
							
	@Regression 
 	Scenario: QA-BM-322_Verify the Breadcrumb format
	 Then Hover the GNB
		 Then Verify all Links Clickable Except Current Page in GNB
		 And Verify Links Navigation in Breadcrumb
		 Then Hover the GNB
	   Then I Click on First Product in PLP
	   Then 'PDP' Page is Opened