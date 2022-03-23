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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.exceptions.WebDriverNotSupportedException;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public abstract class CloudBasedGrid extends Browser {

	@Getter
	@Setter(AccessLevel.PRIVATE)
	GridThirdParty gridThirdParty;

	/**
	 * Get/Set username (to access cloud-based infrastructure)
	 */
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	String username;
	
	/**
	 * Get/Set access token (or password)
	 */
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	String accessToken;
	
	public CloudBasedGrid(Driver driver) {
		super(driver);
	}

	public CloudBasedGrid(Driver driver, GridThirdParty gridThirdParty) {
		super(driver);
		setGridThirdParty(gridThirdParty);
	}

	@Override
	public AbstractDriverOptions<?> getOptions() {
		return null;
	}
	
	/**
	 * Creates a new RemoteWebDriver instance with specified options.
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	private WebDriver getRemoteWebDriver() throws MalformedURLException {
		return new RemoteWebDriver(new URL(getHostUrl()), toCapabilities());
	}

	
	@Override
	public WebDriver getWebDriver() {
		try {
			return getRemoteWebDriver();
		} catch(MalformedURLException e) {
			throw new WebDriverNotSupportedException("MalformedURLException");
		}
	}
	
}
