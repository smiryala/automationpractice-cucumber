package com.bgs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	WebDriver driver;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class='visible-sm visible-md visible-lg']")
	private WebElement welcomeDropdown ;

	public WebElement getwelcomeDropdown() {
		return welcomeDropdown;
	}
		
	@FindBy(how = How.XPATH, using = "//li[@class='dropdown-items']//a[@title='My Account'][contains(text(),'My Account')]")
	private WebElement myAccount ;

	public WebElement getmyAccount() {
		return myAccount;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Aircraft Details']")
	private WebElement aircraftDetails ;

	public WebElement getAircrafttDetails() {
		return aircraftDetails;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='add-aircraft-button']")
	private WebElement addNewAircraft ;

	public WebElement getaddNewAircraft() {
		return addNewAircraft;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='tailId']")
	private WebElement aircraftTailNo ;

	public WebElement getaircraftTailNo() {
		return aircraftTailNo;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='make']")
	private WebElement aircraftMake;

	public WebElement getaircraftMake() {
		return aircraftMake;
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='model']")
	private WebElement aircraftModel;

	public WebElement getaircraftModel() {
		return aircraftModel;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='serialNumber']")
	private WebElement aircraftserialno;

	public WebElement getaircraftserialno() {
		return aircraftserialno;
	}
		
	@FindBy(how = How.XPATH, using = "//input[@id='yearManufactured']")
	private WebElement aircraftYear;

	public WebElement getaircraftYear() {
		return aircraftYear;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='checkmark stay']")
	private WebElement purchaseTermcheckbox;

	public WebElement getPurchaseTermcheckbox() {
		return purchaseTermcheckbox;
	}

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary save-btn']")
	private WebElement aircraftDetailsSave;

	public WebElement getAircraftDetailsSave() {
		return aircraftDetailsSave;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Order History']")
	private WebElement orderHistory;

	public WebElement getOrderHistory() {
		return orderHistory;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='sort_title1']")
	private WebElement orderhistorysort;

	public WebElement getSortOrderHistory() {
		return orderhistorysort;
	}

	@FindBy(how = How.XPATH, using = "//table[@id='order_history_table']//td[3]")
	private List<WebElement> dateplacedlist;

	public List<WebElement> getDatePlacedList() {
		return dateplacedlist;
	}	
	
	@FindBy(how = How.XPATH, using = "//table[@id='order_history_table']//td[1]")
	private List<WebElement> ordernumlist;

	public List<WebElement> getOrderNumberList() {
		return ordernumlist;
	}	
	
		
	@FindBy(how = How.XPATH, using = "//tr[@class='account-orderhistory-table-head responsive-table-head hidden-xs']/th")
	private List<WebElement> tableheaders;

	public List<WebElement> getOrderHistoryTableHeaders() {
		return tableheaders;
	}
	
	@FindBy(how = How.XPATH, using = "//table[@id='order_history_table']/tbody/tr[1]/td[1]/a")
	private WebElement firstorder;

	public WebElement getFirstOrderInHistory() {
		return firstorder;
	}
	
	//Order Details
	@FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']//li[@class='active']")
	private WebElement ordernumberbread;

	public WebElement getOrderBreadCrum() {
		return ordernumberbread;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='order-number']")
	private WebElement ordernumber;

	public WebElement getOrderNumber() {
		return ordernumber;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='order-status']")
	private WebElement orderstatus;

	public WebElement getOrderStatus() {
		return orderstatus;
	}		
	
	@FindBy(how = How.XPATH, using = "//div[@class='order-date']")
	private WebElement orderdate;

	public WebElement getOrderDate() {
		return orderdate;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='order-shipping-address']")
	private WebElement ordershippingadd;

	public WebElement getOrderShippingAdd() {
		return ordershippingadd;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='order-shipping-method']")
	private WebElement ordershippingmethod;

	public WebElement getOrderShippingMethod() {
		return ordershippingmethod;
	}	

	@FindBy(how = How.XPATH, using = "//div[@class='order-submitter']")
	private WebElement ordplacedby;

	public WebElement getOrderPlacedBy() {
		return ordplacedby;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='order-item']")
	private WebElement ordereditems;

	public WebElement getOrderedItems() {
		return ordereditems;
	}	

	@FindBy(how = How.XPATH, using = "//div[@class='order-billing-address']")
	private WebElement ordbillingingadd;

	public WebElement getOrderBillingAdd() {
		return ordbillingingadd;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='order-payment-type']")
	private WebElement ordpaytype;

	public WebElement getOrderPayType() {
		return ordpaytype;
	}	
	
	@FindBy(how = How.XPATH, using = "//div[@class='order-price-details']//div[@class='price']")
	private List<WebElement> ordertotals;

	public List<WebElement> getOrderTotals() {
		return ordertotals;
	}	
	
	@FindBy(how = How.XPATH, using = "//div[@class='breadcrumb-section']//li")
	private List<WebElement> breadcrumbSection;

	public List<WebElement> getBreadCrumbSection() {
		return breadcrumbSection;
	}	
	
	@FindBy(how = How.XPATH, using = "(//ol[@class='breadcrumb']/li)[1]/a")
	private WebElement breadcrumbfirstelement;

	public WebElement getBreadCrumbFirstLink() {
		return breadcrumbfirstelement;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Account Details']")
	private WebElement accountDetails;

	public WebElement getAccountDetails() {
		return accountDetails;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Change Email']")
	private WebElement changeEmail;

	public WebElement getChangeEmail() {
		return changeEmail;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='profile.email']")
	private WebElement currentEmail;

	public WebElement getCurrentEmail() {
		return currentEmail;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='profile.newEmail']")
	private WebElement newEmail;

	public WebElement getNewEmail() {
		return newEmail;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='profile.confirmEmail']")
	private WebElement confirmEmail;

	public WebElement getConfirmEmail() {
		return confirmEmail;
	}

	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	private WebElement saveButton;

	public WebElement getSavebutton() {
		return saveButton;
	}

	@FindBy(how = How.XPATH, using = "//span[@id='newEmail.errors']")
	private WebElement newEmailError;

	public WebElement getNewEmailError() {
		return newEmailError;
	}

	@FindBy(how = How.XPATH, using = "//span[@id='confirmEmail.errors']")
	private WebElement confirmEmailError;

	public WebElement getConfirmEmailError() {
		return confirmEmailError;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='notice']")
	private WebElement globalError;

	public WebElement getGlobalError() {
		return globalError;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='profile.pwd']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-info alert-dismissable getAccAlert']")
	private WebElement changeEmailMsg;

	public WebElement getChangeEmailMsg() {
		return changeEmailMsg;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Change Password']")
	private WebElement changePassword;

	public WebElement getChangePassword() {
		return changePassword;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='My Devices']")
	private WebElement myDevices;

	public WebElement getMyDevices() {
		return myDevices;
	}
	@FindBy(how = How.XPATH, using = "//input[@id='accountName']")
	private WebElement accountDetailsCompanyName;

	public WebElement getAccountDetailsCompanyName() {
		return accountDetailsCompanyName;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='accountNumber']")
	private WebElement accountDetailsAccountNum;

	public WebElement getAccountDetailsAccountNum() {
		return accountDetailsAccountNum;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='countryCode']")
	private WebElement accountDetailsCountryCode;

	public WebElement getAccountDetailsCountrycode() {
		return accountDetailsCountryCode;
	}
	
	@FindBy(how = How.XPATH, using = "	//input[@id='areaCode']")
	private WebElement accountDetailsAreaCode;

	public WebElement getAccountDetailsAreacode() {
		return accountDetailsAreaCode;
	}
	
	@FindBy(how = How.XPATH, using = "	//input[@id='phoneNumber']")
	private WebElement accountDetailsPhoneNum;

	public WebElement getAccountDetailsPhoneNum() {
		return accountDetailsPhoneNum;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='extension']")
	private WebElement accountDetailsExtension;

	public WebElement getAccountDetailsExtension() {
		return accountDetailsAreaCode;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
	private WebElement accountDetailsCancel;

	public WebElement getCancel() {
		return accountDetailsCancel;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'btn btn-secondary')]")
	private WebElement aircraftAccountCancel;

	public WebElement getAircraftAccountCancel() {
		return aircraftAccountCancel;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='currentPassword']")
	private WebElement ChangePasswordCurrent;

	public WebElement getCurrentPassword() {
		return ChangePasswordCurrent;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='currentPassword']")
	private WebElement ChangeNewPassword;

	public WebElement getNewPassword() {
		return ChangeNewPassword;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='checkNewPassword']")
	private WebElement confirmNewPassword;

	public WebElement getConfirmPassword() {
		return confirmNewPassword;
	}
}
