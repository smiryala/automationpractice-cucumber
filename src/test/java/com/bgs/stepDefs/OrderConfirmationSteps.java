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


public class OrderConfirmationSteps extends CommonFunctions {	
	WebDriver driver = Hooks.getDriver();
	
	OrderConfirmationPage orderconfirm = new OrderConfirmationPage(driver);


@Then("^Verify Order Confirmation Page Validation$")
    public void ordernum_confirm_verify() {
		try {
			if(!driver.getCurrentUrl().toString().contains(orderconfirm.getOrderNumber().getText())){
				soft.fail("Order number is not diaplyed in URL: " + driver.getCurrentUrl().toString() );
			}
			
			isElementPresent(orderconfirm.getItemsShipped(),"Items Shipped in Order COnfirm Page");
			isElementPresent(orderconfirm.getFooterLinks(),"Footer links in Order Confirm Page");
			isElementPresent(orderconfirm.getNavigationBar(),"Navigation Bar in Order Confirm Page");
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
}

