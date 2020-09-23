Feature: User Registration Functionality

  Background: 
    Given Navigate to BGS Application

  @Regression @Smoke
  Scenario: TC-21_Verify the Registration process with New Company Account
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

  @Regression @Smoke
  Scenario: TC-22_Verify the Registration process with New Personal Account
    When I Click on Register Link
    When Select the Exisitng User as No
    When Select Personal Account
    And Input Account Details for New Personal Account:
      | newPerRegion   | @testdata.registration.personalregister.personalRegion            |
      | perName        | @testdata.registration.personalregister.personalname              |
      | perLast        | @testdata.registration.personalregister.personalLastName          |
      | perCountrycode | @testdata.registration.personalregister.personalCountryCode       |
      | perAreaCode    | @testdata.registration.personalregister.personalAreaCode          |
      | perPhoneNumb   | @testdata.registration.personalregister.personalPhoneNumber       |
      | perExtension   | @testdata.registration.personalregister.personalExtension         |
      | perEmailID     | @testdata.registration.PersonalloginInformation.emailAddress      |
      | perPassword    | @testdata.registration.PersonalloginInformation.Password          |
      | conPassword    | @testdata.registration.PersonalloginInformation.confimredPassword |
    Then 'HOME' Page is Opened
    And I Click on LogOut
    Then 'LOGIN' Page is Opened

  @Regression @Smoke
  Scenario: TC-23_Verify the Registration process with Existing Company account
    When I Click on Register Link
    When Select the Exisitng User as Yes
    When Select Company Account
    And Input Account Details of Company User:
      | comAccount     | @testdata.registration.companyregister.createCompanyAccountURL   |
      | comRegion      | @testdata.registration.companyregister.companyRegion             |
      | comName        | @testdata.registration.companyregister.companyname               |
      | comPostalCode  | @testdata.registration.companyregister.companyPostalCode         |
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

  @Regression @Smoke
  Scenario: TC-24_Verify the Registration process with Existing Personal Account
    When I Click on Register Link
    When Select the Exisitng User as Yes
    When Select Personal Account
    And Input Account Details for Existing Personal Account:
      | perAccount     | @testdata.registration.personalregister.createPersonalAccountURL  |
      | perRegion      | @testdata.registration.personalregister.personalRegion            |
      | perName        | @testdata.registration.personalregister.personalname              |
      | perLast        | @testdata.registration.personalregister.personalLastName          |
      | perCountrycode | @testdata.registration.personalregister.personalCountryCode       |
      | perAreaCode    | @testdata.registration.personalregister.personalAreaCode          |
      | perPhoneNumb   | @testdata.registration.personalregister.personalPhoneNumber       |
      | perExtension   | @testdata.registration.personalregister.personalExtension         |
      | perEmailID     | @testdata.registration.PersonalloginInformation.emailAddress      |
      | perPassword    | @testdata.registration.PersonalloginInformation.Password          |
      | conPassword    | @testdata.registration.PersonalloginInformation.confimredPassword |
    Then 'HOME' Page is Opened
    And I Click on LogOut
    Then 'LOGIN' Page is Opened
 
 @Regression
 Scenario: ALM ID 14710 QA-BM-83_Verify if the user is an existing customer
  When I Click on Register Link
 		And Registration Page is Displayed
 		And Verify Progress Bar has the Below Items:
       	| Register account     |
       	| Account details      |
       	| Login information    | 	
    And Verify for Existing Customer Options			

  @Regression
  Scenario: ALM ID 14612 QA-BM-1_Verify if the user is able to navigate to the registration page when the user clicks on the URL
    When I Click on Register Link
    And Registration Page is Displayed

  @Regression
  Scenario: ALM ID 14626 QA-BM-458_Verify the country selection in the registration 
    When I Click on Register Link
    When Select the Exisitng User as No
    When Select Personal Account
    And Input Account Details for New Personal Account:
      | newPerRegion   | @testdata.registration.personalregister.personalRegion      |
      | perName        | @testdata.registration.personalregister.personalname        |
      | perLast        | @testdata.registration.personalregister.personalLastName    |
      | perCountrycode | @testdata.registration.personalregister.personalCountryCode |
      | perAreaCode    | @testdata.registration.personalregister.personalAreaCode    |