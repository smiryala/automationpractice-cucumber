package com.bgs.stepDefs;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.bgs.pageObjects.LoginPage;
import com.framework.library.GlobalVariables;
import com.framework.library.Hooks;

import com.framework.utility.CommonFunctions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class LoginSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	LoginPage login = new LoginPage(driver);


	@And("^I Login to BGS Application Using Below Credentials:$")
	public void i_login_to_bgs_application_username_password(DataTable dt) throws Throwable {
		readData(dt);
		try {
			input(login.getUserName(),testdata.get("username"),"user name");
			input(login.getPassword(),testdata.get("password"),"password");
			click(login.getTermsCheckbox(),"Terms CheckBox");
//			implicitWait(driver,4);
			click(login.getLogIn(),"Login");
		} catch (Exception e) {
			Assert.fail("Login failed");
		}
	}

	@Then("^Following Error Message Should be Displayed:$")
	public void error_displayed(DataTable dt) {
		readData(dt);
		if (!login.getLoginError().getText().contains(testdata.get("errormsg")))
			soft.fail("Error message is not displayed as expected");
	}

}

