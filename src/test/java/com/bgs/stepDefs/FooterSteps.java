package com.bgs.stepDefs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bgs.pageObjects.Footer;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.java.en.And;

public class FooterSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	Footer footer = new Footer(driver);

	@And("^Verify the Contents in the Footer$")
	public void FooterContents() {

		try {

			scrollIntoView(footer.getfooterTermOfUse());
			isElementPresent(footer.getFootershippingRateMethod(),"Shipping Rate and Method");
			isElementPresent(footer.getfooterpaymentMethod(),"Payment Method");
			isElementPresent(footer.getfooterStoreFAQ(),"Store FAQ");
			isElementPresent(footer.getgroupItemContactUs(),"GroupItem Contact Us");
			isElementPresent(footer.getfooterReturnCancel(),"Return and Cancellation");
			isElementPresent(footer.getfooterMRService(),"Order A Missing Revision Service");
			isElementPresent(footer.getfooterfooterPYInvoice(),"Pay Your Invoice");
			isElementPresent(footer.getfooterTermOfUse(),"Terms of Use");
			isElementPresent(footer.getfooterSiteMap(),"Site Map");
			isElementPresent(footer.getfooterTermsContactUs(),"Term Contact Us");
			isElementPresent(footer.getfooterPrivayPolicy(),"Privay Policy");
			isElementPresent(footer.getfooterTermConditonPurchase(),"Terms and Conditon of Purchase");

		} catch (Exception e){
			soft.fail("Footer Link are not Available");

		}	

	}

}


