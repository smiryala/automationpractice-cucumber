package com.bgs.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.bgs.pageObjects.PDPPage;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDPSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	PDPPage pdp = new PDPPage(driver);

	@Then("^Verify PDP Page for NonConfigurable Products$")
	public void verify_PDP_page_for_non_configurable_products() {
		try {
			waitForJStoLoad();

			implicitWait(driver, 5);
			Thread.sleep(5000);
			isElementPresent(pdp.getProductImage(), "PDP Big Image");
			isElementPresent(pdp.getDescription(), "PDP Description");
			isElementPresent(pdp.getProductName(), "PDP Name");
			isElementPresent(pdp.getAddToCart(), "Add to Cart Button");
			isElementPresent(pdp.getSmallImage1(), "PDP Small Image 1");
			isElementPresent(pdp.getSmallImage2(), "PDP Small Image 2");
			isElementPresent(pdp.getSmallImage3(), "PDP Small Image 3");

			verifygetText(pdp.getProductDetailsTab(), "FEATURES", "PDP Features Tab");
			verifygetText(pdp.getSpecTab(), "SPECIFICATIONS", "PDP Specs Tab");
			verifygetText(pdp.getDeliveryTab(), "DELIVERY", "PDP Delivery Tab");
			verifygetText(pdp.getSupportTab(), "SUPPORT", "PDP Support Tab");

		} catch (Exception e) {
			Assert.fail("Error in PDP page");
		}
	}

	@Then("^Verify PDP Page for Configurable Products$")
	public void verify_PDP_page_for_configurable_products() {
		try {
			waitForJStoLoad();
			implicitWait(driver, 5);
			Thread.sleep(5000);
			isElementPresent(pdp.getProductImage(), "PDP Big Image");
			isElementPresent(pdp.getDescription(), "PDP Description");
			isElementPresent(pdp.getProductName(), "PDP Name");
			isElementPresent(pdp.getConfigureProduct(), "Configure Product button");
			isElementPresent(pdp.getSmallImage1(), "PDP Small Image 1");
			isElementPresent(pdp.getSmallImage2(), "PDP Small Image 2");
			isElementPresent(pdp.getSmallImage3(), "PDP Small Image 3");

			verifygetText(pdp.getProductDetailsTab(), "FEATURES", "PDP Features Tab");
			verifygetText(pdp.getSpecTab(), "SPECIFICATIONS", "PDP Specs Tab");
			verifygetText(pdp.getDeliveryTab(), "DELIVERY", "PDP Delivery Tab");
			verifygetText(pdp.getSupportTab(), "SUPPORT", "PDP Support Tab");

		} catch (Exception e) {
			Assert.fail("Error in PDP page");
		}
	}

	@Then("^I Click on Add To Cart in PDP$")
	public void i_click_on_Add_To_Cart_in_PDP() {
		try {
			click(pdp.getAddToCart(), "PDP Add to Cart");
		} catch (Exception e) {
			Assert.fail("PDP Add to Cart is not available");
		}

	}


	@When("^I Click on PLUS Sign Verify Quantity is Increased$")
	public void i_click_on_Plus_sign_quantity_is_increased() {
		try {
			String preqty = pdp.getQuantity().getAttribute("value");
			click(pdp.getSelQuantityPlus(), "PLUS icon");

			if (Integer.parseInt(pdp.getQuantity().getAttribute("value").toString()) > Integer.parseInt(preqty)) {
			} else {
				soft.fail("Quanity is not increased if user clicks on PLUS sign");
			}
		} catch (Exception e) {
			soft.fail("Error in : I click on Plus sign then quantity is increased");
		}
	}


	@When("^I Click on MINUS Sign Verify Quantity is Decreased$")
	public void i_click_on_Minus_sign_quantity_is_decreased() {
		try {
			String preqty = pdp.getQuantity().getAttribute("value");
			click(pdp.getSelQuantityMinus(), "MINUS icon");

			if (Integer.parseInt(pdp.getQuantity().getAttribute("value").toString()) < Integer.parseInt(preqty)) {
			} else {
				soft.fail("Quanity is not decreased if user clicks on MINUS sign");
			}
		} catch (Exception e) {
			soft.fail("Error in : I click on MINUS sign then quantity is decreased");
		}
	}

	@Then("^User Should be Not be Able to See Any Price of the Configurable Product$")
	public void Config_price_validation() {
		try {
			scrollIntoView(pdp.getPrice());
			if (!getText(pdp.getPrice()).isEmpty()) {
				Assert.fail("price should not be displayed for config products");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Then("^Verify the Prices and Quantity Functionality$")
	public void simple_price_validation(DataTable Q) {
		int i = 0;
		try {
			readData(Q);
			scrollIntoView(pdp.getPrice());
			if (pdp.getPrice().isDisplayed()) {
				if (pdp.getQuantity().isDisplayed()) {
					input(pdp.getQuantity(), testdata.get("Quantity"), "quantity value");

					if ((pdp.getSelQuantityPlus().getAttribute("disabled")).equals("true"))

						for (i = 1; i <= 10; i++) {

							click(pdp.getSelQuantityMinus(), "decreases the quantity");
						}
					input(pdp.getQuantity(), testdata.get("Quantity1"), "quantity value");
					if (getAttribute(pdp.getSelQuantityMinus(), "disabled").equals("true"))

						while (i > 1) {
							click(pdp.getSelQuantityPlus(), "increases quantity");
							i--;
						}
				}

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}


	@Then("^Click on Configurable Product$")
	public void configurable_product_click() {
		try {
			scrollIntoView(pdp.getConfigureProduct());
			click(pdp.getConfigureProduct(), "configurable product");

		}catch(Exception e) {e.getStackTrace();
		}
	}


	@Then("^Verify Price of Product in PDP$")
	public void PriceOfProductPDP() {
		try {

			Float pricePDP=Float.parseFloat(pdp.getPrice().getAttribute("innerText").replace("$","").replace(",",""));
			if(pricePDP==Float.parseFloat(envVariable.get("pricePLP"))){}
			else{
				soft.fail(" PDP price is not same as is displayed in PLP");
			}			

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Then("^Verify if USD Available Add to Cart Should Displayed in PDP$")
	public void USDPriceAndAddtoCartinPLP() {
		try {
			scrollIntoView(pdp.getPrice());
			if(pdp.getPrice().getText().contains("$"))
				if(pdp.getPrice().isDisplayed())
					isElementPresent(pdp.getAddToCart(),"Add to Cart");
				else {
					Assert.fail("Price or Add to Cart Button not Available");
				}
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}


	@Then("^Verify Able to Add Min and Max in PDP$")
	public void AbleToAddMinAndMaxinPDP()

	{
		try {	 
			waitForJStoLoad();
			input(pdp.getQuantity(),"100"," Max Quantity");
			if ((pdp.getSelQuantityPlus().getAttribute("disabled")).equals("true"))
				input(pdp.getQuantity(), "1","Min Quantity");
			else {
				soft.fail("Quantity is not in Range Between Min 1 to Max 99" );
			}

		} catch (Exception e) {
			soft.fail("Quantity is not in Range Between Min 1 and Max 99");
		}
		soft.assertAll();
	}
}


