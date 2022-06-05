// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package qa.free.tools.selenium.webdriver.factory;

import java.util.Map;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import qa.free.tools.selenium.webdriver.base.Driver;
import qa.free.tools.selenium.webdriver.base.GridThirdParty;
import qa.free.tools.selenium.webdriver.exceptions.UnableInstantiateWebDriverException;
import qa.free.tools.selenium.webdriver.factory.drivers.Browser;
import qa.free.tools.selenium.webdriver.factory.drivers.options.DefaultOptions;
import qa.free.tools.selenium.webdriver.properties.WebDriverProperties;

/**
 * WebDriverFactory
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class WebDriverFactory {

	@Getter(AccessLevel.PRIVATE)
	final static Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
	
	@Getter(AccessLevel.PRIVATE)
	final static WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);
	
	private WebDriverFactory() { }

  /**
   * Get default browser options based on the specified driver
   * 
   * @param driver {@link Driver}
   * @return
   */
	public static MutableCapabilities getDefaultBrowserOptions(Driver driver) {
		try {
			return ((DefaultOptions) 
					Class.forName(getOptionsPackageName(driver)).getDeclaredConstructor().newInstance()).getOptions();
		} catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new WebDriverException(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Instantiate a WebDriver or RemoteWebDriver
	 * 
	 * @param driver {@link Driver} Launch the specified browser (locally) or on a Selenium Grid. 
	 * @param remote Return a RemoteWebDriver instance instead of a local WebDriver object
	 * @return {@WebDriver}
	 */
	public static WebDriver getDriver(Driver driver, boolean remote) {
		try {
			return instantiateWebDriver(driver, remote);
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			throw new UnableInstantiateWebDriverException(e.getCause().getMessage());
		}
	}
	
	/**
	 * Instantiate a WebDriver or RemoteWebDriver
	 * 
	 * @param driver {@link Driver} 
	 * 				Launch the specified browser (locally), on a Selenium Grid or {@link GridThirdParty}
	 * 				third-party provider (like BrowserStack)
	 * @param gridPartyParty {@link GridThirdParty} 
	 * 				Specify a grid third-party provider (such as BrowserStack or Sauce Labs)
	 * @param w3cCapabilities 
	 * 				Browser/Cloud capability (using the W3C standards)
	 * 				Read: https://www.selenium.dev/blog/2022/legacy-protocol-support/ 
	 * @param remote Return a RemoteWebDriver instance instead of a WebDriver object
	 * @return {@WebDriver}
	 */
	public static WebDriver getDriver(Driver driver, GridThirdParty gridThirdParty, Map<String, Object> w3cCapabilities) {
		try {
			return instantiateWebDriver(driver, gridThirdParty, w3cCapabilities, null, true);
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			throw new UnableInstantiateWebDriverException(e.getCause().getMessage());
		}
	}
	
	/**
	 * Instantiate a WebDriver or RemoteWebDriver
	 * 
	 * @param driver {@link Driver} 
	 * 				Launch the specified browser (locally), on a Selenium Grid or {@link GridThirdParty}
	 * 				third-party provider (Sauce Labs)
	 * @param gridPartyParty {@link GridThirdParty} 
	 * 				Specify a grid third-party provider (such as BrowserStack or Sauce Labs)
	 * @param w3cCapabilities 
	 * 				Browser/Cloud capability (using the W3C standards)
	 * 				Read: https://www.selenium.dev/blog/2022/legacy-protocol-support/
	 * @param  MutableCapabilities browserOptions 
	 * 				Browser Options (like {@link ChromeOptions} and so on). You can use
	 * 				{@link WebDriverFactory#getDefaultBrowserOptions()} method to get the proper instance
	 * 				by passing the wanted {@link Driver}.
	 * @param remote Return a RemoteWebDriver instance instead of a WebDriver object
	 * @return {@WebDriver}
	 */
	public static WebDriver getDriver(Driver driver, GridThirdParty gridThirdParty, 
				Map<String, Object> w3cCapabilities, MutableCapabilities browserOptions) {
		try {
			return instantiateWebDriver(driver, gridThirdParty, w3cCapabilities, browserOptions, true);
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			throw new UnableInstantiateWebDriverException(e.getCause().getMessage());
		}
	}
	
	private static WebDriver instantiateWebDriver(Enum<?> driver, boolean remote) throws Exception {
		return instantiateWebDriver(null, driver, null, null, remote);
	}
	
	private static WebDriver instantiateWebDriver(Driver driver, Enum<?> driverOrThirdParty, 
			Map<String, Object> w3cCapabilities, MutableCapabilities browserOptions, boolean remote) 
			throws Exception {
		Browser browser = 
				((Browser) Class.forName(getDriverPackageName(driverOrThirdParty)).getDeclaredConstructor().newInstance());
		if (w3cCapabilities != null) {
			browser.setW3cCapabilities(w3cCapabilities);
		}
		if (browserOptions != null) {
			browser.setOptions(browserOptions);
		}
		if (driver != null) {
			browser.setDriver(driver);
		}
		return browser.getWebDriver(remote);
	}
	
	private static String getDriverPackageName(Enum<?> driver) {
		return String.format("%s%s", WebDriverFactory.class.getPackageName(), getDriverClassName(driver));
	}
	
	private static String getOptionsPackageName(Driver driver) {
		return String.format("%s%sDefaultOptions", WebDriverFactory.class.getPackageName(), driver.getOptionsClassName());
	}
	
	private static String getDriverClassName(Enum<?> driver) {
		try {
			return ((Driver) driver).getClassName();
		} catch(ClassCastException e) {
			return ((GridThirdParty) driver).getClassName();
		}
	}
}
