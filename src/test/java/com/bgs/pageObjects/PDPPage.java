package com.bgs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PDPPage {

	WebDriver driver;

	public PDPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Small Image */
	@FindBy(how = How.XPATH, using = "//div[@class='zoomImg']")
	private WebElement zoomImgage;

	public WebElement getZoomImgage() {
		return zoomImgage;
	}

	/* Big PDP Image */
	@FindBy(how = How.XPATH, using = "//img[@class='lazyOwl'][contains(@src,'.jpg')]")
	private WebElement PDPimage;

	public WebElement getProductImage() {
		return PDPimage;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='product-main-info']")
	private WebElement PDPInfo;

	public WebElement getPDPInfo() {
		return PDPInfo;
	}
	

	@FindBy(how = How.XPATH, using = "//div[@class='zoomImgMask']//img[1][contains(@src,'.jpg')]")
	private WebElement smallimage1;

	public WebElement getSmallImage1() {
		return smallimage1;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='zoomImgMask']//img[2][contains(@src,'.jpg')]")
	private WebElement smallimage2;

	public WebElement getSmallImage2() {
		return smallimage2;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='zoomImgMask']//img[3][contains(@src,'.jpg')]")
	private WebElement smallimage3;

	public WebElement getSmallImage3() {
		return smallimage3;
	}

	/* PDP Product Name */
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'product-name')]")
	private static WebElement PDPProductName;

	public WebElement getProductName() {
		return PDPProductName;
	}

	/* PDP id */
	@FindBy(how = How.XPATH, using = "//span[@class='ID']")
	private static WebElement PDPid;

	public WebElement getProductID() {
		return PDPid;
	}

	/* PDP Price */
	@FindBy(how = How.XPATH, using = "//p[@class='price']")
	private WebElement PDPPrice;

	public WebElement getPrice() {
		return PDPPrice;
	}

	/* PDP Description */
	@FindBy(how = How.XPATH, using = "//div[@class='description']")
	private WebElement PDPDescrition;

	public WebElement getDescription() {
		return PDPDescrition;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='configureProduct']")
	private WebElement configureProduct;

	public WebElement getConfigureProduct() {
		return configureProduct;
	}
	
	/* PDP Selector Quantity Minus */
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default js-qty-selector-minus']")
	private WebElement PDPSelQuantityMinus;

	public WebElement getSelQuantityMinus() {
		return PDPSelQuantityMinus;
	}

	/* PDP Selector Quantity plus */
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default js-qty-selector-plus']")
	private WebElement PDPSelQuantityPlus;

	public WebElement getSelQuantityPlus() {
		return PDPSelQuantityPlus;
	}

	/* PDP Quantity*/
	@FindBy(how = How.XPATH, using = "//input[@id='pdpAddtoCartInput']")
	private WebElement PDPQuantity;

	public WebElement getQuantity() {
		return PDPQuantity;
	}
	
	
	/* PDP Add to Cart */
	@FindBy(how = How.XPATH, using = "	//button[@id='addToCartButton']")
	private WebElement PDPAddToCart;

	public WebElement getAddToCart() {
		return PDPAddToCart;
	}
	/* Product List Cart Continue Shopping */
	@FindBy(how = How.XPATH, using = "//a[contains(text(),' CONTINUE SHOPPING')]")
	private WebElement cartContinueShopping;

	public WebElement getContinueShopping() {
		return cartContinueShopping;
	}

	/* Product pop List Cart Check out */
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Check Out')])[1]")
	private WebElement cartCheckoutButton;

	public WebElement getCheckoutButton() {
		return cartCheckoutButton;
	}

	/* PDP Product Details */
	@FindBy(how = How.XPATH, using = "//li[@id='accessibletabsnavigation0-0']")
	private WebElement PDPProductDetails;

	public WebElement getProductDetailsTab() {
		return PDPProductDetails;
	}

	/* PDP Spec product details, Manufacturer and unit of sale */
	@FindBy(how = How.XPATH, using = "//li[@id='accessibletabsnavigation0-1']")
	private WebElement PDPSpec;

	public WebElement getSpecTab() {
		return PDPSpec;
	}

	/* PDP Delivery */
	@FindBy(how = How.XPATH, using = "//li[@id='accessibletabsnavigation0-3']")
	private WebElement PDPDelivery;

	public WebElement getDeliveryTab() {
		return PDPDelivery;
	}

	/* PDP Support */
	@FindBy(how = How.XPATH, using = "//li[@id='accessibletabsnavigation0-2']")
	private WebElement PDPSupport;

	public WebElement getSupportTab() {
		return PDPSupport;
	}
		
			
}
