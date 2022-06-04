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
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import qa.patrick.belanger.selenium.webdriver.base.Driver;

/**
 * Chrome Browser class 
 * Returns a ChromeDriver/RemoteWebDriver
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Chrome extends ChromiumBasedBrowser {

	public Chrome() {
		super(Driver.CHROME);
	}

	public Chrome(Driver driver) {
		super(driver);
	}

	@Override
	public MutableCapabilities getOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(ARGUMENT_START_MAXIMIZED);
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			chromeOptions.addArguments(ARGUMENT_INCOGNITO_MODE);
		}
		return chromeOptions;
	}

	/**
	 * Store a set of ChromeOptions in a {@link Capabilities} class
	 */
	@Override
	public Map<String, Object> toW3cCapabilities() {
		super.toW3cCapabilities();
		getW3cCapabilities().put(CapabilityType.BROWSER_NAME, "chrome");
		getW3cCapabilities().put(CapabilityType.BROWSER_VERSION, "latest"); //TODO: Make it parameterizable
		getW3cCapabilities().put(CapabilityType.PLATFORM_NAME, Platform.WIN10); //TODO: Make it parameterizable
		getW3cCapabilities().put(ChromeOptions.CAPABILITY, getOptions());
		return getW3cCapabilities();
	}

	/**
	 * Creates a new ChromeDriver instance with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		return new ChromeDriver((ChromeOptions) getOptions());
	}

	@Override
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		return super.getWebDriver(remote);
	}

}
