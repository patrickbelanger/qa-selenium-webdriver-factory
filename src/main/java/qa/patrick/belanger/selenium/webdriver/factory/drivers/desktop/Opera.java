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

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.exceptions.WebDriverNotSupportedException;
import qa.patrick.belanger.selenium.webdriver.utils.OperatingSystem;

/**
 * Opera Browser class 
 * Returns a OperaDriver/RemoteWebDriver
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Opera extends ChromiumBasedBrowser {

	public Opera() {
		super(Driver.OPERA);
	}

	public Opera(Driver driver) {
		super(driver);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		OperaOptions operaOptions = new OperaOptions();
		operaOptions.addArguments(ARGUMENT_START_MAXIMIZED);
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			operaOptions.addArguments(ARGUMENT_INCOGNITO_MODE);
		}
		return operaOptions;
	}

	/**
	 * Store a set of OperaOptions in a {@link Capabilities} class
	 */
	@Override
	public Capabilities toCapabilities() {
		return null;
	}

	/**
	 * Creates a new OperaDriver instance with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		return new OperaDriver((OperaOptions) getOptions());
	}

	@Override
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		if (OperatingSystem.isExecutionHostLinux()) { // TODO: To investigate with another browser/driver release
			StringBuilder sb = new StringBuilder()
			    .append("WebDriverFactory: Using OperaDriver locally on Linux is unstable. ")
			    .append("For better stability, consider executing Opera Browser remotely through Selenium Grid on ")
			    .append("a Windows host.");
			logger.warn(sb.toString());
			throw new WebDriverNotSupportedException(sb.toString());
		}
		return super.getWebDriver(remote);
	}

}
