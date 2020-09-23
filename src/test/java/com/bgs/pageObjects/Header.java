package com.bgs.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Header {

	WebDriver driver;
	public Header(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[@data-toggle='dropdown']//a[@title='Flight Operations']")
	private WebElement flightOperationGNB;

	public WebElement getFlightOperationGNB() {
		return flightOperationGNB;
	}

	@FindBy(how = How.XPATH, using = "//span[@data-toggle='dropdown']//a[@title='Training']")
	private WebElement trainingGNB;

	public WebElement getTrainingGNB() {
		return trainingGNB;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Other solution categories']")
	private WebElement solutionCategories;

	public WebElement getsolutionCategoriesGNB() {
		return solutionCategories;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Charts']")
	private WebElement chartFO;

	public WebElement getchartFO() {
		return chartFO;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Avionics Data & Solution']")
	private WebElement avionicsDataSolutionFO;

	public WebElement getAvionicsDataSolutionFO() {
		return avionicsDataSolutionFO;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Flight Planning']")
	private WebElement flightPlanningFO;

	public WebElement getFlightPlanningFO() {
		return flightPlanningFO;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Other training categories']")
	private WebElement trainingCategories;

	public WebElement getTrainingCategories() {
		return trainingCategories;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Maintenance courseware']")
	private WebElement maintenanceCourseware;

	public WebElement getMaintenanceCourseware() {
		return maintenanceCourseware;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Aviation reference']")
	private WebElement aviationReference;

	public WebElement getAviationReferenceTraining() {
		return aviationReference;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Avionics training']")
	private WebElement avionicsTraining;

	public WebElement getAvionicsTraining() {
		return avionicsTraining;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Pilot']")
	private WebElement pilotTraining;

	public WebElement getPilotTraining() {
		return pilotTraining;
	}

	@FindBy(how = How.XPATH, using = "	//a[@title='Binders & Accessories']")
	private WebElement bindersAccesoriesPS;

	public WebElement getBindersAccesoriesPS() {
		return bindersAccesoriesPS;
	}

	@FindBy(how = How.XPATH, using = "//a[@title=\"Navigation Equipment / Hardware\"]")
	private WebElement equipmentHardwarePS;

	public WebElement getEquipmentHardwarePS() {
		return equipmentHardwarePS;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Other parts categories']")
	private WebElement otherPartsCategoriesPS;

	public WebElement getOtherPartsCategoriesPS() {
		return otherPartsCategoriesPS;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Charting Paper & Accessories']")
	private WebElement chartingPaperAccesoriesPS;

	public WebElement getChartingPaperAccesoriesPS() {
		return chartingPaperAccesoriesPS;
	}
	@FindBy(how = How.XPATH, using = "//span[@data-toggle='dropdown']//a[@title='Pilot Supplies']")
	private WebElement pilotSupplies;

	public WebElement getPilotSuppliesDropDown() {
		return pilotSupplies;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Pilot Bags']")
	private WebElement pilotBagsGNB;

	public WebElement getPilotBagsGNB() {
		return pilotBagsGNB;
	}	

	@FindBy(how = How.XPATH, using = "//div[@class='breadcrumb-section']//li")
	private List<WebElement> breadcrumbSection;

	public List<WebElement> getBreadCrumbSection() {
		return breadcrumbSection;
	}

	@FindBy(how = How.XPATH, using = "//p[contains(@class,'hero-heading')]")
	private WebElement heroheading;

	public WebElement getPageHeroHeading() {
		return heroheading;
	}

}
