package qa.patrick.belanger.selenium.webdriver.factory.drivers.cloud;

import java.net.MalformedURLException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;
import qa.patrick.belanger.selenium.webdriver.utils.Environment;

public class BrowserStack extends Browser {

	private static final String BROWSERSTACK_ACCESS_KEY = "BROWSERSTACK_ACCESS_KEY";
	private static final String BROWSERSTACK_USERNAME = "BROWSERSTACK_USERNAME";
	
	public BrowserStack() {
		super();
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		return null;
	}

	@Override
	public MutableCapabilities toCapabilities() {
		return getCapabilities();
	}

	protected String getHostUrl() {
		return String.format(getWebDriverProperties().getBrowserStackGridUrl(), 
		    Environment.getEnvironmentOrArgument(BROWSERSTACK_USERNAME, ARGUMENT_USERNAME),
		    Environment.getEnvironmentOrArgument(BROWSERSTACK_ACCESS_KEY, ARGUMENT_ACCESS_KEY)
	  );
	}
	
	/**
	 * Creates a new WebDriver (connected on BrowserStack hub) with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		throw new UnsupportedCommandException();
	}

	@Override
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		return super.getRemoteWebDriver(remote);
	}

}
