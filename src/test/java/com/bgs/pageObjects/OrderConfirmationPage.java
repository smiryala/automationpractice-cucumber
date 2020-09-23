package com.bgs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class OrderConfirmationPage {
 
	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//p[@class='checkout-success__body__order__number']//a")
	private WebElement ordernum;

	public WebElement getOrderNumber() {
		return ordernum;
	}	

	@FindBy(how = How.XPATH, using = "//div[@class='order-status']//p[@class='item-value']")
	private WebElement orderstatus;

	public WebElement getOrderStatus() {
		return orderstatus;
	}

	@FindBy(how = How.XPATH, using = "//footer[@id='page-footer']//a")
	private WebElement footerlinks;

	public WebElement getFooterLinks() {
		return footerlinks;
	}
	
	@FindBy(how = How.XPATH, using = "//nav[@class='main-menu']")
	private WebElement navbar;

	public WebElement getNavigationBar() {
		return navbar;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='order-ship-items']")
	private WebElement shippeditems;

	public WebElement getItemsShipped() {
		return shippeditems;
	}
	
	
//	'myaccount'
	//a[@title='Order History']
	//select[@id='sort_title1']
	//tr[@class='account-orderhistory-table-head responsive-table-head hidden-xs']
	
	
//	order details
	//ol[@class='breadcrumb']//li[@class='active']
	//h3[contains(text(),'Ship To')]
	//h3[contains(text(),'shippingMethod')]
	//div[@class='order-billing']
	//div[@class='order-details']
	
	
	
}
