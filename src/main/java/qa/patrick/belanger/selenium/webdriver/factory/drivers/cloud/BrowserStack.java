package qa.patrick.belanger.selenium.webdriver.factory.drivers.cloud;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.CloudBasedGrid;

public class BrowserStack extends CloudBasedGrid {

	public BrowserStack(Driver driver) {
		super(driver, GridThirdParty.BROWSER_STACK);
	}

}
