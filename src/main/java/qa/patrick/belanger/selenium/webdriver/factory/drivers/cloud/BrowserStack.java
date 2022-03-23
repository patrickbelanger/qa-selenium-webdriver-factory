package qa.patrick.belanger.selenium.webdriver.factory.drivers.cloud;

import org.openqa.selenium.WebDriver;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.exceptions.CredentialException;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.CloudBasedGrid;
import qa.patrick.belanger.selenium.webdriver.utils.Environment;

public class BrowserStack extends CloudBasedGrid {

	final String ENVIRONMENT_USERNAME = "BROWSERSTACK_USERNAME";
	final String ENVIRONMENT_ACCESS_KEY = "BROWSERSTACK_ACCESS_KEY";
	final String JRE_ARGUMENT_USERNAME = "username";
	final String JRE_ARGUMENT_ACCESS_TOKEN = "accessToken";
	
	
	public BrowserStack(Driver driver, GridThirdParty gridThirdParty) {
		super(driver, gridThirdParty);
		try {
			setUsername(Environment.getEnvironmentOrArgument(ENVIRONMENT_USERNAME, JRE_ARGUMENT_USERNAME));
			setAccessToken(Environment.getEnvironmentOrArgument(ENVIRONMENT_ACCESS_KEY, JRE_ARGUMENT_ACCESS_TOKEN));
		} catch(Exception e) {
			throw new CredentialException("Missing credential information");
		}
	}
	
	@Override
	protected String getHostUrl() {
		return String.format(getGridThirdParty().getGridUrl(), getUsername(), getAccessToken());
	}
	
	@Override
	public WebDriver getWebDriver() {
		return super.getWebDriver();
	}
	
}
