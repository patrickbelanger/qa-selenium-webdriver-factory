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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.exceptions.WebDriverNotSupportedException;
import qa.patrick.belanger.selenium.webdriver.utils.OperatingSystem;

/**
 * Brave Browser class
 * Returns a ChromeDriver/RemoteWebDriver (using the binary location of Brave Browser)
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Brave extends Chrome {

	public Brave() {
		super(Driver.BRAVE);
	}
	
	/**
   * Get ChromeOptions (with the binary location of Brave Browser)
   */
	@Override
	public AbstractDriverOptions<?> getOptions() {
		ChromeOptions chromeOptions = (ChromeOptions) super.getOptions(); // Same as Chrome, basically
		if (getWebDriverProperties().useBraveBrowserBinaryPath()) {
			chromeOptions.setBinary(getWebDriverProperties().getBraveBrowserBinaryPath());
		}
		return chromeOptions;
	}
	
	/**
	 * Creates a new ChromeDriver instance with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		if (OperatingSystem.isExecutionHostLinux()) {
			StringBuilder sb = new StringBuilder()
					.append("WebDriverFactory: Using ChromeDriver against Brave Browser locally on Linux is unstable. ")
					.append("For better stability, consider executing Brave Browser remotely through Selenium Grid on ")
					.append("a Windows host.");
			logger.warn(sb.toString());
			throw new WebDriverNotSupportedException(sb.toString());
		}
		return new ChromeDriver((ChromeOptions) getOptions());
	}
	
}
