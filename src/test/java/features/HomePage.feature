Feature: Home Page Functionality

  Background: 
    Given Navigate to BGS Application
    
  @Regression    
  Scenario: QA-BM-TC248 Verify the links available in the page
   When I Click on Login
	   And I Login to BGS Application Using Below Credentials:
	      | username | @testdata.login.validuser.username |
	      | password | @testdata.login.validuser.password |
     Then 'HOME' Page is Opened  
     And Verify the Contents in the Footer    	 