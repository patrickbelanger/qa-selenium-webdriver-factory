package qa.patrick.belanger.selenium.webdriver.factory.drivers.cloud;

import java.net.MalformedURLException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;
import qa.patrick.belanger.selenium.webdriver.utils.Environment;

public class SauceLabs extends Browser {

	private static final String SAUCELAB_ACCESS_KEY = "SAUCELAB_ACCESS_KEY";
	private static final String SAUCELAB_USERNAME = "SAUCELAB_USERNAME";
	
	public SauceLabs() {
		super();
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		return null;
	}

	@Override
	public MutableCapabilities toCapabilities() {
		super.toCapabilities();
		getCapabilities().setCapability("username", Environment.getEnvironmentOrArgument(SAUCELAB_USERNAME, 
				ARGUMENT_USERNAME));
		getCapabilities().setCapability("accessKey", Environment.getEnvironmentOrArgument(SAUCELAB_ACCESS_KEY, 
				ARGUMENT_ACCESS_KEY));
		return getCapabilities();
	}

	protected String getHostUrl() {
		return String.format("");
	}
	
	/**
	 * Creates a new WebDriver (connected on SauceLabs hub) with the specified options.
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
