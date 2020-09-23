package com.bgs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPopUPPage {

	WebDriver driver;

	public CartPopUPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='cboxTitle']/div/span")
	private WebElement itemaddedPopup;

	public WebElement getItemAddedPopup() {
		return itemaddedPopup;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add-to-cart-item col-sm-12']/div/a/img")
	private WebElement imageaddedinpopup;

	public WebElement getimageaddedinpopup() {
		return imageaddedinpopup;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='add-to-cart-item col-sm-12']/div[2]/div/a")
	private WebElement popupDescription;

	public WebElement getpopupDescription() {
		return popupDescription;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='add-to-cart-item col-sm-12']/div[2]/div/div")
	private WebElement popupQuantityaddded;

	public WebElement getpopupQuantityaddded() {
		return popupQuantityaddded;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='buttons col-sm-12']/a[2]")
	private WebElement continueShopping;

	public WebElement getcontinueShopping() {
		return continueShopping;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Check Out')]")
	private WebElement popUPcheckoutButton;

	public WebElement getpopUPcheckoutButton() {
		return popUPcheckoutButton;
	}
	@FindBy(how = How.XPATH, using = "//button[@id='cboxClose']")
	private WebElement popUPcloseButton;

	public WebElement getpopUPcloseButton() {
		return popUPcloseButton;
	}

	
}
