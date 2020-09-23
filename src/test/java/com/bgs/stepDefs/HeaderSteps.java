package com.bgs.stepDefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bgs.pageObjects.Header;
import com.framework.library.Hooks;
import com.framework.utility.CommonFunctions;

import cucumber.api.java.en.Then;

public class HeaderSteps extends CommonFunctions {
	WebDriver driver = Hooks.getDriver();
	Header header = new Header(driver);


	@Then("^Verify GNB Tabs Which Visible Primary Categories$")
	public void GNBTabs() {
		try {

			hover(driver,header.getFlightOperationGNB());
			isElementPresent(header.getFlightOperationGNB(),"Flight Operation - GNB");
			isElementPresent(header.getchartFO(),"Flight Operation - Chart");
			isElementPresent(header.getAvionicsDataSolutionFO(),"Flight Operation - Avionics Data Solution");
			isElementPresent(header.getFlightPlanningFO(),"Flight Operation - Flight Planning");
			click(header.getFlightPlanningFO(),"primary link");
			hover(driver,header.getTrainingGNB());
			isElementPresent(header.getTrainingCategories(),"Training - Other Training Category");
			isElementPresent(header.getMaintenanceCourseware(),"Training - Maintenance Courseware");
			isElementPresent(header.getAviationReferenceTraining(),"Training - Aviation Reference Training ");
			isElementPresent(header.getAvionicsTraining(),"Training - Avionics Training");
			isElementPresent(header.getPilotTraining(),"Training - Pilot");
			hover(driver, header.getPilotSuppliesDropDown());
			isElementPresent(header.getBindersAccesoriesPS(),"Pilot Supplies - BinderAccesories");
			isElementPresent(header.getEquipmentHardwarePS(),"Pilot Supplies - Equipment Hardware");
			isElementPresent(header.getOtherPartsCategoriesPS(),"Pilot Supplies - Other Parts Categories");
			isElementPresent(header.getChartingPaperAccesoriesPS(),"Pilot Supplies - Charting paper Accesories");


		} catch (Exception e) {
			Assert.fail("GNB Primary category Navigation not available");
		}
	}

	@Then("^Hover the GNB$")
	public void NavigatePLP() {
		try {

			hover(driver, header.getPilotSuppliesDropDown());
			click(header.getPilotBagsGNB()," Navigate to GNB ");
		} catch (Exception e) {
			Assert.fail("GNB Navigation not available");
		}
	}



	@Then("^Verify all Links Clickable Except Current Page in GNB$")
	public void VerifyLinksInGNB() {
		try {
			List<WebElement> breadcrumbs = header.getBreadCrumbSection();
			for(int i=0;i<breadcrumbs.size()-1;i++) {
				isElementLink(breadcrumbs.get(i),breadcrumbs.get(i).getText());			
			}
			isElementNotLink(breadcrumbs.get(breadcrumbs.size()-1),breadcrumbs.get(breadcrumbs.size()-1).getText());

		} catch (Exception e) {
			Assert.fail("GNB Navigation not available");
		}
	}

	@Then("^Verify Links Navigation in Breadcrumb$")
	public void verify_bread_crumb_links() {
		try {
			List<WebElement> breadcrumbs = header.getBreadCrumbSection();
			for(int i=breadcrumbs.size()-1;i<1;i--) {
				String breadlink = breadcrumbs.get(i).getText();
				click(breadcrumbs.get(i),breadlink);	
				if(!header.getPageHeroHeading().getText().equalsIgnoreCase(breadlink))
					soft.fail("link is not navigated to the expected page: " + header.getPageHeroHeading().getText());
			}

		} catch (Exception e) {
			Assert.fail("Failure in Verify Links Navigation in Breadcrumb");
		}
	}

}




