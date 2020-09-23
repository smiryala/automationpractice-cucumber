package com.bgs.stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.omg.CORBA.TIMEOUT;

import com.bgs.pageObjects.*;
import com.framework.library.GlobalVariables;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends CommonFunctions {

	WebDriver driver = Hooks.getDriver();
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);
	PLPPage plp = new PLPPage(driver);
	PDPPage pdp = new PDPPage(driver);
	CartPopUPPage popup = new CartPopUPPage(driver);
	CheckoutPage checkout = new CheckoutPage(driver);
	ConfigPage config = new ConfigPage(driver);

	CartPopUPPage addtocartpopup = new CartPopUPPage(driver);

	/*
	 * @Then("^(.+) popup is opened$") public void popup_is_opened(String popup) {
	 * 
	 * try { Assert.assertEquals(true,
	 * addtocartpopup.getAddtoCartPopUPCheckout().isDisplayed()); } catch (Exception
	 * e) { Assert.fail(popup + " - is not displayed"); } }
	 */

	@Given("^Navigate to BGS Application$")
	public void i_navigate_to_aviall() throws Throwable {
		driver.manage().deleteAllCookies();
		driver.navigate().to(GlobalVariables.APPURL);
		waitForJStoLoad();
		// screenCapture(driver);
	}

	@Then("^(.+) Page is Opened$")
	public void page_is_opened(String pagename) throws Throwable {
		WebElement currentpage = null;
		String page = pagename.replaceAll("\'", "");
		waitForJStoLoad();
		switch (page) {
		case "HOME":
			currentpage = home.getHomepage();
			break;
		case "LOGIN":
			currentpage = login.getLoginPage();
			break;
		case "PLP":
			currentpage = plp.getPLPPage();
			break;
		case "PDP":
			currentpage = pdp.getPDPInfo();
			break;
		case "Config":
			currentpage = config.getConfigPage();
			break;
		case "CHECKOUT":
			currentpage = checkout.getShippingAddressTitle();
		default:
			// Statements

		}

		try {
			if(currentpage.isDisplayed()) {
				soft.assertThat(page + " - Page is displayed");
			}
			else{
				soft.fail(page + " - Page is not displayed");
			}
		} catch (Exception e) {
			soft.fail(page + " - Page is not displayed");
			e.printStackTrace();
		}

	}

	@When("^I Search and Add Below Configurable Products to Cart:$")
	public void add_products(DataTable dt) throws Throwable {
		readData(dt);
		List<List<String>> list = dt.asLists(String.class);
		for (int i = 1; i <= list.size(); i++) {
			if (list.get(i - 1).get(1).trim().contains("searchProduct")) {

				input(home.getSearchBar(), testdata.get("searchProduct" + i), "search");

				click(home.getSearchSubmit(), "search");
				scrollIntoView(plp.getProductValidationScroll());
				click(plp.getProductListName(), "Product Decription");
				click(pdp.getConfigureProduct(), "configurable product");
				if (config.getConfigPage().isDisplayed()) {
					selectValue(config.getAircraft(), "INDEX", "1");
					//					selectValue(config.getAircraft(), "VISIBLETEXT", testdata.get("Aircraft"));
					waitForJStoLoad();
					try {
						if (config.getAvionics().isDisplayed()) {
							selectValue(config.getAvionics(), "INDEX", "1");
							//							selectValue(config.getAvionics(), "VISIBLETEXT", testdata.get("Avionics"));
						}
					} catch (Exception e) {}
					//scrollIntoView(config.getCoverages());
					//selectValue(config.getCoverages(),"VISIBLETEXT", testdata.get("Coverages"));
					try {
						if(config.getCoverages().isDisplayed())
							selectValue(config.getCoverages(), "INDEX", "1");
					}
					catch(Exception e) {}
					click(config.getServices(), "selects services");
					waitForJStoLoad();
					if (config.getConfigPrice().isDisplayed()) {
						scrollIntoView(config.getConfigAddtoCart());
						click(config.getConfigAddtoCart(), "adds to cart");
						click(popup.getcontinueShopping(), "continues search");
					}

				}
			}
		}
	}

	@Then("^Verify for Available Products Text$")
	public void available_text() throws Throwable {
		try {
			if(driver.findElement(By.xpath("//.[contains(text(),'available')]|//.[contains(text(),'Available')]")).isDisplayed()) {
				soft.fail("Available text is present on page");			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}
