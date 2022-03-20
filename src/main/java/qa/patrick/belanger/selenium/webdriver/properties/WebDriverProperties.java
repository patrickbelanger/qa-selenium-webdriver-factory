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

package qa.patrick.belanger.selenium.webdriver.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

import qa.patrick.belanger.selenium.webdriver.base.Driver;

@Sources({ "classpath:webdriver.properties" })
public interface WebDriverProperties extends Config {

	static final String GRID_HUB_ENDPOINT = "/wd/hub";
	static final String UNIX_WEBDRIVER_PATH = "/usr/local/bin/";

	/* Brave Browser related properties */

	@Key("brave.browser.binary.path")
	@DefaultValue("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe")
	String getBraveBrowserBinaryPath();

	@Key("brave.browser.use.binary.path")
	@DefaultValue("true") // Browser binary path for Brave Browser must be mentioned
	boolean useBraveBrowserBinaryPath();

	/* Edge Browser related properties */

	@Key("edge.browser.binary.path")
	@DefaultValue("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe")
	String getEdgeBrowserBinaryPath();

	@Key("edge.browser.use.binary.path")
	@DefaultValue("false") // Not required, but could be required if Edge is executed on a Selenium Grid
	                       // running from a Linux-based execution host
	boolean useEdgeBrowserBinaryPath();

	/* General browser options */

	@Key("browser.private.mode")
	@DefaultValue("true")
	boolean isBrowserPrivateMode();

	/* Grid related properties */

	@Key("grid.url")
	@DefaultValue("http://localhost")
	String getGridUrl();

	@Key("grid.port")
	@DefaultValue("4444")
	String getGridPort();

	@Key("webdriver.default")
	@DefaultValue("CHROME")
	Driver getWebDriverDefault();

	/* Webdriver related properties */

	@Key("webdriver.default.path")
	@DefaultValue("classpath:")
	String getWebDriverDefaultPath();

}
