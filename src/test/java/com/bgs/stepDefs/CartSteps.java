package com.bgs.stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import com.bgs.pageObjects.CartPopUPPage;
import com.bgs.pageObjects.CartPage;

import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	CartPage cart = new CartPage(driver);

	@Then("^Click on CheckOut in Cart Page$")
	public void i_click_on_Add_To_Cart_in_Checkout()

	{
		try {	 
			waitForJStoLoad();
			click(cart.getCheckOut(),"CheckOut in Cart ");

		}catch (Exception e) {
			Assert.fail("CHeckOut  button is not available in popup");
		}		   
	}

	@When("^I Click on REMOVE in Cart Page$")
	public void i_click_on_remove_link_cart()

	{
		try {	 
			waitForJStoLoad();
			click(cart.getRemove(),"Remove in Cart ");

		}catch (Exception e) {
			Assert.fail("Remove link is not available");
		}		   
	}

	@Then("^Product is Removed Message is Displayed$")
	public void product_removed_message()

	{
		try {	 
			waitForJStoLoad();
			if(cart.getAlertMessage().getText().contains("Product has been removed from your cart.")) {}
			else
				soft.fail("Product removed message is not displayed");

		}catch (Exception e) {
			soft.fail("Remove message is not displayed");
		}		   
	}


	@When("^I Increase the Quantity Verify Item Total Price$")
	public void IncreaseQuantityProduct()

	{
		try {	 
			waitForJStoLoad();
			input(cart.getCartQuanity(), "2","Quantity increase");
			cart.getCartQuanity().sendKeys(Keys.TAB);
			implicitWait(driver,10);
			int qty1 = Integer.parseInt(cart.getCartQuanity().getAttribute("value"));
			Float price1 = Float.parseFloat(cart.getCartItemPrice1().getAttribute("innerText").replace("$", "").replace(" each", "").replace(",",""));	
			Float priceItemtotal1=Float.parseFloat(cart.getCartItemTotal1().getAttribute("innerText").replace("$","").replace(",",""));

			if (qty1*price1 == priceItemtotal1) {

			} else {
				soft.fail("Price  is not matching when user increase Quantity");
			}
		}catch (Exception e) {
			e.printStackTrace();
			soft.fail("Not able to update Quantity");
		}
	}

	@When("^I Decrease the Quantity Verify Item Total Price$")
	public void DecreaseQuantityProduct()

	{
		try {	 
			waitForJStoLoad();
			cart.getCartQuanity().clear();
			input(cart.getCartQuanity(), ("1"),"Quantity Decrease");
			cart.getCartQuanity().sendKeys(Keys.TAB);
			implicitWait(driver,10);
			int qty1 = Integer.parseInt(cart.getCartQuanity().getAttribute("value"));
			Float price1 = Float.parseFloat(cart.getCartItemPrice1().getAttribute("innerText").replace("$", "").replace(" each", "").replace(",",""));	
			Float priceItemtotal1=Float.parseFloat(cart.getCartItemTotal1().getAttribute("innerText").replace("$","").replace(",",""));

			if (qty1*price1 == priceItemtotal1) {
			} else {
				soft.fail("Price  is not matching");
			}
		}catch (Exception e) {
			soft.fail("Not able to Update Quantity");
		}
	}



	@And("^Verify Cart Total Price$")
	public void verify_CartTotalPrice()

	{
		try {	 
			waitForJStoLoad();
			float totalprice = 0;
			float itemtotal;
			List<WebElement> allItem= cart.getCartItemAllPrice();
			for(int i=0;i<allItem.size();i++) {
				itemtotal = Float.parseFloat(allItem.get(i).getText().toString().replace("$", "").replace(",",""));
				totalprice = totalprice + itemtotal;
			}

			float total = Float.parseFloat(cart.getCartSubTotal().getText().toString().replace("$", "").replace(",",""));			

			if (totalprice == total) {
			} else {
				soft.fail("Price  is not matching ");
			}

		}catch (Exception e) {
			soft.fail("Error in capturing the prices");
		}
	}


	@Then("^Verify Able to Add Min and Max in PLP$")
	public void AbleToAddMin1Max()

	{
		try {	 
			waitForJStoLoad();

			input(cart.getCartQuanity(), "1","Min Quantity");
			cart.getCartQuanity().sendKeys(Keys.TAB);
			input(cart.getCartQuanity(), "99","Max Quantity");
			cart.getCartQuanity().sendKeys(Keys.TAB);
			input(cart.getCartQuanity(), "101","Max Quantity");
			cart.getCartQuanity().sendKeys(Keys.TAB);

			if(!cart.getAlertWarningValidation().isDisplayed())
			{
				soft.fail("Quantity is not in Range Min1 and Max99");

			}
			}catch (Exception e) {
				soft.fail("Quantity is not in Range Min1 and Max99");
			}
		soft.assertAll();
		}

	


	@Then("^Remove All Items From Cart$")
	public void remove_all_cart() {
		try {
			click(cart.getCartIcon(),"Cart Icon");

			if(cart.getRemove().isDisplayed()) {
				do {
					click(cart.getRemove(),"Remove link");				
				}while(cart.getRemove().isDisplayed());

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Then("^Verify for Cart is Empty Message$")
	public void cart_empty_message() {
		try {
			isElementPresent(cart.getEmptyCartMsg(),"Empty Cart Message");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	}

