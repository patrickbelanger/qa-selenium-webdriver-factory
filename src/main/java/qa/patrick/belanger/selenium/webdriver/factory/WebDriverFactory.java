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

package qa.patrick.belanger.selenium.webdriver.factory;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;
import qa.patrick.belanger.selenium.webdriver.properties.WebDriverProperties;

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
	 * Instantiate a WebDriver or RemoteWebDriver
	 * 
	 * @param driver {@link Driver} Launch the specified browser (locally) or on a Selenium Grid. 
	 * @param remote Return a RemoteWebDriver instance instead of a WebDriver object
	 * @return {@WebDriver}
	 */
	public static WebDriver getDriver(Enum<?> driver, boolean remote) {
		try {
			return instantiateWebDriver(driver, remote);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new WebDriverException(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Instantiate a WebDriver or RemoteWebDriver
	 * 
	 * @param driver {@link Driver} Launch the specified browser (locally), on a Selenium Grid or {@link GridThirdParty}
	 * 															third-party provider (like BrowserStack, Perfecto, SauceLab, and so on)
	 * @param capabilities {@link Capabilities} 
	 * @param remote Return a RemoteWebDriver instance instead of a WebDriver object
	 * @return {@WebDriver}
	 */
	public static WebDriver getDriver(Enum<?> driver, MutableCapabilities capabilities) {
		try {
			return instantiateWebDriver(driver, capabilities, true);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new WebDriverException(e.getLocalizedMessage());
		}
	}
	
	private static WebDriver instantiateWebDriver(Enum<?> driver, boolean remote) throws Exception {
		return instantiateWebDriver(driver, null, remote);
	}
	
	private static WebDriver instantiateWebDriver(Enum<?> driver, MutableCapabilities capabilities, boolean remote) 
			throws Exception {
		Browser browser = ((Browser) Class.forName(getDriverPackageName(driver)).getDeclaredConstructor().newInstance());
		if (capabilities != null) {
			browser.setCapabilities(capabilities);
		}
		return browser.getWebDriver(remote);
	}
	
	/**
	 * Returns the fully qualified package name of the Driver
	 * 
	 * @param driver {@link Driver}
	 * @return
	 */
	private static String getDriverPackageName(Enum<?> driver) {
		return String.format("%s%s", WebDriverFactory.class.getPackageName(), getDriverClassName(driver));
	}
	
	private static String getDriverClassName(Enum<?> driver) {
		try {
			return ((Driver) driver).getClassName();
		} catch(ClassCastException e) {
			return ((GridThirdParty) driver).getClassName();
		}
	}
}
