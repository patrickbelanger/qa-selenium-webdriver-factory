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

package qa.free.tools.selenium.webdriver.factory.drivers.cloud;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import qa.free.tools.selenium.webdriver.factory.WebDriverFactory;
import qa.free.tools.selenium.webdriver.factory.drivers.Browser;
import qa.free.tools.selenium.webdriver.utils.Environment;

/**
 * BrowserStack class 
 * Returns a RemoteWebDriver connected to BrowserStack (+ required credentials)
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class BrowserStack extends Browser {

	private static final String BROWSERSTACK_ACCESS_KEY = "BROWSERSTACK_ACCESS_KEY";
	private static final String BROWSERSTACK_USERNAME = "BROWSERSTACK_USERNAME";
	
	public BrowserStack() {
		super();
  }
	
	@Override
	protected String getHostUrl() {
		return String.format(getWebDriverProperties().getBrowserStackGridUrl(), 
		    Environment.getEnvironmentOrArgument(BROWSERSTACK_USERNAME, ARGUMENT_USERNAME),
		    Environment.getEnvironmentOrArgument(BROWSERSTACK_ACCESS_KEY, ARGUMENT_ACCESS_KEY)
	  );
	}
	
	/**
	 * Creates a new WebDriver (connected on BrowserStack hub) with the specified options.
	 */
	@Override
	public WebDriver getRemoteWebDriver() {
		if (getOptions() == null) {
			setOptions(WebDriverFactory.getDefaultBrowserOptions(getDriver())); // We need to get the desired options first
		}
		if (getW3cCapabilities().isEmpty()) {
			setW3cCapabilities(new HashMap<>());
		}
		getOptions().setCapability("bstack:options", getW3cCapabilities());
		return super.getRemoteWebDriver();
	}

	@Override
	public WebDriver getWebDriver() {
		return null;
	}

}
