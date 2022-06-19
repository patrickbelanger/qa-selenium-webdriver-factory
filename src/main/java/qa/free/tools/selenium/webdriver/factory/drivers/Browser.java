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

package qa.free.tools.selenium.webdriver.factory.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.webdriver.base.Driver;
import qa.free.tools.selenium.webdriver.exceptions.WebDriverNotSupportedException;
import qa.free.tools.selenium.webdriver.utils.OperatingSystem;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public abstract class Browser extends Grid {
	
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	Map<String, Object> w3cCapabilities;
	
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PUBLIC)
	Driver driver;
	
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	public MutableCapabilities options;
	
	protected Browser() { }
	
	protected Browser(Driver driver) {
		setDriver(driver);
		System.setProperty(driver.getProperty(), getWebDriverPath());
	}
	
	public abstract WebDriver getWebDriver();

	/**
	 * Creates a new RemoteWebDriver instance with specified options.
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	protected WebDriver getRemoteWebDriver() {
		try {
			RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(getHostUrl()), getOptions());
			if (isExecutionOnMac(remoteDriver) || getDriver().equals(Driver.FIREFOX)) {
				remoteDriver.manage().window().maximize(); // 
			}
			return remoteDriver;
		} catch(Exception e) {
			throw new WebDriverNotSupportedException(e.getLocalizedMessage());
		}
	}

	private boolean isExecutionOnMac(WebDriver webDriver) {
		return ((RemoteWebDriver) webDriver).getCapabilities()
				.getPlatformName().toString().equals("MAC");
	}
	
	/**
	 * Creates a new WebDriver instance with specified options.
	 * 
	 * @param remote Returns a RemoteDriver instance with the specified options
	 * @return {@link WebDriver}
	 */
	public WebDriver getWebDriver(boolean remote) {
		return remote ? getRemoteWebDriver() : getWebDriver();
	}

	private String getWebDriverPath() {
		if ((OperatingSystem.isExecutionHostWindows())
		    && (webDriverProperties.getWebDriverDefaultPath().contains("classpath"))) {
			return Browser.class.getClassLoader().getResource(getDriver().getExecutable()).getPath();
		} // Use defined path in .properties
		return String.format("%s%s",
		    OperatingSystem.isExecutionHostWindows() ? getWebDriverProperties().getWebDriverDefaultPath()
		        : getWebDriverProperties().getWebDriverDefaultUnixPath(),
		    getDriver().getExecutable());
	}

}
