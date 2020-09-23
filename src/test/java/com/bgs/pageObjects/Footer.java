package com.bgs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Footer {

	WebDriver driver;

	public Footer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Shipping Rates & Methods']")
	private WebElement FootershippingRateMethod;

	public WebElement getFootershippingRateMethod() {
		return FootershippingRateMethod;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Payment Methods']")
	private WebElement footerpaymentMethod;

	public WebElement getfooterpaymentMethod() {
		return footerpaymentMethod;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Store FAQ']")
	private WebElement footerStoreFAQ;

	public WebElement getfooterStoreFAQ() {
		return footerStoreFAQ;
	}

	@FindBy(how = How.XPATH, using = "//li[@class='yCmsComponent list-group-item']//a[@title='Contact Us']")
	private WebElement groupItemContactUs;

	public WebElement getgroupItemContactUs() {
		return groupItemContactUs;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Returns and Cancellations Policy']")
	private WebElement footerReturnCancel;

	public WebElement getfooterReturnCancel() {
		return footerReturnCancel;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Order A Missing Revision Service']")
	private WebElement footerMRService;

	public WebElement getfooterMRService() {
		return footerMRService;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Pay Your Invoice']")
	private WebElement footerPYInvoice;

	public WebElement getfooterfooterPYInvoice() {
		return footerPYInvoice;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Terms Of Use']")
	private WebElement footerTermOfUse;

	public WebElement getfooterTermOfUse() {
		return footerTermOfUse;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Site Map']")
	private WebElement footerSiteMap;

	public WebElement getfooterSiteMap() {
		return footerSiteMap;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='terms']//a[@title='Contact Us']")
	private WebElement footerTermsContactUs;

	public WebElement getfooterTermsContactUs() {
		return footerTermsContactUs;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Privacy Policy']")
	private WebElement footerPrivayPolicy;

	public WebElement getfooterPrivayPolicy() {
		return footerPrivayPolicy;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Terms And Conditions Of Purchase']")
	private WebElement footerTermConditonPurchase;

	public WebElement getfooterTermConditonPurchase() {
		return footerTermConditonPurchase;
	}

}
