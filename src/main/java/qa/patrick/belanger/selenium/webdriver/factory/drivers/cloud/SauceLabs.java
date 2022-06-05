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

package qa.patrick.belanger.selenium.webdriver.factory.drivers.cloud;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;
import qa.patrick.belanger.selenium.webdriver.utils.Environment;

/**
 * Sauce Labs class 
 * Returns a RemoteWebDriver connected to Sauce Labs
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class SauceLabs extends Browser {

	private static final String SAUCELAB_ACCESS_KEY = "SAUCE_ACCESS_KEY";
	private static final String SAUCELAB_USERNAME = "SAUCE_USERNAME";
	
	public SauceLabs() {
		super();
	}

	@Override
	public Map<String, Object> getW3cCapabilities() {
		super.getW3cCapabilities();
		getW3cCapabilities().put("username", Environment.getEnvironmentOrArgument(SAUCELAB_USERNAME, 
				ARGUMENT_USERNAME));
		getW3cCapabilities().put("accessKey", Environment.getEnvironmentOrArgument(SAUCELAB_ACCESS_KEY, 
				ARGUMENT_ACCESS_KEY));
		return getW3cCapabilities();
	}

	protected String getHostUrl() {
		return String.format(getWebDriverProperties().getSauceLabsGridUrl());
	}
	
	/**
	 * Creates a new WebDriver (connected on Sauce Labs hub) with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		return super.getRemoteWebDriver();
	}

}
