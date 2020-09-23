package com.bgs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PLPPage {

	WebDriver driver;

	public PLPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Search Results')]")
	private WebElement PLPPage;

	public WebElement getPLPPage() {
		return PLPPage;
	}

	@FindBy(how = How.XPATH, using = "(//div[@class='panel-body']/a/img)[1]")
	private WebElement productImage;

	public WebElement getProductImage() {
		return productImage;
	}
	

	@FindBy(how = How.XPATH, using = "(//div[@class='panel-body']/div/div/a)")
	private List<WebElement> productTitle;

	public List<WebElement> getProductTitle() {
		return productTitle;
	}

	@FindBy(how = How.XPATH, using = "(//div[@class='panel-body']/div/div[2]/div/div[1])")
	private WebElement productPrice;

	public WebElement getProductPrice() {
		return productPrice;
	}

	@FindBy(how = How.XPATH, using = "(//div[@class='panel-body']/div/div[2]/div/div[2])[1]")
	private WebElement backOrderTest;

	public WebElement getBackOrderTest() {
		return backOrderTest;
	}

	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Add to Cart')])[1]")
	private WebElement PLPaddToCart;

	public WebElement getAddToCart() {
		return PLPaddToCart;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='pagination-bar-results items-found']")
	private WebElement searchResults;

	public WebElement getSearchResults() {
		return searchResults;
	}

	@FindBy(how = How.XPATH, using = "(//ul/li/div/div/div/div[@class='product__list-product-code'])[1]")
	private WebElement productValidationScroll;

	public WebElement getProductValidationScroll() {
		return productValidationScroll;
	}

	@FindBy(how = How.XPATH, using = "//ul/li/div/div/div/div[@class='product__list-product-code']")
	private List<WebElement> productValidation;

	public List<WebElement> getProductValidation() {
		return productValidation;
	}
								
	/* Product List Name */
	@FindBy(how = How.XPATH, using = "//ul[@class='product__listing product__list']//li[1]//div[@class='content-container']//a")
	private WebElement produtlistname;

	public WebElement getProductListName() {
		return produtlistname;
	}

	/* Product List Price */
	@FindBy(how = How.XPATH, using = "//div[@class='product__listing--price price']")
	private WebElement produtlistingprice;

	public WebElement getProductListingPrice() {
		return produtlistingprice;
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='sortOptions1']")
	private WebElement selectSorting;

	public WebElement getSelectSorting() {
		return selectSorting;
	}
	
	@FindBy(how = How.XPATH, using = "(//ul[@class='pagination']/li[3]/a)[2]")
	private WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='selected-filter']/ul/li")
	private WebElement appliedFacet;

	public WebElement getAppliedFacet() {
		return appliedFacet;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='selected-filter']/ul/li/a/span")
	private WebElement appliedFacetClose;

	public WebElement getAppliedFacetClose() {
		return appliedFacetClose;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='pagination-bar bottom']")
	private WebElement pageNationBarBottom;

	public WebElement getpageNationBarBottom() {
		return pageNationBarBottom;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='pagination-bar bottom']//i[@class='material-icons arrow-next']")
	private WebElement pageNationBarNext;

	public WebElement getpageNationBarNext() {
		return pageNationBarNext;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pagination-bar bottom')]//i[contains(@class,'material-icons arrow-prev')]")
	private WebElement pageNationPrevious;

	public WebElement getpageNationPrevious() {
		return pageNationPrevious;
	}
	
	@FindBy(how = How.XPATH, using = "//span[@class='pagination-bar-results items-found']")
	private WebElement pageBarResultTop;

	public WebElement getpageBarResultTop() {
		return pageBarResultTop;
	}
	
}