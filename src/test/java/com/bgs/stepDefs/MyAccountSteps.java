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

public class MyAccountSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	MyAccount acct = new MyAccount(driver);

	@Then("^Click on My Account and Select New Aircraft$")
	public void click_myaccount() throws Throwable {
		try {
			click(acct.getwelcomeDropdown(), "Welcome dropdown");
			click(acct.getmyAccount(), "My Account");
			implicitWait(driver, 10);
			click(acct.getAircrafttDetails(), " Aircraft Details");
			click(acct.getaddNewAircraft(), " Add New Aircraft");
			implicitWait(driver, 10);
		} catch (Exception e) {
			Assert.fail("My Account not available");
		}
	}

	@When("^Input all Aircraft Details:$")
	public void Inputaircraftinfo(DataTable dt) throws Throwable {
		readData(dt);
		try {
			input(acct.getaircraftTailNo(),Integer.toString(getRandomInt(7)),"Random Tail Number");
			/*	input(acct.getaircraftTailNo(), testdata.get("crafttailno"), "AircraftTail Number");*/
			implicitWait(driver,10);
			selectValue(acct.getaircraftMake(),"VISIBLETEXT", testdata.get("craftmanufact"));
			implicitWait(driver,10);

			click(acct.getaircraftModel(), "Get Aircraft Model ");
			/*
			 * selectValue(home.getaircraftModel(),"VISIBLETEXT",
			 * testdata.get("craftmodel"));
			 */
			input(acct.getaircraftserialno(), testdata.get("craftserialno"), "Craft Serial No");
			input(acct.getaircraftYear(), testdata.get("craftYear"), "Craft Year");

		} catch (Exception e) {
			Assert.fail("Aircarft info not able to enter");
		}

	}

	@Then("^Check Purchase Term and Condition and Save$")
	public void Checktermcondition() throws Throwable {
		try {
			click(acct.getPurchaseTermcheckbox(), "Purchase term and condition ");
			implicitWait(driver, 10);
			click(acct.getAircraftDetailsSave(), "Air craft details saved");

		} catch (Exception e) {
			Assert.fail("Term and conditon purchase check box not available");
		}
	}

	@Then("^Verify the Change Email address in the User Profile with Invalid inputs$")
	public void emailValidation(DataTable dt) throws Throwable {
		readData(dt);
		LoginPage login = new LoginPage(driver);
		String newemailID = null;
		String tempEmailID = null;
		try {
			String userName = emailIDReader();
			//input(login.getUserName(),testdata.get("username"),"user name");
			input(login.getUserName(),userName+"@aviall.com","email ID");
			input(login.getPassword(),testdata.get("password"),"password");
			click(login.getTermsCheckbox(),"Terms CheckBox");
			implicitWait(driver,4);
			click(login.getLogIn(),"Login");
			waitForJStoLoad();
			click(acct.getwelcomeDropdown(), "Welcome dropdown");
			click(acct.getmyAccount(), "My Account");
			implicitWait(driver, 10);
			// Missing input
			input(acct.getNewEmail(), userName+"@aviall.com", "new email id");
			click(acct.getChangeEmail(), "Change Email");
			click(acct.getNewEmail(), "new email");
			input(acct.getNewEmail(), testdata.get("username"), "new email id");
			click(acct.getConfirmEmail(), "confirm Email" );
			acct.getConfirmEmail().clear();
			click(acct.getPassword(), "password");
			input(acct.getPassword(), testdata.get("password"), "New password");
			click(acct.getSavebutton(), "saves");
			if((acct.getConfirmEmailError().isDisplayed())&&(acct.getGlobalError().isDisplayed())) {
				acct.getNewEmail().clear();
				input(acct.getConfirmEmail(), testdata.get("username"), "Confirm email id");
				click(acct.getPassword(), "password");
				input(acct.getPassword(), testdata.get("password"), "New password");
				click(acct.getSavebutton(), "saves");
				if((acct.getNewEmailError().isDisplayed())&&(acct.getGlobalError().isDisplayed())) {
				}
			}
			acct.getConfirmEmail().clear();
			input(acct.getPassword(), testdata.get("password"), "New password");
			click(acct.getSavebutton(), "saves");
			if ((acct.getConfirmEmailError().isDisplayed()) && (acct.getGlobalError().isDisplayed())) {
				acct.getNewEmail().clear();
				input(acct.getConfirmEmail(),userName+"@aviall.com", "Confirm email id");
				input(acct.getPassword(), testdata.get("password"), "New password");
				click(acct.getSavebutton(), "saves");
				if ((acct.getNewEmailError().isDisplayed()) && (acct.getGlobalError().isDisplayed())) {

				}
				// Invalid data
				input(acct.getNewEmail(), "change", "new email id");
				input(acct.getConfirmEmail(), userName+"@aviall.com", "Confirm email id");
				input(acct.getPassword(), testdata.get("password"), "New password");
				click(acct.getSavebutton(), "saves");
				if ((acct.getNewEmailError().isDisplayed()) && (acct.getGlobalError().isDisplayed())) {
					input(acct.getNewEmail(), userName+"@aviall.com", "new email id");
					input(acct.getConfirmEmail(),"change", "Confirm email id");
					input(acct.getPassword(), testdata.get("password"), "New password");
					click(acct.getSavebutton(), "saves");
					if ((acct.getNewEmailError().isDisplayed()) && (acct.getGlobalError().isDisplayed())) {
					}
					//Valid data
					String timeStamp = new SimpleDateFormat("ss").format(new Date()).replace(".", "").replaceAll("\\s", "");
					tempEmailID=userName.replaceAll("[0-9]", "");
					newemailID = tempEmailID+timeStamp;
					input(acct.getNewEmail(), newemailID+"@aviall.com", "new email id");
					input(acct.getConfirmEmail(),newemailID+"@aviall.com", "Confirm email id");
					input(acct.getPassword(), testdata.get("password"), "New password");
					click(acct.getSavebutton(), "saves");
					if(acct.getChangeEmailMsg().isDisplayed()) {
						emailIDWriter(newemailID);
					}
				}

				//	StringUtils.concatenate(")
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Click on Order History$")
	public void click_order_history() throws Throwable {
		try {
			click(acct.getOrderHistory(), "Order History");
			implicitWait(driver, 10);
		} catch (Exception e) {
			Assert.fail("Term and conditon purchase check box not available");
		}
	}

	@And("^Verify Sort with Date in Order History Table$")
	public void verify_order_history_sort_date() throws Throwable {
		try {
			selectValue(acct.getSortOrderHistory(), "VALUE", "byDate");
			implicitWait(driver, 10);
			List<WebElement> allItem = acct.getDatePlacedList();
			// SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-DD HH:mm");

			for (int i = 0; i < allItem.size(); i++) {

				// Date next = f.parse(allItem.get(i).getText());
				String next = allItem.get(i).getText();
				String prev = null;
				if (prev != null && (prev.compareTo(next) > 0)) {
					soft.fail("Dates are not in Sorted Order");
				}
				prev = next;
			}
		} catch (Exception e) {
			Assert.fail("Issue in Order History");
		}
	}

	@And("^Verify Sort with Order Number in Order History Table$")
	public void verify_order_history_sort_ordernum() throws Throwable {
		try {
			selectValue(acct.getSortOrderHistory(), "VALUE", "byOrderNumber");
			implicitWait(driver, 10);
			List<WebElement> allItem = acct.getOrderNumberList();

			for (int i = 0; i < allItem.size(); i++) {
				String next = allItem.get(i).getText();
				String prev = null;
				if (prev != null && (prev.compareTo(next) > 0)) {
					soft.fail("Order Numbers are not in Sorted Order");
				}
				prev = next;
			}
		} catch (Exception e) {
			Assert.fail("Issue in Order History");
		}
	}

	@When("^I Navigate to Order History Page$")
	public void verify_orderhistory_page() throws Throwable {
		try {
			click(acct.getwelcomeDropdown(), "Welcome dropdown");
			click(acct.getmyAccount(), "My Account");
			waitForJStoLoad();
			click(acct.getOrderHistory(), "Order History");
			implicitWait(driver, 10);

		} catch (Exception e) {
			Assert.fail("Not able to Navigate to Order Hsitory Page");
		}
	}

	@Then("^Verify Order History Table Headers:$")
	public void verify_orderhistory_table_headers(DataTable dt) throws Throwable {
		try {
			List<WebElement> headers = acct.getOrderHistoryTableHeaders();
			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				if (!(list.get(i).get(0).trim() == headers.get(0).getText())) {
					soft.fail("Header is not displayed: " + list.get(i).get(0).trim());
					implicitWait(driver, 10);
				}
			}
		} catch (Exception e) {
			Assert.fail("Not able to Navigate to Order Hsitory Page");
		}

	}

	@Then("^Verify Order Details Page Validation$")
	public void verify_orderdetails_page_val() throws Throwable {
		try {
			click(acct.getFirstOrderInHistory(), "Order Number");
			waitForJStoLoad();
			isElementPresent(acct.getOrderBreadCrum(), "Order Number Breadcrum");
			isElementPresent(acct.getOrderNumber(), "Order Number");
			isElementPresent(acct.getOrderStatus(), "Order Status");
			isElementPresent(acct.getOrderShippingAdd(), "Shipping Address");
			isElementPresent(acct.getOrderDate(), "Order Date");
			isElementPresent(acct.getOrderPlacedBy(), "Order Placed By");
			isElementPresent(acct.getOrderShippingMethod(), "Shipping Method");
			isElementPresent(acct.getOrderedItems(), "Ordered Items");
			isElementPresent(acct.getOrderBillingAdd(), "Billing Address");
			isElementPresent(acct.getOrderPayType(), "Payment Info");
			// isElementPresent(acct.getOrderTotals(), "Totals Section");
		} catch (Exception e) {
			soft.fail("Error in validations");
		}
	}

	@And("^Navigate to MyProfile$")
	public void NavigateToMyprofiles() throws Throwable {
		try {
			waitForJStoLoad();
			click(acct.getwelcomeDropdown(), "Welcome dropdown");
			click(acct.getmyAccount(), "My Account");
			implicitWait(driver, 10);

		} catch (Exception e) {
			soft.fail("My Account not Avaialble");
		}
	}

	@Then("^Verify the Breadcrumb is Visbile$")
	public void VerifyBreadcrumb() throws Throwable {
		try {
			waitForJStoLoad();
			click(acct.getAccountDetails(), "Account Details");
			verifyBreadcrumbs("Account Details");
			click(acct.getAircrafttDetails(), "Aircraft Details");
			verifyBreadcrumbs("Aircraft Details");
			click(acct.getChangeEmail(), "Change Email");
			verifyBreadcrumbs("Change Email");
			click(acct.getChangePassword(), "Change Password");
			verifyBreadcrumbs("Change Password");
			click(acct.getOrderHistory(), "Order History");
			verifyBreadcrumbs("Order History");

		} catch (Exception e) {
			soft.fail("breadcrumb Links are not Visbile");
		}
	}

	public void verifyBreadcrumbs(String strText) {
		List<WebElement> breadcrumbs = acct.getBreadCrumbSection();
		if (breadcrumbs.get(0).getText().toUpperCase().equalsIgnoreCase("HOME")) {
			soft.assertThat("Home is displayed");
		} else {
			soft.fail("Home is not displayed");
		}

		isElementPresent(acct.getBreadCrumbFirstLink(), "Home Link");

		if (breadcrumbs.get(1).getText().toUpperCase().equalsIgnoreCase(strText)) {
			soft.assertThat("Breadcrumb is displayed :" + strText);
		} else {
			soft.fail("Breadcrumb is not displayed :" + strText);
		}
	}

	@Then("^Click on My Account$")
	public void MyAccount() throws Throwable {
		try {
			click(acct.getwelcomeDropdown(), "Welcome dropdown");
			click(acct.getmyAccount(), "My Account");
		} catch (Exception e) {
			soft.fail("My Account not available");
		}
	}


	@Then("^Verify Following Fields are Displaying in Account Details Section:$")
	public void AccountDetails(DataTable dt) throws Throwable {
		try {
			click(acct.getAccountDetails(), "Account Details");
			explicitWait(acct.getAccountDetailsAccountNum());
			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				String string = list.get(i).get(0).trim();
				switch (string) {						
				case "CompanyName":
					isElementPresent(acct.getAccountDetailsCompanyName(),"Company Name");
					break;
				case "AccountNumber":
					isElementPresent(acct.getAccountDetailsAccountNum(),"Account Number");
					break;
				case "CountryCode":
					isElementPresent(acct.getAccountDetailsCountrycode(),"Country Code");
					break;
				case "Areacode":
					isElementPresent(acct.getAccountDetailsAreacode(),"Area Code");
					break;					
				case "PhoneNumber":
					isElementPresent(acct.getAccountDetailsPhoneNum(),"Phone Number");
					break;	
				case "Extension":
					isElementPresent(acct.getAccountDetailsExtension(),"Extension");
					break;								
				case "CANCEL":
					isElementPresent(acct.getAircraftAccountCancel(),"Cancel");
					break;
				case "SAVE":
					isElementPresent(acct.getSavebutton(),"Save");
					break; 	
				}
			}
		}
		catch (Exception e) {
			soft.fail("Account Details not available");
		}
	}

	@And("^Verify Following Fields are Displaying in Aircraft Details Section:$")
	public void AirCaraftDetails(DataTable dt) throws Throwable {
		try {
			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				String string = list.get(i).get(0).trim();
				switch (string) {						
				case "AircraftTailNumber":
					isElementPresent(acct.getaircraftTailNo(),"Aircraft Tail Number");
					break;
				case "AircraftMake":
					isElementPresent(acct.getaircraftMake(),"Aircraft Make");
					break;
				case "AircraftModel":
					isElementPresent(acct.getaircraftModel(),"Aircraft Model");
					break;
				case "AircraftSerialNumber":
					isElementPresent(acct.getaircraftserialno(),"Aircraft Serial Number");
					break;
				case "AircraftYear":
					isElementPresent(acct.getaircraftYear(),"Aircraft Year");
					break;					
				case "TermAndConditionOfPurchase":
					isElementPresent(acct.getPurchaseTermcheckbox(),"TermAndConditionOfPurchase");
					break;						
				case "CANCEL":
					isElementPresent(acct.getAircraftAccountCancel(),"Cancel");
					break;
				case "SAVE":
					isElementPresent(acct.getAircraftDetailsSave(),"Save");
					break; 	
				}
			}
		}
		catch (Exception e) {
			soft.fail("Change Email Address Details not available");
		}
	}

	@And("^Verify Following Fields are Displaying in Change Email Address Section:$")
	public void ChangeEmail (DataTable dt) throws Throwable {
		try {
			click(acct.getChangeEmail(), "Change Email");	
			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				String string = list.get(i).get(0).trim();

				switch (string) {
				case "CurrentEmail":
					isElementPresent(acct.getCurrentEmail(),"Current Email");
					break;
				case "NewEmail":
					isElementPresent(acct.getNewEmail(),"New Email");
					break;
				case "ConfirmYourEmailAddress":
					isElementPresent(acct.getConfirmEmail(),"Confirm Email ID");
					break;
				case "Password":
					isElementPresent(acct.getPassword(),"Password");
					break;
				case "CANCEL":
					isElementPresent(acct.getCancel(),"Cancel");
					break;
				case "SAVE":
					isElementPresent(acct.getSavebutton(),"Save");
					break; 	
				}
			}
		}
		catch (Exception e) {
			soft.fail("Change Email Address Details not available");
		}
	}

	@And("^Verify Following Fields are Displaying in Change Password Section:$")
	public void ChangePassword (DataTable dt) throws Throwable {
		try {
			click(acct.getChangePassword(), "Change Password");	
			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				String string = list.get(i).get(0).trim();

				switch (string) {
				case "CurrentPassword":
					isElementPresent(acct.getCurrentPassword(),"Current Email");
					break;
				case "NewPassword":
					isElementPresent(acct.getNewPassword(),"New Email");
					break;
				case "ConfirmNewPassword":
					isElementPresent(acct.getConfirmPassword(),"Confirm Email ID");
					break;
				case "CANCEL":
					isElementPresent(acct.getCancel(),"Cancel");
					break;
				case "SAVE":
					isElementPresent(acct.getSavebutton(),"Save");
					break; 	
				}
			}
		}
		catch (Exception e) {
			soft.fail("Change Email Address Details not available");
		}
	}

	@Then("^Verify CSC Text in Order History$")
	public void CSCTextinOrderHistory() throws Throwable {
		try {
			click(acct.getOrderNumber(), "Order Number");
			String Strtext = acct.getOrderPlacedBy().getAttribute("innerText");
			if(Strtext.contentEquals("CSC"));
		} catch (Exception e) {
			soft.fail("CSC text not available in Order History  for ASM ");
		}
	}
}



