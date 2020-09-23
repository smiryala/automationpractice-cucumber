package com.bgs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Registration {
	WebDriver driver;

	public Registration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*	Register link*/
	@FindBy(how = How.XPATH, using = "//li[@class='visible-sm visible-md visible-lg login-options']//a[contains(text(),'Register')]")
	private WebElement registerLink;

	public WebElement getregisterLink() {
		return registerLink;
	}
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Register account')]")
	private WebElement registrationPage;

	public WebElement getRegistrationPage() {
		return registrationPage;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='existing_account']")
	private WebElement existingcustomer;

	public WebElement getregisterAccountYes() {
		return existingcustomer;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='new_account']")
	private WebElement newCustomer;

	public WebElement getNewCustomer() {
		return newCustomer;
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id='account_type2']")
	private WebElement newPersonalAccount;

	public WebElement getNewPersonalAccount() {
		return newPersonalAccount;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='account_type1']")
	private WebElement newCompanyAccount;

	public WebElement getNewCompanyAccount() {
		return newCompanyAccount;
	}


	@FindBy(how = How.XPATH, using = "//button[@class='next button-primary mobile-full-width']")
	private WebElement getregisterAccountNext;

	public WebElement getregisterAccountNext() {
		return getregisterAccountNext;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='account_type1']")
	private WebElement companyAccountradiobutton;

	public WebElement getCompanyAccountradio() {
		return companyAccountradiobutton;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='account_type2']")
	private WebElement personalAccountradiobutton;

	public WebElement getPersonalAccountradiobutton() {
		return personalAccountradiobutton;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='existing_personal_account_number']")
	private WebElement personalAccountNum;

	public WebElement getPersonalAccountNum() {
		return personalAccountNum;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='existing_personal_region']")
	private WebElement personalRegion;

	public WebElement getPersonalRegion() {
		return personalRegion;
	}
	@FindBy(how = How.XPATH, using = "//select[@id='new_personal_region']")
	private WebElement newPersonalRegion;

	public WebElement getNewPersonalRegion() {
		return newPersonalRegion;
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id='existing_personal_first_name']")
	private WebElement personalName;

	public WebElement getPersonalName() {
		return personalName;
	}
	
	@FindBy(how = How.XPATH, using = "")
	private WebElement personalPostalCode;

	public WebElement getPersonalPostalCode() {
		return personalPostalCode;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='country_code']")
	private WebElement personalCountryCode;

	public WebElement getPersonalCountryCode() {
		return personalCountryCode;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='area_code']")
	private WebElement personalAreaCode;

	public WebElement getPersonalAreaCode() {
		return personalAreaCode;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='existing_personal_last_name']")
	private WebElement personalLastName;

	public WebElement getPersonalLastName() {
		return personalLastName;
	}

	

	@FindBy(how = How.XPATH, using = "//input[@id='first_three_digits']")
	private WebElement personalPhoneNumber;

	public WebElement getPersonalPhoneNumber() {
		return personalPhoneNumber;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='last_four_digits']")
	private WebElement personalExtension;

	public WebElement getPersonalExtension() {
		return personalExtension;
	}

	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Retrieve account')]")
	private WebElement personalRetrieve;

	public WebElement getPersonalRetrieve() {
		return personalRetrieve;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='company_account_number']")
	private WebElement companyAccountNum;

	public WebElement getcompanyAccountNum() {
		return companyAccountNum;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='existing_company_region']")
	private WebElement companyRegion;

	public WebElement getcompanyRegion() {
		return companyRegion;
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='new-company_region']")
	private WebElement newCompanyRegion;

	public WebElement getNewCompanyRegion() {
		return newCompanyRegion;
	}

		
	@FindBy(how = How.XPATH, using = "//input[@id='existing_company_name']")
	private WebElement companyName;

	public WebElement getcompanyName() {
		return companyName;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='existing_company_postal_code']")
	private WebElement companyPostalCode;

	public WebElement getcompanyPostalCode() {
		return companyPostalCode;
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='country_code'])[2]")
	private WebElement companyCountryCode;

	public WebElement getcompanyCountryCode() {
		return companyCountryCode;
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='area_code'])[2]")
	private WebElement companyAreaCode;

	public WebElement getcompanyAreaCode() {
		return companyAreaCode;
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='first_three_digits'])[2]")
	private WebElement companyPhoneNumber;

	public WebElement getcompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='last_four_digits'])[2]")
	private WebElement companyExtension;

	public WebElement getcompanyExtension() {
		return companyExtension;
	}

	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Retrieve account')])[2]")
	private WebElement companyRetrieveAccount;

	public WebElement getcompanyRetrieveAccount() {
		return companyRetrieveAccount;

	}
	/*Login information  email and password */

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	private WebElement companyEmailAddress;

	public WebElement getcompanyEmailAddress() {
		return companyEmailAddress;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement companyPassword;

	public WebElement getcompanyPassword() {
		return companyPassword;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='confirm_password']")
	private WebElement companyConfirmedPassword;

	public WebElement getcompanyConfirmedPassword() {
		return companyConfirmedPassword;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='checkmark stay']")
	private WebElement companyTermAgreeCheckbox;

	public WebElement getcompanyTermAgreeCheckbox() {
		return companyTermAgreeCheckbox;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Register')]")
	private WebElement companyRegisterbutton;

	public WebElement getcompanyRegisterbutton() {
		return companyRegisterbutton;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-info alert-dismissable getAccAlert']")
	private WebElement newCompanyRegistrationConfirm;

	public WebElement getnewCompanyRegistrationConfirm() {
		return newCompanyRegistrationConfirm;
	}
	
	
	@FindBy(how = How.XPATH, using = "//ol[@class='progressbar']")
	private WebElement progressbar;

	public WebElement getProgressbar() {
		return progressbar;
	}
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Are you an existing customer?')]")
	private WebElement existingcustomertext;

	public WebElement getExistingCustomerText() {
		return existingcustomertext;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='new_or_existing']")
	private WebElement existingcustomeropt;

	public WebElement getExistingCustomerOptions() {
		return existingcustomeropt;
	}
}


