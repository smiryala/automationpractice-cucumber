package com.bgs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ConfigPage {
	
	WebDriver driver;

	public ConfigPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='aircraft']")
	private WebElement aircraft;

	public WebElement getAircraft() {
		return aircraft;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='avionics']")
	private WebElement avionics;

	public WebElement getAvionics() {
		return avionics;
	}
	@FindBy(how = How.XPATH, using = "//select[@id='coverages']")
	private WebElement coverages;

	public WebElement getCoverages() {
		return coverages;
	}
	@FindBy(how = How.XPATH, using = "//h2[text()='Aircraft']")
	private WebElement configPage;

	public WebElement getConfigPage() {
		return configPage;
	}
	@FindBy(how = How.XPATH, using = "(//div[@class=\"radio-container\"]/label)[1]")
	private WebElement services;

	public WebElement getServices() {
		return services;
	}

	@FindBy(how = How.XPATH, using = "//div[@class=\"price\"]/div[2]")
	private WebElement configPrice ;

	public WebElement getConfigPrice () {
		return configPrice;
	}

	@FindBy(how = How.XPATH, using = "//button[@id=\"addToCartButton\"]")
	private WebElement configAddtoCart ;

	public WebElement getConfigAddtoCart () {
		return configAddtoCart;
	}

		
}
