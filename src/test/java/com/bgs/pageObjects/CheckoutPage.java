package com.bgs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/* Shipping Address Title */
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'1.Shipping Address')]")
	private WebElement shippingaddresstitle;

	public WebElement getShippingAddressTitle() {
		return shippingaddresstitle;
	}

	/* Shipping Address Country Name */
	@FindBy(how = How.XPATH, using = "//select[@name='countryIso']")
	private WebElement shippingaddresscountry;

	public WebElement getShippingAddressCountry() {
		return shippingaddresscountry;
	}

	/* Shipping Address First Name */
	@FindBy(how = How.XPATH, using = "//input[@id='address.firstName']")
	private WebElement shippingfirstname;

	public WebElement getShippingFirstName() {
		return shippingfirstname;
	}

	/* Shipping Address Last Name */
	@FindBy(how = How.XPATH, using = "//input[@id='address.surname']")
	private WebElement shippinglastname;

	public WebElement getShippingLastName() {
		return shippinglastname;
	}

	/* Shipping Address Line 1 */
	@FindBy(how = How.XPATH, using = "//input[@id='address.line1']")
	private WebElement shippingadd1;

	public WebElement getShippingAddressLine1() {
		return shippingadd1;
	}

	/* Shipping Address Line 2 Optional */
	@FindBy(how = How.XPATH, using = "//input[@id='address.line2']")
	private WebElement shippingadd2;

	public WebElement getShippingAddressLine2() {
		return shippingadd2;
	}

	/* Shipping Address Town/city */
	@FindBy(how = How.XPATH, using = "//input[@id='address.townCity']")
	private WebElement shippingaddcity;

	public WebElement getShippingAddressTownCity() {
		return shippingaddcity;
	}

	/* Shipping Address State */
	@FindBy(how = How.XPATH, using = "//select[@name='regionIso']")
	private WebElement shippingaddstate;

	public WebElement getShippingAddressState() {
		return shippingaddstate;
	}

	/* Shipping Address Post Code */
	@FindBy(how = How.XPATH, using = "//input[@id='address.postcode']")
	private WebElement shippingaddpostcode;

	public WebElement getShippingAddressPostCode() {
		return shippingaddpostcode;
	}

	/* Shipping Address CountryCode */
	@FindBy(how = How.XPATH, using = "	//input[@id='countryCode']")
	private WebElement shippingaddcountrycode;

	public WebElement getShippingAddressCountryCode() {
		return shippingaddcountrycode;
	}

	/* Shipping Address Area Code */
	@FindBy(how = How.XPATH, using = "//input[@id='areaCode']")
	private WebElement shippingaddareacode;

	public WebElement getShippingAddressAreaCode() {
		return shippingaddareacode;
	}

	/* Shipping Address Phone Number  */
	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	private WebElement shippingaddphone;

	public WebElement getShippingAddressPhoneNumber() {
		return shippingaddphone;
	}

	/* Shipping Address Extension  */
	@FindBy(how = How.XPATH, using = "//input[@id='extension']")
	private WebElement shippingaddextension;

	public WebElement getShippingAddressExtension() {
		return shippingaddextension;
	}


	/* Shipping Details Next Button */
	@FindBy(how = How.XPATH, using = "//form[@id='selectDeliveryMethodForm']//button[@id='deliveryMethodSubmit']")
	private WebElement ShippingDetailsNextButton;

	public WebElement getShippingDetailsNextButton() {
		return ShippingDetailsNextButton;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='addressSubmit']")
	private WebElement shippingaddnext;

	public WebElement getShippingAddressNextButton() {
		return shippingaddnext;

	}

	/* Shipping payment and details Next Button */
	@FindBy(how = How.XPATH, using = "//button[@id='choosePaymentType_continue_button']")
	private WebElement ShippingPaymentDetailsNextButton;

	public WebElement getShippingPaymentDetailsNextButton() {
		return ShippingPaymentDetailsNextButton;
	}

	/* Shipping Address Edit link */
	@FindBy(how = How.XPATH, using = "//div[@class='edit']")
	private WebElement shippingaddressedit;

	public WebElement getShipppingAddressEdit() {
		return shippingaddressedit;
	}

	/* Shipping Address Book */
	@FindBy(how = How.XPATH, using = "//input[@value='Address Book']")
	private WebElement shippingaddressbook;

	public WebElement getShipppingAddressBook() {
		return shippingaddressbook;
	}

	/* Shipping Details */
	@FindBy(how = How.XPATH, using = "//label[@class='select-dropdown']//select[@id='delivery_method']")
	private WebElement shippingdetails;

	public WebElement getShipppingDetails() {
		return shippingdetails;
	}

	/* Shipping Details Next Button */
	@FindBy(how = How.XPATH, using = "//button[@id='deliveryMethodSubmit']")
	private WebElement shippingdetailsnextbutton;

	public WebElement getShipppingDetailsNextButton() {
		return shippingdetailsnextbutton;
	}

	/* Payment and Billing Address - Account Payment check box */
	@FindBy(how = How.XPATH, using = "//label[@class='radio-button-container account-payment-select']")
	private WebElement paymentbillingcheckbox;

	public WebElement getPaymentBillingCheckbox() {
		return paymentbillingcheckbox;
	}

	/* Payment and Billing Address - Account Payment Next Button */
	@FindBy(how = How.XPATH, using = "//button[@id='choosePaymentType_continue_button']")
	private WebElement paymentbillingnextbutton;

	public WebElement getPaymentBillingNextButton() {
		return paymentbillingnextbutton;
	}

	@FindBy(how = How.XPATH, using = "//label[contains(@class,'radio-button-container account-payment-select')]")
	private WebElement accountpayradio;

	public WebElement getAccountPayRadio() {
		return accountpayradio;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='radio-checkmark stay']")
	private WebElement payinfocc;

	public WebElement getpaymentInfoCreditCard() {
		return payinfocc;
	}


	/* Payment and Billing Address - Purchase Order Number */
	@FindBy(how = How.XPATH, using = "//input[@name='purchaseOrderNumber']")
	private WebElement paymentponumber;

	public WebElement getPaymentBillingPONumber() {
		return paymentponumber;
	}

	/* Final Review term check box */
	@FindBy(how = How.XPATH, using = "//span[@class='checkmark stay']")
	private WebElement finalreviewcheckbox;

	public WebElement getFinalReviewTermCheckbox() {
		return finalreviewcheckbox;
	}

	/* Final Review sub Total*/
	@FindBy(how = How.XPATH, using = "//div[@class='subtotal']//span")
	private WebElement finalreviewsubtot;

	public WebElement getFinalReviewSubTotal() {
		return finalreviewsubtot;
	}

	/* Final Review Delivery*/
	@FindBy(how = How.XPATH, using = "//div[@class='finalShipping']//span")
	private WebElement finaldeliveryamt;

	public WebElement getFinalShipppingDeliveryAmount() {
		return finaldeliveryamt;
	}

	/* Final Review Place Order*/
	@FindBy(how = How.XPATH, using = "//button[@id='placeOrder']")
	private WebElement finalreviewplaceorder;

	public WebElement getFinalReviewPlaceOrder() {
		return finalreviewplaceorder;
	}

	@FindBy(how = How.XPATH, using = "//h2[@class='checkout-success__body__headline']")
	private WebElement placeOrderConfirmation;

	public WebElement getPlaceOrderConfirmation() {
		return placeOrderConfirmation;
	}


	/* Mandatory Fields Validations for Shipping Address*/


	@FindBy(how = How.XPATH, using = "//span[@id='firstName.errors']")
	private WebElement firstNameErrorMessage;

	public WebElement getfirstNameErrorMessage() {
		return firstNameErrorMessage;
	}

	@FindBy(how = How.XPATH, using = "//span[@id='lastName.errors']")
	private WebElement lastNameErrorMessage;

	public WebElement getlastNameErrorMessage() {
		return lastNameErrorMessage;
	}	


	@FindBy(how = How.XPATH, using = "//span[@id='line1.errors']")
	private WebElement addressLine1ErrorMessage;

	public WebElement getaddressLine1ErrorMessage() {
		return addressLine1ErrorMessage;
	}	


	@FindBy(how = How.XPATH, using = "	//span[@id='townCity.errors']")
	private WebElement addressTownCityErrorMessage;

	public WebElement getaddressTownCityErrorMessage() {
		return addressTownCityErrorMessage;
	}


	@FindBy(how = How.XPATH, using = "//span[@id='regionIso.errors']")
	private WebElement addressStateErrorMessage;

	public WebElement getaddressStateErrorMessage() {
		return addressStateErrorMessage;
	}


	@FindBy(how = How.XPATH, using = "	//span[@id='postcode.errors']")
	private WebElement addressZipPostCodeErrorMessage;

	public WebElement getaddressZipPostCodeErrorMessage() {
		return addressZipPostCodeErrorMessage;
	}

	@FindBy(how = How.XPATH, using ="//span[@id='countryCode.errors']")
	private WebElement addresscountryCodeErrorMessage;

	public WebElement getaddresscountryCodeErrorMessage() {
		return addresscountryCodeErrorMessage;
	}


	@FindBy(how = How.XPATH, using = "//span[@id='areaCode.errors']")
	private WebElement addressAreaCodeErrorMessage;

	public WebElement getaddressAreaCodeErrorMessage() {
		return addressAreaCodeErrorMessage;
	}


	@FindBy(how = How.XPATH, using = "//span[@id='phone.errors']")
	private WebElement addressPhoneNumberErrorMessage;

	public WebElement getaddressPhoneNumberErrorMessage() {
		return addressPhoneNumberErrorMessage;
	}

	
	@FindBy(how = How.XPATH, using = "	//span[@id='countryIso.errors']")
	private WebElement countryErrorMessage;

	public WebElement getcountryErrorMessage() {
		return countryErrorMessage;
	}

	@FindBy(how = How.XPATH, using = "//label[contains(@class,'radio-button-container credit-card-select')]")
	private WebElement ccradio;

	public WebElement getCreditCardRadio() {
		return ccradio;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='c-cardname']")
	private WebElement ccname;

	public WebElement getCCNameOnCard() {
		return ccname;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='c-cardnumber']")
	private WebElement ccnum;

	public WebElement getCCNumber() {
		return ccnum;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='c-exmth']")
	private WebElement ccexpmonth;

	public WebElement getCCExpMonth() {
		return ccexpmonth;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='c-exyr']")
	private WebElement ccexpyear;

	public WebElement getCCExpYear() {
		return ccexpyear;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='c-cvv']")
	private WebElement cccvv;

	public WebElement getCCCVV() {
		return cccvv;
	}
	
	//iframe[@id='xieCommFrame']
	@FindBy(how = How.XPATH, using = "//div[@id='c-cardname-error']")
	private WebElement ccnameerror;

	public WebElement getCCInvalidNameError() {
		return ccnameerror;
	}	
	
	@FindBy(how = How.XPATH, using = "//div[@id='c-cardnumber-error']")
	private WebElement cccarderror;

	public WebElement getCCInvalidCardError() {
		return cccarderror;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='c-exyr-error']")
	private WebElement ccexperror;

	public WebElement getCCInvalidExpDateError() {
		return ccexperror;
	}	

	@FindBy(how = How.XPATH, using = "//div[@id='c-cvv-error']")
	private WebElement cccvverror;

	public WebElement getCCInvalidCVVError() {
		return cccvverror;
	}	
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Replace Address')])[1]")
	private WebElement replaceaddress;

	public WebElement getReplaceAddress() {
		return replaceaddress;
	}	
	
		
	@FindBy(how = How.XPATH, using = "//div[@class='totals']//span")
	private WebElement shipTotal;

	public WebElement getShipTotal() {
		return shipTotal;
	}	
	
	@FindBy(how = How.XPATH, using = "//div[@class='step-body']//div[contains(@class,'subtotals')]/div")
	private List<WebElement> orderTotals;

	public List<WebElement> getOrderTotals() {
		return orderTotals;
	}
}


