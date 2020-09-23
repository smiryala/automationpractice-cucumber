package com.bgs.stepDefs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.bgs.pageObjects.ConfigPage;
import com.bgs.pageObjects.PDPPage;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ConfigSteps extends CommonFunctions{
	
	WebDriver driver = Hooks.getDriver();
	ConfigPage config     = new ConfigPage(driver);

	@Then("^Verify That the Tail Nummber Added in the My Account Tail Info is Visible in the Dropdown$")
	public void fields_validations(DataTable dt) {
		readData(dt);
		try {
			selectValue(config.getAircraft(),"VISIBLETEXT", testdata.get("Aircraft"));
		}catch(Exception e) {e.getStackTrace();}
		
	}

	@Then("^Select a Required Tail Number and Click on the Dropdown$")
	public void fields_inputs(DataTable dt) {
		readData(dt);
		try {
			selectValue(config.getAvionics(),"VISIBLETEXT", testdata.get("Avionics"));
			selectValue(config.getCoverages(),"VISIBLETEXT", testdata.get("Coverages"));
			click(config.getServices(), "selects services");
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		
	}
	
	@Then("^Once Product is Configured, Add the Configured Product to the Cart$")
	public void add_to_cart() {
		try {
			if(config.getConfigPrice().isDisplayed()) {
				scrollIntoView(config.getConfigAddtoCart());
				click(config.getConfigAddtoCart(), "adds to cart");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
