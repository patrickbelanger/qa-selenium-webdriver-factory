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

package qa.patrick.belanger.selenium.webdriver.factory.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.properties.WebDriverProperties;
import qa.patrick.belanger.selenium.webdriver.utils.OperatingSystem;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public abstract class Browser {

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	DesiredCapabilities capabilities;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PRIVATE)
	Driver driver;
	
	@Getter(AccessLevel.PROTECTED)
	WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);
	
	public Browser(Driver driver) {
		setDriver(driver);
		System.setProperty(driver.getProperty(), getWebDriverPath());
	}
	
	public abstract AbstractDriverOptions<?> getOptions();
	
	public abstract WebDriver getWebDriver();
	
	private String getHostUrl() {
		return String.format("%s:%s%s", getWebDriverProperties().getGridUrl(), 
				getWebDriverProperties().getGridPort(), WebDriverProperties.GRID_HUB_ENDPOINT);
	}
	
	private WebDriver getRemoteDriver() throws MalformedURLException {
		return new RemoteWebDriver(new URL(getHostUrl()), toCapabilities());
	}
	
	/**
	 * Creates a new WebDriver instance with specified options.
	 * @param remote Returns a RemoteDriver instance with the specified options
	 * @return {@link WebDriver}
	 * @throws MalformedURLException
	 */
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		return remote ? getRemoteDriver() : getWebDriver();
	}
	
	private String getWebDriverPath() {
		if ((OperatingSystem.isExecutionHostWindows()) && 
				(webDriverProperties.getWebDriverDefaultPath().contains("classpath"))) {
				return Browser.class.getClassLoader().getResource(getDriver().getExecutable()).getPath();
			} // Use defined path in .properties
			return String.format("%s%s", OperatingSystem.isExecutionHostWindows() ?
					webDriverProperties.getWebDriverDefaultPath() : WebDriverProperties.UNIX_WEBDRIVER_PATH, 
					getDriver().getExecutable());
	}
	
	protected Capabilities toCapabilities() {
		setCapabilities(new DesiredCapabilities());
		return getCapabilities();
	}
	 
}
