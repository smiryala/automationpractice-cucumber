package com.bgs.stepDefs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.ls.LSInput;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.bgs.pageObjects.HomePage;
import com.bgs.pageObjects.Registration;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps extends CommonFunctions {

	WebDriver driver = Hooks.getDriver();
	Registration reg = new Registration(driver);
	public static String countryCode = null;

	@When("^I Click on Register Link$")
	public void RegisterLink() throws Throwable {
		try {
			click(reg.getregisterLink(), "Registration link");
		} catch (Exception e) {
			Assert.fail("Register link not available");
		}
	}

	@When("^Select the Exisitng User as Yes$")
	public void ExistingUser() {
		try {
			click(reg.getregisterAccountYes(), "existing account");
			click(reg.getregisterAccountNext(), "Next Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^Select the Exisitng User as No$")
	public void NewUser() {
		try {
			click(reg.getNewCustomer(), "New customer");
			click(reg.getregisterAccountNext(), "Next Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^Select Personal Account$")
	public void PExisitingUser() {
		try {
			click(reg.getPersonalAccountradiobutton(), "Personal account radio button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^Select Company Account$")
	public void CExisitingUser() {
		try {

			click(reg.getCompanyAccountradio(), "Company account radio button");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^Input Account Details for Existing Personal Account:$")
	public void PersonalUser(DataTable dt) throws Exception {
		// List<String> data = captureAccountNums();
		readData(dt);
		Double accountNum = getAccountThroughAPI("PERSONAL");
		String account = accountNum.toString();
		String acc = account.substring(0, 7);
		try {

			click(reg.getPersonalAccountNum(), "Account Number");

			input(reg.getPersonalAccountNum(), acc, "personal Account Number");
			scrollIntoView(reg.getPersonalRegion());
			selectValue(reg.getPersonalRegion(), "VISIBLETEXT", testdata.get("perRegion"));

			input(reg.getPersonalName(), testdata.get("perName"), "First Name");
			input(reg.getPersonalLastName(), testdata.get("perLast"), "Last Name");
			input(reg.getPersonalCountryCode(), testdata.get("perCountrycode"), "Personal Country code");
			input(reg.getPersonalAreaCode(), testdata.get("perAreaCode"), "Personal Area Code");
			scrollIntoView(reg.getPersonalPhoneNumber());
			input(reg.getPersonalPhoneNumber(), testdata.get("perPhoneNumb"), "Phone Number");
			input(reg.getPersonalExtension(), testdata.get("perExtension"), "Personal Extension");
			click(reg.getPersonalRetrieve(), "Retrieve Account Button");
			String randomemail = getRandomEmail("7");
			envVariable.put("email",randomemail);
			input(reg.getcompanyEmailAddress(), randomemail, "Company Email Address");
			input(reg.getcompanyPassword(), testdata.get("perPassword"), "Company Password");
			input(reg.getcompanyConfirmedPassword(), testdata.get("conPassword"), "Confirmed Password");
			click(reg.getcompanyTermAgreeCheckbox(), "Term and Agree check box");
			click(reg.getcompanyRegisterbutton(), "Register button");
			// if (true) {
			// System.out.println(data.get(i)+ "is Already exist.");

			// }
			// }

			implicitWait(driver, 4);
		} catch (Exception e) {
			Assert.fail("Account Details not available");
		}
	}

	@And("^Input Account Details for New Personal Account:$")
	public void NewPersonalUser(DataTable dt) throws Exception {


		try {
			readData(dt);

			selectValue(reg.getNewPersonalRegion(), "VISIBLETEXT", testdata.get("newPerRegion"));

			input(reg.getPersonalName(), testdata.get("perName"), "First Name");
			input(reg.getPersonalLastName(), testdata.get("perLast"), "Last Name");
			input(reg.getPersonalCountryCode(), testdata.get("perCountrycode"), "Personal Country code");
			countryCode = testdata.get("perCountrycode");
			input(reg.getPersonalAreaCode(), testdata.get("perAreaCode"), "Personal Area Code");
			scrollIntoView(reg.getPersonalPhoneNumber());
			input(reg.getPersonalPhoneNumber(), testdata.get("perPhoneNumb"), "Phone Number");
			input(reg.getPersonalExtension(), testdata.get("perExtension"), "Personal Extension");
			click(reg.getPersonalRetrieve(), "Retrieve Account Button");
			String randomemail = getRandomEmail("7");
			System.out.println("Email is: " + randomemail);
			envVariable.put("email",randomemail);
			input(reg.getcompanyEmailAddress(), randomemail, "Company Email Address");
			input(reg.getcompanyPassword(), testdata.get("perPassword"), "Company Password");
			input(reg.getcompanyConfirmedPassword(), testdata.get("conPassword"), "Confirmed Password");
			click(reg.getcompanyTermAgreeCheckbox(), "Term and Agree check box");
			click(reg.getcompanyRegisterbutton(), "Register button");

			implicitWait(driver, 4);
		} catch (Exception e) {
			Assert.fail("Account Details not available");
		}
	}

	@Then("^Input Login Information of exisitng personal Email Id and Password:$")
	public void EPLoginInformation(DataTable dt) {
		try {
			readData(dt);
			String randomemail = getRandomEmail("7");
			input(reg.getcompanyEmailAddress(), randomemail, "Company Email Address");
			input(reg.getcompanyPassword(), testdata.get("comPassword"), "Company Password");
			input(reg.getcompanyConfirmedPassword(), testdata.get("comPassword"), "Confirmed Password");
			click(reg.getcompanyTermAgreeCheckbox(), "Term and Agree check box");
			click(reg.getcompanyRegisterbutton(), "Register button");

		} catch (Exception e) {
			Assert.fail("Email id and Password not Enter");
		}

	}

	@And("^Input Account Details of Company User:$")
	public void CompanyUser(DataTable dt) {
		try {
			readData(dt);
			Double accountNum = getAccountThroughAPI("COMPANY");
			String account = accountNum.toString();
			String acc = account.substring(0, 7);

			click(reg.getcompanyAccountNum(), "Account Number");
			input(reg.getcompanyAccountNum(), acc, "Company Account Number");
			selectValue(reg.getcompanyRegion(), "VISIBLETEXT", testdata.get("comRegion"));
			input(reg.getcompanyName(), testdata.get("comName"), "Company Company Name");
			input(reg.getcompanyPostalCode(), testdata.get("comPostalCode"), "Postal code");
			input(reg.getcompanyCountryCode(), testdata.get("comCountrycode"), "Company Country code");
			input(reg.getcompanyAreaCode(), testdata.get("comAreaCode"), "Company Area Code");
			input(reg.getcompanyPhoneNumber(), testdata.get("comPhoneNumb"), "Phone Number");
			input(reg.getcompanyExtension(), testdata.get("comExtension"), "Company Extension");
			click(reg.getcompanyRetrieveAccount(), "Retrieve Account Button");
			String randomemail = getRandomEmail("7");
			envVariable.put("email",randomemail);
			input(reg.getcompanyEmailAddress(), randomemail, "Company Email Address");
			input(reg.getcompanyPassword(), testdata.get("comPassword"), "Company Password");
			input(reg.getcompanyConfirmedPassword(), testdata.get("conPassword"), "Confirmed Password");
			click(reg.getcompanyTermAgreeCheckbox(), "Term and Agree check box");
			click(reg.getcompanyRegisterbutton(), "Register button");

			implicitWait(driver, 4);
		} catch (Exception e) {
			Assert.fail("Account Details not available");
		}
	}

	@And("^Input Account Details for New Company Account:$")
	public void NewCompanyUser(DataTable dt) {
		try {
			readData(dt);
			selectValue(reg.getNewCompanyRegion(), "VISIBLETEXT", testdata.get("newcomRegion"));
			input(reg.getcompanyName(), testdata.get("comName"), "Company Company Name");

			input(reg.getcompanyCountryCode(), testdata.get("comCountrycode"), "Company Country code");
			input(reg.getcompanyAreaCode(), testdata.get("comAreaCode"), "Company Area Code");
			input(reg.getcompanyPhoneNumber(), testdata.get("comPhoneNumb"), "Phone Number");
			input(reg.getcompanyExtension(), testdata.get("comExtension"), "Company Extension");
			click(reg.getcompanyRetrieveAccount(), "Retrieve Account Button");
			String randomemail = getRandomEmail("7");
			envVariable.put("email",randomemail);
			input(reg.getcompanyEmailAddress(), randomemail, "Company Email Address");
			input(reg.getcompanyPassword(), testdata.get("comPassword"), "Company Password");
			input(reg.getcompanyConfirmedPassword(), testdata.get("conPassword"), "Confirmed Password");
			click(reg.getcompanyTermAgreeCheckbox(), "Term and Agree check box");
			click(reg.getcompanyRegisterbutton(), "Register button");

			implicitWait(driver, 4);
		} catch (Exception e) {
			Assert.fail("Account Details not available");
		}
	}

	@Then("^Input Login Information of exisitng company Email Id and Password:$")
	public void ECLoginInformation(DataTable dt) {
		try {
			readData(dt);
			String randomemail = getRandomEmail("7");
			input(reg.getcompanyEmailAddress(), randomemail, "Company Email Address");
			input(reg.getcompanyPassword(), testdata.get("comPassword"), "Company Password");
			input(reg.getcompanyConfirmedPassword(), testdata.get("comPassword"), "Confirmed Password");
			click(reg.getcompanyTermAgreeCheckbox(), "Term and Agree check box");
			click(reg.getcompanyRegisterbutton(), "Register button");

		} catch (Exception e) {
			Assert.fail("Email id and Password not Enter");
		}

	}


	@And("^Registration Page is Displayed$")
	public void RegistrationPage() {
		try {
			isElementPresent(reg.getRegistrationPage(),"Registration Page");
		}catch(Exception e) {
			e.printStackTrace();
		}		 
	}

	@And("^Verify Progress Bar has the Below Items:$")
	public void Registartion_progress_bar(DataTable dt) {

		try {
			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				String string = list.get(i).get(0).trim();
				if(!reg.getProgressbar().getText().contains(string)) {
					soft.fail(string + " not present in progress bar");
				}
			}

			//div[@id='new_or_existing']
			isElementPresent(reg.getExistingCustomerText(), "are you an existing customer?");
		}catch(Exception e) {
			e.printStackTrace();
		}		 
	}

	@And("^Verify for Existing Customer Options$")
	public void Registartion_existing_customer() {

		try {
			isElementPresent(reg.getExistingCustomerOptions(), "Existing customer Yes or No");
			isElementPresent(reg.getExistingCustomerText(), "are you an existing customer?");
		}catch(Exception e) {
			e.printStackTrace();
		}		 
	}


}
