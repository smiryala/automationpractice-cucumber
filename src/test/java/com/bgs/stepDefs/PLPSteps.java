package com.bgs.stepDefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.bgs.pageObjects.PLPPage;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

//import ch.qos.logback.classic.Logger;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PLPSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	PLPPage plp = new PLPPage(driver);

	@And("^Verify Result Matches with Actual Value$")
	public void search_results(DataTable dt) {
		readData(dt);
		// String product = testdata.get("searchProduct");
		try {
			//			screenCapture(driver);
			if (plp.getSearchResults().isDisplayed()) {
				scrollIntoView(plp.getProductValidationScroll());
				for (WebElement webElement : plp.getProductValidation()) {

					if (!getText(webElement).contains(testdata.get("searchProduct"))) {

						verifyContainsUsingSoft(getText(webElement), testdata.get("searchProduct"));

					}

				}
			}
		} catch (Exception e) {
			Assert.fail("results not found");
		}

	}

	@And("^Verify that Price of Configurable Product is Not Displayed in PLP$")
	public void price_validation_config() {
		try {
			// scrollIntoView(plp.getProductValidationScroll());
			if (!getText(plp.getProductListingPrice()).isEmpty()) {
				Assert.fail("product price should not be visible for config products");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@And("^Verify the Price and Currency of the Product for Simple Product$")
	public void price_validation_simple() {
		try {
			scrollIntoView(plp.getProductValidationScroll());
			isElementPresent(plp.getProductListingPrice(),"Product Price");
//			if (!plp.getProductListingPrice().isDisplayed()) {
//				Assert.fail("product price should not be visible for config products");
//			}
			click(plp.getProductImage(), "on product");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^Clicking Configurable Product to Re-directed To PDP Page$")
	public void click_on_config_product() {
		try {
			click(plp.getProductImage(), "on product");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^User Able to View the Products Related to Searched Keyword$")
	public void product_keyword_validation() {
		try {
			if (plp.getProductValidation().size() <= 20) {
				scrollIntoView(plp.getProductValidationScroll());
				for (int i = 1; i <= plp.getProductValidation().size(); i++) {
					WebElement productImage = driver
							.findElement(By.xpath("//ul[contains(@class,'product__list')]/li[" + i + "]/div/a"));
					WebElement productPrice = driver
							.findElement(By.xpath("(//div[@class='panel-body']/div/div[2]/div/div[1])[\"+i+\"]"));
					WebElement addtoCartButton = driver
							.findElement(By.xpath("(//button[contains(text(),\"Add to Cart\")])[\"+i+\"]"));
					/*
					 * String imageColorHex = productImage.getCssValue("background-color");
					 * //.replace(")", "").replace("rgba(", "") //.replace(",",
					 * "").replaceAll("\\s", "");
					 */
					if (productImage.isDisplayed()) {
						String productTitle = productImage.getAttribute("title");
						String productPriceText = productPrice.getText();
						if ((productTitle.isEmpty() || productTitle == null)
								&& (productPriceText.isEmpty() || productPriceText == null)
								&& (!addtoCartButton.isDisplayed())) {
							soft.fail("Either product title or product price is missing");
						}
						//						System.out.println(productTitle);
					} else
						soft.fail("Product image is not displayed");
				}
			}
		} catch (Exception e) {
			Assert.fail("products found are morethan 20");
		}

	}

	@Then("^Sort the Search Products in Ascending Order$")
	public void Ascending_order_PLP(DataTable dt) {
		readData(dt);

		try {
			scrollIntoView(plp.getProductValidationScroll());
			selectValue(plp.getSelectSorting(), "VISIBLETEXT", testdata.get("AscendingOrder"));
			// for (WebElement webElement : plp.getProductValidation()) {
			// if (getText(webElement).contains("100")) {
			TimeUnit.SECONDS.sleep(4);
			for (int i = 0; i < plp.getProductTitle().size() - 1; i++) {

				String currentText = plp.getProductTitle().get(i).getText();
				String nextText = plp.getProductTitle().get(i + 1).getText();
				// scrollIntoView(plp.getProductTitle().get(i + 1));
				if (currentText.toUpperCase().compareTo(nextText.toUpperCase()) < 0) {
					// A is lessthan B it returns -1.
					soft.assertThat(true);

				} else {
					soft.fail("Failed in iteration");
				}

			}
			// click(, "click on next button");

		} catch (Exception e1) {
			e1.getMessage();
		}
	}

	@Then("^Sort the Search Products in Descending Order$")
	public void descending_order_PLP(DataTable dt) {
		readData(dt);

		try {
			scrollIntoView(plp.getProductValidationScroll());
			selectValue(plp.getSelectSorting(), "VISIBLETEXT", testdata.get("DescendingOrder"));
			// for (WebElement webElement : plp.getProductValidation()) {
			// if (getText(webElement).contains("100")) {

			// for (int k = 1; k < 3; k++) {
			//
			// if (k == 2) {
			// click(plp.getNextButton(), "next button");
			// }

			for (int i = 0; i < plp.getProductTitle().size(); i++) {

				String currentText = plp.getProductTitle().get(i).getText();
				String nextText = plp.getProductTitle().get(i + 1).getText();
				scrollIntoView(plp.getProductTitle().get(i));
				if (nextText.toUpperCase().compareTo(currentText.toUpperCase()) < 0) {
					// A is lessthan B it returns -1
				} else {
					soft.fail("Failed in iteration");
				}
			}
			// }

		} catch (Exception e1) {
			e1.getMessage();

		}
	}

	@Then("^I Click on First Product in PLP$")
	public void i_click_on_first_product_in_PLP() {

		try {
			// scrollIntoView(plp.getProductValidationScroll());
//			click(plp.getProductListName(), "Product Decription");
			click(plp.getProductImage(), "Product Image");
		} catch (Exception e) {
			Assert.fail("Product description link is not availablle");
		}
	}

	@Then("^I Click on First Product Add To Cart in PLP$")
	public void i_click_on_first_product_Add_To_Cart_in_PLP() {
		try {
			click(plp.getAddToCart(), "Add to Cart");
		} catch (Exception e) {
			Assert.fail("Add to cart button is not available");
		}

	}

	@And("^Price Range Selected Should Match With Prices of Products Displayed$")
	public void price_range_validation() {
		try {

			List<WebElement> priceRange = driver
					.findElements(By.xpath("//ul[@class='facet__list js-facet-list ']/li/form/label/input"));
			for (int i = 1; i <= priceRange.size(); i++) {

				WebElement element = driver
						.findElement(By.xpath("//ul[@class='facet__list js-facet-list ']/li[" + i + "]/form/label"));
				scrollIntoView(element);
				click(element, "price range");
				String price = getText(plp.getAppliedFacet());
				String val1 = price.replace("$", "").replaceAll("\\s", "").replaceAll(",", "");
				String[] val2 = val1.split("-");
				Double lVal = Double.parseDouble(val2[0]);
				Double uVal = Double.parseDouble(val2[1]);

				String pP = getText(plp.getProductPrice());
				String pPval = pP.replace("$", "").replaceAll("\\s", "").replaceAll(",", "");
				Double actualValue = Double.parseDouble(pPval);

				scrollIntoView(plp.getProductValidationScroll());
				if (!((lVal < actualValue) && (uVal > actualValue))) {
					soft.fail("price range products are not displayed");
				}
				click(plp.getAppliedFacetClose(), "closes facet");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@And("^Verify Facets Selected Match With Results Displayed$")
	public void facet_search_check() {
		try {
			List<WebElement> byCategory = driver
					.findElements(By.xpath("//div[@id='landing-filter']/div/div[2]/ul/li/label/span/a"));
			for (int i = 1; i <= byCategory.size(); i++) {
				WebElement facet = driver
						.findElement(By.xpath("//div[@id='landing-filter']/div/div[2]/ul/li[" + i + "]/label/span/a"));
				// scrollIntoView(facet);
				click(facet, "selects shop by category");
				click(plp.getAppliedFacetClose(), "closes facet");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@And("^Verify Search Results$")
	public void searchResults() {
		try {

			// WebElement
			// result=driver.findElement(By.xpath("//span[@class='pagination-bar-results
			// items-found']"));
			if (plp.getpageBarResultTop().getAttribute("innerText").contains("Products found for")) {
			} else {
				soft.fail("Results are not found for search key");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^Verify Results Count$")
	public void searchCounts() {
		try {

			String resulttop = plp.getpageBarResultTop().getAttribute("innerText");// .replace(String.valueOf((char)
			// 160), "+");
			int totalcount = Integer.parseInt(resulttop.split(" ")[0]);
			if (totalcount >= 20) {
				if (plp.getProductValidation().size() == 20) {
				} else {
					soft.fail("20 results are not displayed on page");
				}
			} else {
				soft.fail("20 results are not displayed, change your serach key");
			}

		} catch (Exception e) {
			Assert.fail("error in searchCounts function");
		}
	}

	@And("^Verify Results Paginations$")
	public void pagenation() {
		try {

			String resulttop = plp.getpageBarResultTop().getAttribute("innerText");// .replace(String.valueOf((char)
			// 160), "+");
			int totalcount = Integer.parseInt(resulttop.split(" ")[0]);
			if (totalcount > 20) {
				int dispprodcount = plp.getProductValidation().size();
				int numpage = totalcount / 20;
				isElementPresent(plp.getpageNationBarBottom(), "Pagenation Bar");
				for (int i = 0; i < numpage; i++) {
					click(plp.getpageNationBarNext(), "Next Button");
					dispprodcount = dispprodcount + plp.getProductValidation().size();
				}

				if (totalcount == dispprodcount) {
				} else {
					soft.fail("displayed products count is mismatched with search bar key");
				}
				click(plp.getpageNationPrevious(), "Previous button");
			} else {
				soft.fail("20 results are not displayed, change your serach key");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Verify Default is RELEVANCE in Sort Type$")
	public void SortByRelevance(DataTable dt) {
		readData(dt);
		try {
			scrollIntoView(plp.getSelectSorting());
			Select dropdwn = new Select(plp.getSelectSorting());
			if (dropdwn.getFirstSelectedOption().getText().toString().contains("RELEVANCE")) {
			} else {
				soft.fail("RELEVANCE is not selected by default");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


/*	@Then("^Verify Price of Product in PLP$")
	public void PriceOfProductPLP() {
		try {

			scrollIntoView(plp.getProductPrice());
<<<<<<< HEAD
=======

>>>>>>> 1eeb542cd1752bfbbbc9f97157171e18683c82cc
			String priceValue =	plp.getProductPrice().getText().toString();
			if (RegistrationSteps.countryCode.contains("0091")
					&& (priceValue.contains("$"))) {

<<<<<<< HEAD

				click(plp.getProductListName(), "Product Decription");
=======
		{

>>>>>>> 1eeb542cd1752bfbbbc9f97157171e18683c82cc

				click(plp.getProductListName(), "Product Decription");

				Float pricePLP = Float
						.parseFloat(plp.getProductPrice().getAttribute("innerText").replace("$", "").replace(",", ""));
				envVariable.put("productPrice", pricePLP.toString());
				click(plp.getProductListName(), "Product Decription");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@And("^Validate the Currency Displayed is as per Country Code Selected$")
	public void PriceCountryCode() {
		String priceValue =	plp.getProductPrice().getText().toString();
		if (RegistrationSteps.countryCode.contains("0091")
				&& (priceValue.contains("$"))) {}
		
	}

	@Then("^Retrieve Price of Product in PLP$")
	public void PriceOfProduct_PLP() {
		try {

			Float pricePLP = Float
					.parseFloat(plp.getProductPrice().getAttribute("innerText").replace("$", "").replace(",", ""));
			envVariable.put("productPrice", pricePLP.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Verify if USD Available Add to Cart Should Displayed in PLP$")
	public void USDPriceinPLP() {
		try {

			scrollIntoView(plp.getProductListingPrice());
			if(plp.getProductPrice().getText().contains("$"))
				if(plp.getProductPrice().isDisplayed())
					isElementPresent(plp.getAddToCart(),"Add to Cart");
				else
					Assert.fail("Price or Add to Cart not Available");

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}

