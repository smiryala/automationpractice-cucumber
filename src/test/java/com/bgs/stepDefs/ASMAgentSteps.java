package com.bgs.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import com.bgs.pageObjects.LoginPage;
import com.bgs.pageObjects.MyAccount;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ASMAgentSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	LoginPage login = new LoginPage(driver);

	
@When("^Navigate to BGS Application Using ASM Agent$")
public void i_login_to_bgs_application_username_password_for_ASM_Agent() throws Throwable {
	try {	
		String asmURL = driver.getCurrentUrl().toString() + "?asm=true";
		driver.navigate().to(asmURL);
		waitForJStoLoad();
		if(!login.getASMLoginUserID().isDisplayed())
			Assert.fail("Not able to navigate to BGS application using ASM Agent");
	} catch (Exception e) {
		Assert.fail("Failed to navigate to asm URL");
	}
}


@And("^I Login to BGS ASM Application Using Below Credentials:$")
public void i_login_to_bgs_application_username_password(DataTable dt) throws Throwable {
	readData(dt);
	try {
		isElementPresent(login.getASMLogo(),"Heading Logo");
		isElementPresent(login.getASMLoginUserID(),"User ID");
		isElementPresent(login.getASMPassword(),"Password");
		isElementPresent(login.getASMSignIn(),"Sign In");
		input(login.getASMLoginUserID(),testdata.get("username"),"user name");
		input(login.getASMPassword(),testdata.get("password"),"password");
		click(login.getASMSignIn(),"Sign In");	
		implicitWait(driver,6);	
		click(login.getASMCustomerNameEmailID(),"customer name /Email ID");
		input(login.getASMCustomerNameEmailID(),testdata.get("customername"),"Customer Name/ Email ID");
		explicitWait(login.getASMStartSession());
		click(login.getASMStartSession(),"Start Session");
		implicitWait(driver,5);
	} catch (Exception e) {
		Assert.fail("ASM Login failed");
	}
}

}