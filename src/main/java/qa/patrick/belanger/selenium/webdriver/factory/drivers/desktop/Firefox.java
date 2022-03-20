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

package qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.base.Driver;

/**
 * Firefox Browser class 
 * Returns a FirefoxDriver/RemoteWebDriver
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Firefox extends GeckoBasedBrowser {

	public Firefox() {
		super(Driver.FIREFOX);
	}
	
	public Firefox(Driver driver) {
		super(driver);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			firefoxOptions.addArguments(ARGUMENT_PRIVATE_MODE);
		}
		return firefoxOptions;
	}
	
	/**
	 * Creates a new ChromeDriver instance with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		WebDriver webDriver = new FirefoxDriver((FirefoxOptions) getOptions());
		webDriver.manage().window().maximize(); // No argument to start Firefox maximized
		return webDriver;
	}

	@Override
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		WebDriver webDriver = super.getWebDriver(remote);
		webDriver.manage().window().maximize(); // No argument to start Firefox maximized
		return webDriver;
	}
	
}
