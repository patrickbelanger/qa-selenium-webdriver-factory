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

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.Browser;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public abstract class ChromiumBasedBrowser extends Browser {

	/**
	 * Maximize Chromium-based browser window at launch
	 */ 
	public static final String ARGUMENT_START_MAXIMIZED = "--start-maximized";
	/**
	 * Enabling private browsing on Brave/Chrome
	 */
	public static final String ARGUMENT_INCOGNITO_MODE = "--incognito";
	/**
	 * Enabling private browsing on Edge
	 */
	public static final String ARGUMENT_INPRIVATE_MODE = "--inprivate";

	public ChromiumBasedBrowser(Driver driver) {
		super(driver);
	}

}
