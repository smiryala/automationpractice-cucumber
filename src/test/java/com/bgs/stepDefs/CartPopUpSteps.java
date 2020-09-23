package com.bgs.stepDefs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import com.bgs.pageObjects.*;
import com.framework.library.GlobalVariables;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class CartPopUpSteps extends CommonFunctions {	
	WebDriver driver = Hooks.getDriver();
	
	CartPopUPPage popup = new CartPopUPPage(driver);



	@Then("'Added To Cart' PopUp is Opened$")
	public void popup_is_opened() {
		try {
		if(popup.getItemAddedPopup().isDisplayed()) {
			if((popup.getimageaddedinpopup().isDisplayed())&&(popup.getpopupDescription().isDisplayed())
					&&(popup.getpopupQuantityaddded().isDisplayed())) {
//				System.out.print("popup working fine");
								
			}

		}
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Then("^Click on CheckOut in PopUp$")
    public void popup_checkoutButton() {
		try {
			click(popup.getpopUPcheckoutButton(), "checkOutOnPopup");
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	@Then("^Click on Continue Shoping in PopUp$")
    public void popup_continueShoppingLink() {
		try {
			click(popup.getcontinueShopping(), "continueShoping");
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
}

