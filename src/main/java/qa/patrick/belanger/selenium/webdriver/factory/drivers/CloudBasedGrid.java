package qa.patrick.belanger.selenium.webdriver.factory.drivers;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.exceptions.WebDriverNotSupportedException;

public abstract class CloudBasedGrid extends Browser {

	@Getter
	@Setter(AccessLevel.PRIVATE)
	GridThirdParty gridThirdParty;
	
	public CloudBasedGrid(Driver driver) {
		super(driver);
	}

	public CloudBasedGrid(Driver driver, GridThirdParty gridThirdParty) {
		super(driver);
		setGridThirdParty(gridThirdParty);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		return null;
	}
	
	/**
	 * Creates a new RemoteWebDriver instance with specified options.
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	private WebDriver getRemoteWebDriver() throws MalformedURLException {
		return null;
		//return new RemoteWebDriver(new URL(getHostUrl()), toCapabilities());
	}

	
	@Override
	public WebDriver getWebDriver() {
		try {
			return getRemoteWebDriver();
		} catch(MalformedURLException e) {
			throw new WebDriverNotSupportedException("MalformedURLException");
		}
	}
	
}
