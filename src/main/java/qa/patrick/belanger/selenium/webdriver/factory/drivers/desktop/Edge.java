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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.base.Driver;

/**
 * Edge Browser class 
 * Returns a EdgeDriver/RemoteWebDriver
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Edge extends ChromiumBasedBrowser {

	public Edge() {
		super(Driver.EDGE);
	}

	public Edge(Driver driver) {
		super(driver);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments(ARGUMENT_START_MAXIMIZED);
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			edgeOptions.addArguments(ARGUMENT_INPRIVATE_MODE);
		}
		if (getWebDriverProperties().useEdgeBrowserBinaryPath()) {
			edgeOptions.setBinary(getWebDriverProperties().getEdgeBrowserBinaryPath());
		}
		return edgeOptions;
	}

	/**
	 * Store a set of EdgeOptions in a {@link Capabilities} class
	 */
	@Override
	public Capabilities toCapabilities() {
		return null;
	}

	/**
	 * Creates a new ChromeDriver instance with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		return new EdgeDriver((EdgeOptions) getOptions());
	}

	@Override
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		return super.getWebDriver(remote);
	}

}
