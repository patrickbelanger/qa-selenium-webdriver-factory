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

package qa.free.tools.selenium.webdriver.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

import qa.free.tools.selenium.webdriver.base.Driver;
import qa.free.tools.selenium.webdriver.base.GridThirdParty;

@Sources({ "classpath:webdriver.properties" })
public interface WebDriverProperties extends Config {

	static final String GRID_HUB_ENDPOINT = "/wd/hub";
	static final String UNIX_WEBDRIVER_PATH = "/usr/local/bin/";

	@Key("brave.browser.binary.path")
	@DefaultValue("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe")
	String getBraveBrowserBinaryPath();

	@Key("brave.browser.use.binary.path")
	@DefaultValue("true") // Browser binary path for Brave Browser must be mentioned
	boolean useBraveBrowserBinaryPath();

	@Key("edge.browser.binary.path")
	@DefaultValue("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe")
	String getEdgeBrowserBinaryPath();

	@Key("edge.browser.use.binary.path")
	@DefaultValue("false") // Not required, but could be required if Edge is executed on a Selenium Grid
	                       // running from a Linux-based execution host
	boolean useEdgeBrowserBinaryPath();

	@Key("opera.browser.binary.path") // Default can't be set since the path could be in the C:\Users\{username} folder
	String getOperaBrowserBinaryPath();

	@Key("opera.browser.use.binary.path")
	@DefaultValue("true") // Browser binary path for Opera Browser must be mentioned
	boolean useOperaBrowserBinaryPath();
	
	
	@Key("browser.private.mode")
	@DefaultValue("true")
	boolean isBrowserPrivateMode();

	@Key("grid.url")
	@DefaultValue("http://localhost")
	String getGridUrl();

	@Key("grid.browerstack.url")
	@DefaultValue("https://%s:%s@hub-cloud.browserstack.com/wd/hub")
	String getBrowserStackGridUrl();
	
	@Key("grid.saucelabs.url")
	@DefaultValue("https://ondemand.us-west-1.saucelabs.com/wd/hub")
	String getSauceLabsGridUrl();
	
	@Key("grid.port")
	@DefaultValue("4444")
	String getGridPort();

	@Key("grid.third.party.provider")
	@DefaultValue("SELENIUM_GRID")
	GridThirdParty getGridThidParty();
	
	@Key("webdriver.default")
	@DefaultValue("CHROME")
	Driver getWebDriverDefault();

	@Key("webdriver.default.path")
	@DefaultValue("classpath:")
	String getWebDriverDefaultPath();

}
