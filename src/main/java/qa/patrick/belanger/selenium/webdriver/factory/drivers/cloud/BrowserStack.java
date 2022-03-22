package qa.patrick.belanger.selenium.webdriver.factory.drivers.cloud;

import org.openqa.selenium.WebDriver;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.CloudBasedGrid;

public class BrowserStack extends CloudBasedGrid {

	public BrowserStack(Driver driver, GridThirdParty gridThirdParty) {
		super(driver, gridThirdParty);
	}
	
	@Override
	protected String getHostUrl() {
		return String.format(getGridThirdParty().getGridUrl(), "user", "password");
	}
	
	@Override
	public WebDriver getWebDriver() {
		return super.getWebDriver();
	}
	
}
