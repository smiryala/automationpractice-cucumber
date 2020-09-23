package com.bgs.stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bgs.pageObjects.CheckoutPage;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CheckoutSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	CheckoutPage checkout = new CheckoutPage(driver);



	@Then("^Validate Error Message for Country:$")
	public void ValidateErrorMessageCountry(DataTable dt) {
		try {
			readData(dt);
			click(checkout.getShippingAddressNextButton(),"Shipping button next button");
			implicitWait(driver,10);
			verifygetText(checkout.getcountryErrorMessage(),testdata.get("countryError"),"country Error Message");
			implicitWait(driver,10);

		} catch (Exception e) {
			soft.fail(e.getMessage());
		}
	}


	@Then("^Validate the All Fields in the Shipping Address$")
	public void ValidateAllFieldsShipAddress() {
		try {

			isElementPresent(checkout.getShippingAddressCountry(),"Shipping Country");
			isElementPresent(checkout.getShippingFirstName(),"First Name");
			isElementPresent(checkout.getShippingLastName(),"Last Name");
			isElementPresent(checkout.getShippingAddressLine1(),"Shipping Address Line 1");
			isElementPresent(checkout.getShippingAddressLine2(),"Address Line 2 Optional");
			isElementPresent(checkout.getShippingAddressTownCity(),"Town city");
			isElementPresent(checkout.getShippingAddressState(),"Shipping Address State");
			isElementPresent(checkout.getShippingAddressPostCode(),"Post Code");
			isElementPresent(checkout.getShippingAddressCountryCode(),"Country code");
			isElementPresent(checkout.getShippingAddressAreaCode(),"Area Code");
			isElementPresent(checkout.getShippingAddressPhoneNumber(),"Phone Number");
			isElementPresent(checkout.getShippingAddressExtension(),"Extension");
			isElementPresent(checkout.getShippingAddressNextButton(),"Shipping Address next button");

		} catch (Exception e) {
			soft.fail(e.getMessage());
		}
	}


	@Then("^Validate Error Message for Mandatory Fields in ShippingAddress:$")
	public void ValidateErrorMessageMandatoryFields(DataTable dt) {
		try {
			readData(dt);
			waitForJStoLoad();
			selectValue(checkout.getShippingAddressCountry(), "VISIBLETEXT", "United States");
			implicitWait(driver,10);
			waitForJStoLoad();
			click(checkout.getShippingAddressNextButton(),"Shipping button next button");
			implicitWait(driver,10);
			verifygetText(checkout.getfirstNameErrorMessage(),testdata.get("firstNameError"),"First Name Error Message");
			verifygetText(checkout.getlastNameErrorMessage(),testdata.get("lastNameError"),"Last Name Error Message");
			verifygetText(checkout.getaddressLine1ErrorMessage(),testdata.get("add1Error"),"Address Error Message");
			verifygetText(checkout.getaddressTownCityErrorMessage(),testdata.get("TownCityError"),"TownCity Error Message");
			verifygetText(checkout.getaddressStateErrorMessage(),testdata.get("stateError"),"State Error Message");
			verifygetText(checkout.getaddressZipPostCodeErrorMessage(),testdata.get("zipcodeError"),"Zip code Error Message");
			verifygetText(checkout.getaddresscountryCodeErrorMessage(),testdata.get("countrycodeError"),"Country code Error Message");
//			verifygetText(checkout.getaddressAreaCodeErrorMessage(),testdata.get("areacodeError"),"Country Area code Error Message");
			verifygetText(checkout.getaddressPhoneNumberErrorMessage(),testdata.get("phoneError"),"Phone Number Error Message");                       

		} catch (Exception e) {
			soft.fail(e.getMessage());
		}
	}

	@And("^I Input Shipping Address Section:$")
	public void input_all_the_fields_in_the_shipping_address_section_in_the_checkout_flow_page(DataTable dt) {

		try {
			readData(dt);
			selectValue(checkout.getShippingAddressCountry(), "VISIBLETEXT", testdata.get("shippingcountry"));
			waitForSomeTime(6000);
			waitForJStoLoad();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address.firstName']")));
			
			input(checkout.getShippingFirstName(),testdata.get("shippingfirstname"),"First Name");
			input(checkout.getShippingLastName(),testdata.get("shippingLastName"),"Last Name");
			input(checkout.getShippingAddressLine1(),testdata.get("shippingaddress1"),"Address Line 1");
			input(checkout.getShippingAddressLine2(),testdata.get("shippingaddress2"),"Address Line 2 Optional");
			input(checkout.getShippingAddressTownCity(), testdata.get("shippingaddresscity"),"Town city");
			selectValue(checkout.getShippingAddressState(),"VISIBLETEXT", testdata.get("shippingaddressstate"));
			input(checkout.getShippingAddressPostCode(),testdata.get("shippingzipcode"),"Post Code");
			input(checkout.getShippingAddressCountryCode(),testdata.get("shippingcountrycode"),"Country code");
			input(checkout.getShippingAddressAreaCode(),testdata.get("shippingcountryareacode"),"Area Code");
			input(checkout.getShippingAddressPhoneNumber(),testdata.get("shippingphone"),"Phone Number");
			input(checkout.getShippingAddressExtension(),testdata.get("shippingExtension"),"Extension");
			click(checkout.getShippingAddressNextButton(),"Shipping Address next button");
			implicitWait(driver,18);
			waitForJStoLoad();

			try {
				checkout.getReplaceAddress().click();
				implicitWait(driver,15);
			}
			catch(Exception e) {}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@And("^I Select Shipping Method:$")
	public void select_shipping_method_checkout_flow (DataTable dt) {
		try {
			readData(dt);	
			click(checkout.getShipppingDetails(),"Shipping Details drop down box");
			implicitWait(driver,4);
			selectValue(checkout.getShipppingDetails(), "INDEX", "1");
			/*	selectValue(checkout.getShipppingDetails(), "VISIBLETEXT", testdata.get("shippingDetails"));*/
			click(checkout.getShipppingDetailsNextButton(),"Shipping Details Next button");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@And("^I Input Payment Information:$")
	public void input_all_the_values_in_the_fields_respectively_post_selecting_the_radio_button_of_credit_card_account_pay(DataTable dt) {

		try {
			readData(dt);	
//			click(checkout.getAccountPayRadio(),"Account Payment Radio");
			click(checkout.getPaymentBillingPONumber(),"Account payment PO number");
			input(checkout.getPaymentBillingPONumber(),testdata.get("accountpayment"),"Account payment PO number");
			click(checkout.getPaymentBillingNextButton(),"Account Payment Next button");
			implicitWait(driver,10);
			waitForJStoLoad();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Navigate to Final Review and Accept Terms and Condition$")
	public void navigate_to_final_review_and_accept_term_and_condition() {
		try {
			scrollIntoView(checkout.getFinalReviewTermCheckbox());
			click(checkout.getFinalReviewTermCheckbox(),"Final Rivew term and condition check box");
			implicitWait(driver,4);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on Place Order Button$")
	public void place_order() {
		try {
			scrollIntoView(checkout.getFinalReviewPlaceOrder());
			click(checkout.getFinalReviewPlaceOrder(), "place order");
			if(!checkout.getPlaceOrderConfirmation().isDisplayed()) {
				Assert.fail("Place order failed");
			}
		} catch(Exception e) {
			Assert.fail("failed to place order");
		}

	}

	@And("^Click on Edit in Shipping Address$")
	public void EditShippingAddress() {
		try {
			click(checkout.getShipppingAddressEdit(),"Edit Link");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@And("^Verify Shipping Method Lowest in the Top and Highest in the Bottom$")
	public void VerifyLowestTop() {
		try {
			waitForJStoLoad();
			click(checkout.getShipppingDetails(),"shipping Details");
			/*	selectValue(checkout.getShipppingDetails(),"INDIX", "O");*/

			Select shippdetails = new Select(checkout.getShipppingDetails());
			List<WebElement> ls=shippdetails.getOptions();
			for(int i=0;i<ls.size();i++) {
				//				el.getText().replace("[^0-9]", "");
				String[] curText = ls.get(i).getText().replace("$","@").split("@");
				String currText = curText[1].toString().replace(",","");

				String[] nxtText = ls.get(i).getText().replace("$","@").split("@");
				String nxttText = nxtText[1].toString().replace(",","");
				if (currText.compareTo(nxttText) > 0) {
					Assert.fail("shipping methods are not in assending order");
				}
			}
		}catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@And("^Verify Order Totals$")
	public void verify_OrderTotalPrice()

	{
		try {	 
			waitForJStoLoad();
			float totalprice = 0;
			float itemtotal;
			List<WebElement> allItem= checkout.getOrderTotals();
			for(int i=0;i<allItem.size()-1;i++) {
				String[] price = allItem.get(i).getText().replace("$","@").split("@");
				itemtotal = Float.parseFloat(price[1].toString().replace(",",""));
				totalprice = totalprice + itemtotal;
			}
			
			String[] totprice = allItem.get(allItem.size()-1).getText().replace("$","@").split("@");
			float total = Float.parseFloat(totprice[1].toString().replace(",",""));			
			
			if (totalprice == total) {
			} else {
				soft.fail("Total price  is not matching");
			}
			
		}catch (Exception e) {
			Assert.fail("Error in verify order details");
			e.printStackTrace();
		}
	}

/*	@And("^Verify the SubTotal Tax Shippping Charge$")
	public void VerifySubTotalShipping() {
		try {

			Float shipfinalTotal=Float.parseFloat(checkout.getShipTotal().getAttribute("innerText").replace("$","").replace(",",""));

			if (shipfinalTotal==Float.parseFloat(envVariable.get("finalTotal")))
			{
				System.out.println("Total Price is matching with Place Order Price");
			} else {
				System.out.println("Total Price is Not matching with Place Order Price");
				Assert.fail("Price  is not matching");
			}
		}catch (Exception e) {
			Assert.fail("Price  is not matching");
		}
	}
*/

	@Then("^I Enter Credit Card Details:$")
	public void enter_cc_card_details(DataTable dt) {
		readData(dt);
		try {
			click(checkout.getCreditCardRadio(),"CC Radio");
			
			driver.switchTo().frame("xieCommFrame");
			
			input(checkout.getCCNumber(),testdata.get("number"),"CC Number");
			input(checkout.getCCNameOnCard(),testdata.get("name"),"CC Name");
			input(checkout.getCCExpMonth(),testdata.get("month"),"CC Exp Month");
			input(checkout.getCCExpYear(),testdata.get("year"),"CC Exp Year");
			input(checkout.getCCCVV(),testdata.get("cvv"),"CC CVV");
			
			driver.switchTo().defaultContent();
			click(checkout.getShippingPaymentDetailsNextButton(),"Next Button");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

/*	@And("^Verify the SubTotal Tax Shippping Charge$")
	public void VerifySubTotalShipping() {
		try {

			Float shipfinalTotal=Float.parseFloat(checkout.getShipTotal().getAttribute("innerText").replace("$","").replace(",",""));

			if (shipfinalTotal==Float.parseFloat(envVariable.get("finalTotal")))
			{
				System.out.println("Total Price is matching with Place Order Price");
			} else {
				System.out.println("Total Price is Not matching with Place Order Price");
				Assert.fail("Price  is not matching");
			}
		}catch (Exception e) {
			Assert.fail("Price  is not matching");
		}
	}
*/

	@And("^Verify Credit Card Mandatory Fields Error Messages:$")
	public void verify_cc_card_error(DataTable dt) {
		readData(dt);
		try {
			waitForJStoLoad();
			click(checkout.getCreditCardRadio(),"CC Radio");
			click(checkout.getShippingPaymentDetailsNextButton(),"Next Button");
			
			driver.switchTo().frame("xieCommFrame");
			implicitWait(driver,10);
			
			verifygetText(checkout.getCCInvalidCardError(),testdata.get("cardNumError"),"Card Error Message");	
			verifygetText(checkout.getCCInvalidNameError(),testdata.get("cardNameError"),"Card Name Error Message");
			verifygetText(checkout.getCCInvalidExpDateError(),testdata.get("expDateError"),"Exp Date Error Message");
			verifygetText(checkout.getCCInvalidCVVError(),testdata.get("cvvError"),"CVV Error Message");
			
			driver.switchTo().defaultContent();			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
}






