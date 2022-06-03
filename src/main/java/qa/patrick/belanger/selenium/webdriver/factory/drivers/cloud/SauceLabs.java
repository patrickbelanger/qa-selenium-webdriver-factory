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

import java.net.MalformedURLException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;
import qa.patrick.belanger.selenium.webdriver.utils.Environment;

/**
 * Sauce Labs class 
 * Returns a RemoteWebDriver connected to Sauce Labs
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class SauceLabs extends Browser {

	private static final String SAUCELAB_ACCESS_KEY = "SAUCELAB_ACCESS_KEY";
	private static final String SAUCELAB_USERNAME = "SAUCELAB_USERNAME";
	
	public SauceLabs() {
		super();
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		return null;
	}

	@Override
	public MutableCapabilities toCapabilities() {
		super.toCapabilities();
		getCapabilities().setCapability("username", Environment.getEnvironmentOrArgument(SAUCELAB_USERNAME, 
				ARGUMENT_USERNAME));
		getCapabilities().setCapability("accessKey", Environment.getEnvironmentOrArgument(SAUCELAB_ACCESS_KEY, 
				ARGUMENT_ACCESS_KEY));
		return getCapabilities();
	}

	protected String getHostUrl() {
		return String.format(getWebDriverProperties().getSauceLabsGridUrl());
	}
	
	/**
	 * Creates a new WebDriver (connected on Sauce Labs hub) with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		throw new UnsupportedCommandException();
	}

	@Override
	public WebDriver getWebDriver(boolean remote) throws MalformedURLException {
		return super.getRemoteWebDriver(remote);
	}

}
