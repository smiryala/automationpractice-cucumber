package com.bgs.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* AddToCartPDP Continue Shopping */
	@FindBy(how = How.XPATH, using = "//a[@class='button-secondary']")
	private WebElement continueShopping;

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	/* AddToCart remove */
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'hidden-xs')][contains(text(),'REMOVE')]")
	private WebElement removebutton;

	public WebElement getRemove() {
		return removebutton;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'alert alert-info alert-dismissable getAccAlert')]")
	private WebElement alertmessage;

	public WebElement getAlertMessage() {
		return alertmessage;
	}
	
	/* MY Cart Quantity */
	@FindBy(how = How.XPATH, using = "(//input[@name='quantity'])[1]")
	private WebElement cartquantity;

	public WebElement getCartQuanity() {
		return cartquantity;
	}

		/* MY Cart Item Price */
	@FindBy(how = How.XPATH, using = "(//div[@class='item__list-body']//div[@class='item__price'])[1]")
	private WebElement cartitemprice1;

	public WebElement getCartItemPrice1() {
		return cartitemprice1;
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='item__list-middle']/div[@class='item__price']/span)[2]")
	private WebElement cartItemprice2;

	public WebElement getCartItemPrice2() {
		return cartItemprice2;
	}
		
	/* Cart item price all total  */
	@FindBy(how = How.XPATH, using = "//div[@class='item__total js-item-total']")
	private List<WebElement> CartItemAllPrice;
	
	public List<WebElement> getCartItemAllPrice() {
		return CartItemAllPrice;
	}
		
		
	/* MY Cart Item Name */
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'item__name')]")
	private WebElement cartitemname;

	public WebElement getCartItemName() {
		return cartitemname;
	}

	/* MY Cart Item Total 1 */
	@FindBy(how = How.XPATH, using = "(//div[@class='item__list-right']/div[contains(@class,'item__total')])[1]")
	private WebElement cartItemtotal1;

	public WebElement getCartItemTotal1() {
		return cartItemtotal1;
	}
	
	/* MY Cart Item Total 2 */
	@FindBy(how = How.XPATH, using = "(//div[@class='item__list-right']/div[contains(@class,'item__total')])[2]")
	private WebElement cartItemtotal2;

	public WebElement getCartItemTotal2() {
		return cartItemtotal2;
	}
		

	@FindBy(how = How.XPATH, using = "//div[@class='cart-amount cart-total__final']")
	private WebElement cartTotalFinal;

	public WebElement getCartTotalFinal() {
		return cartTotalFinal;
	}
	
	
	@FindBy(how = How.XPATH, using = "(//div[@class='cart-amount'])[1]")
	private WebElement cartSubTotal;

	public WebElement getCartSubTotal() {
		return cartSubTotal;
	}
			
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Check Out')])[1]")
	private WebElement cartcheckout;

	public WebElement getCheckOut() {
		return cartcheckout;
	}
		
	/* MY Cart Item Code */
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'item__code')]")
	private WebElement cartitemcode;

	public WebElement getCartItemCode() {
		return cartitemcode;
	}
		
	@FindBy(how = How.XPATH, using = "//div[@class='item__total js-item-total']//div[@class='price']")
	private List<WebElement> individualitemtotals;

	public List<WebElement> getItemTotals() {
		return individualitemtotals;
	}

	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'alert-warning')]")
	private WebElement alertWarning;

	public WebElement getAlertWarningValidation() {
		return alertWarning;
	}


	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Your cart is empty')]")
	private WebElement emptycartmsg;

	public WebElement getEmptyCartMsg() {
		return emptycartmsg;
	}	
	
	@FindBy(how = How.XPATH, using = "//i[@id='cart-icon']")
	private WebElement carticon;

	public WebElement getCartIcon() {
		return carticon;
	}
	

}
