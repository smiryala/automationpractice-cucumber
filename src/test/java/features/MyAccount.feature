Feature: MyAccount Page Functionality

  Background: 
    Given Navigate to BGS Application

  @Regression 
  Scenario: QA-BM-TC322 Verify Breadcrumb in My Account
  When I Click on Login
   	 And I Login to BGS Application Using Below Credentials:
	      | username | @testdata.login.validuser.username |
	      | password | @testdata.login.validuser.password |
	    Then 'HOME' Page is Opened
	    And Navigate to MyProfile
	    Then Verify the Breadcrumb is Visbile

 
  Scenario: BM-419_Verify the Change Email Address in the User Profile with invalid inputs
  When I Click on Login
	  Then Verify the Change Email address in the User Profile with Invalid inputs
	    | password | @testdata.login.validuser.password |

 @Regression
	Scenario: QA-BM-93_Verify user able to navigate to Account details page
 When I Click on Login
  And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.company |
      | password | @testdata.login.validuser.password |
  Then 'HOME' Page is Opened
  Then Click on My Account
  And Verify Following Fields are Displaying in Account Details Section:
      | CompanyName                   |
      | AccountNumber                 |
      | CountryCode                   |
      | Areacode                      |
      | PhoneNumber                   |
      | Extension                     |
      | CANCEL                        |
      | SAVE                          |

  @Regression
	Scenario: QA-BM-93_Verify user able to navigate to Aircraft details page
 When I Click on Login
  And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
  Then 'HOME' Page is Opened
   Then Click on My Account and Select New Aircraft
   And Verify Following Fields are Displaying in Aircraft Details Section:
      | AircraftTailNumber            |
      | AircraftMake                  |
      | AircraftModel                 |
      | AircraftSerialNumber          |
      | AircraftYear                  |
      | TermAndConditionOfPurchase    |
      | CANCEL                        |
      | SAVE                          |
      
  @Regression
	Scenario: QA-BM-93_Verify user able to navigate to Change email page
 When I Click on Login
  And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
  Then 'HOME' Page is Opened
  Then Click on My Account
  And Verify Following Fields are Displaying in Change Email Address Section:
      | CurrentEmail                    |
      | NewEmail                        |
      | ConfirmYourEmailAddress         |
      | Password                        |
      | CANCEL                          |
      | SAVE                            |
   
   @Regression 
	Scenario: QA-BM-93_Verify user able to navigate to Change email page
 When I Click on Login
  And I Login to BGS Application Using Below Credentials:
      | username | @testdata.login.validuser.username |
      | password | @testdata.login.validuser.password |
  Then 'HOME' Page is Opened
  Then Click on My Account
  And Verify Following Fields are Displaying in Change Password Section:
      | CurrentPassword                 |
      | NewPassword                     |
      | ConfirmNewPassword              |
      | CANCEL                          |
      | SAVE                            |
  