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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.CloudBasedGrid;
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
	 * @param driver {@link Driver} Launch the specified Browser/Platform
	 * @param remote Return a RemoteWebDriver instance instead of a WebDriver object
	 * @return {@WebDriver}
	 */
	public static WebDriver getDriver(Driver driver, boolean remote) {
		try {
			return instantiateWebDriver(driver, remote);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new WebDriverException(e.getLocalizedMessage());
		}
	}
	
	private static GridThirdParty getGridThirdParty() {
		return getWebDriverProperties().getGridThidParty();
	}
	
	private static boolean isCloudBasedGrid(boolean remote) {
		return remote && !getWebDriverProperties().getGridThidParty().equals(GridThirdParty.SELENIUM_GRID);
	}
	
	private static WebDriver instantiateWebDriver(Driver driver, boolean remote) throws Exception {
		if (isCloudBasedGrid(remote)) {
			return ((CloudBasedGrid) Class.forName(getGridThirdPartyPackageName(getGridThirdParty()))
					.getDeclaredConstructor(Driver.class, GridThirdParty.class)
					.newInstance(new Object[] { driver, getGridThirdParty() })).getWebDriver();
		}
		return ((Browser) Class.forName(getDriverPackageName(driver)).getDeclaredConstructor().newInstance())
		    .getWebDriver(remote);
	}
	
	/**
	 * Returns the fully qualified package name of the Grid Third Party
	 * 
	 * @param driver {@link GridThirdParty}
	 * @return
	 */
	private static String getGridThirdPartyPackageName(GridThirdParty gridThirdParty) {
		return String.format("%s%s", WebDriverFactory.class.getPackageName(), gridThirdParty.getClassName());
	}
	
	/**
	 * Returns the fully qualified package name of the Driver
	 * 
	 * @param driver {@link Driver}
	 * @return
	 */
	private static String getDriverPackageName(Driver driver) {
		return String.format("%s%s", WebDriverFactory.class.getPackageName(), driver.getClassName());
	}
	
}
