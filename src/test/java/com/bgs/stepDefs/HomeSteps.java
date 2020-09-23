package com.bgs.stepDefs;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.bgs.pageObjects.HomePage;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebElement;

public class HomeSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	HomePage home = new HomePage(driver);

	@When("^I Click on Login$")
	public void i_click_on_login_button() throws Throwable {
		try {
			home.getLoginLink().click();
		} catch (Exception e) {
			Assert.fail("click on login link");
		}
	}

	@And("^I Click on LogOut$")
	public void i_click_on_logout_link() throws Throwable {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", home.getLogOutLink());
		} catch (Exception e) {
			Assert.fail("Logout is not successfull");
		}
	}

	@Then("^User Should be Able to View the Below Components in Home Page:$")
	public void verify_components_homepage(DataTable dt) throws Throwable {
		try {

			List<List<String>> list = dt.asLists(String.class);
			for (int i = 0; i < list.size(); i++) {
				String string = list.get(i).get(0).trim();

				switch (string) {
				case "CompanyLogo":
					isElementPresent(home.getCompanyLogo(),string);
					break;
				case "CartIcon":
					isElementPresent(home.getCartIcon(),string);
					break;
				case "GlobalNavigationBar": 
					isElementPresent(home.getGlobalNavigationBar(),string);
					break;
				case "HeroBanner":
					isElementPresent(home.getHeroBanner(),string);
					break;
				case "MainCategory": 
					isElementPresent(home.getMainCategory(),string);
					break;
				case "RecommendedProducts": 
					isElementPresent(home.getRecommendedCategory(),string);
					break;
				case "PopularProducts":
					isElementPresent(home.getPopularCategory(),string);
					break;
				case "ShopCategory":
					isElementPresent(home.getShopCategory(),string);
					break;
				case "FamilyBrands":
					isElementPresent(home.getFamilyBrands(),string);
					break;
				}
			}

		} catch (Exception e) {
		}
	}

	@Then("^I Search for the Product:$")
	public void search_functionality(DataTable dt) {
		readData(dt);
		try {
//		if (home.getSearchBar().isDisplayed()) {
			scrollIntoView(home.getSearchBar());
			input(home.getSearchBar(), testdata.get("searchProduct"), "search");
			waitForSomeTime(2000);
			click(home.getSearchSubmit(), "search");
			waitForJStoLoad();
//		}
		}catch(Exception e) {
			Assert.fail("Not able to search product");
		}
	}

	@And("^It Should Display Message Zero Results Found$")
	public void zeroResult() {
		if (!home.getzeroItemMessage().isDisplayed()) {
			soft.fail("Search Result not Working");

		}
	}
}




